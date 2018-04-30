package localization;

import java.text.NumberFormat;
import java.util.Locale;

/*
 * You can use NumberFormat.getCurrency() to return the
 * currency based on the default or an explicit Locale.
 */

public class FormattingCurrency {
  
  public static void main(String[] args) {
    double ammount = 12345.6789;
    defaultLocale(ammount);
    specificLocale(Locale.UK, ammount);
    specificLocale(Locale.GERMANY, ammount);
    specificLocale(Locale.FRANCE, ammount);
    specificLocale(Locale.US, ammount);
    specificLocale(Locale.JAPAN, ammount);
  }
  
  static void defaultLocale(double num) {
    // Calling getCurrencyInstance() without specifying a locale
    // will apply the default locale.
    NumberFormat nfDefault = NumberFormat.getCurrencyInstance();
    msg("\nDefault Locale Currency: " + nfDefault.getCurrency());
    msg("formatted amt: " + nfDefault.format(num));
  }
  
  static void specificLocale(Locale locale, double num) {
    NumberFormat nfSpec = NumberFormat.getCurrencyInstance(locale);
    msg("\n"+locale.getDisplayCountry() + " Currency: " + nfSpec.getCurrency());
    msg("formatted amt: " + nfSpec.format(num));
  }
  
  static void msg(String str) { System.out.println (str); }
}
