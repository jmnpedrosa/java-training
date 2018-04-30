package localization;

import java.text.NumberFormat;
import java.util.Locale;

/*
 * You can use NumberFormat.getInstance() to return a
 * number visually formatted according to a default or 
 * an explicit Locale.
 */

public class FormattingNumbers {
  
  public static void main(String[] args) {
    double num = 12345.6789;
    defaultLocale(num);
    specificLocale(Locale.GERMANY, num);
    specificLocale(Locale.FRANCE, num);
    specificLocale(Locale.US, num);
  }
  
  static void defaultLocale(double num) {
    NumberFormat nfDefault = NumberFormat.getInstance();
    msg("\nDefaultLocale");
    msg("Formatting: " + nfDefault.format(num));
    try {
      msg("parsing: " + nfDefault.parse("12345.1111"));
    } catch (java.text.ParseException e) {
      msg(e.toString());
    }
  }
  
  static void specificLocale(Locale locale, double num) {
    NumberFormat nfSpecific = NumberFormat.getInstance(locale);
    msg("\n"+locale.getDisplayCountry());
    msg("formatting: " + nfSpecific.format(num));
    try {
      msg("parsing : " + nfSpecific.parse("12345.1111"));
    }
    catch (java.text.ParseException e) {
      msg(e.toString());
    }
  }
  
  static void msg(String str) { System.out.println(str); }
}
