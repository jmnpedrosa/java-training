package localization;

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/*
 * You can use NumberFormat.getCurrency() to return the
 * currency based on the default or an explicit Locale.
 * 
 * Some symbols may not be encoded for visibility in a,
 * console output, but they will display correctly on a UI
 * component.
 */

public class FormattingCurrency2 {
  
  static JTextArea textArea = new JTextArea();
  
  public static void main(String[] args) {
    JFrame f = new JFrame("Currency");
    f.getContentPane().add(textArea);
    f.setSize(300, 400);
    double ammount = 12345.6789;
    defaultLocale(ammount);
    specificLocale(Locale.UK, ammount);
    specificLocale(Locale.GERMANY, ammount);
    specificLocale(Locale.FRANCE, ammount);
    specificLocale(Locale.US, ammount);
    specificLocale(Locale.JAPAN, ammount);
    f.setVisible(true);
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
    msg("\n"+locale.getDisplayCountry() + " Currency: "+nfSpec.getCurrency());
    msg("formatted amt: " + nfSpec.format(num));
  }
  
  static void msg(String str) { textArea.append("\n" + str); }
}
