package localization;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/*
 * You can use DateFormat.getDateTimeInstance() to return the
 * date and time based on the default or an explicit Locale.
 * 
 * Some symbols may not be encoded for visibility in a,
 * console output, but they will display correctly on a UI
 * component.
 */

public class FormattingDates2 {
  
  static int[] styles = new int[]{ DateFormat.FULL,
      DateFormat.LONG,
      DateFormat.MEDIUM,
      DateFormat.SHORT
     };
  
  static String[] desc = new String[]{"FULL","LONG","MEDIUM","SHORT"};
  
  static JTextArea textArea = new JTextArea();
  
  public static void main(String[] args) {
    JFrame f = new JFrame("Currency");
    f.getContentPane().add(textArea);
    f.setSize(300, 400);
    Date date = new Date();
    defaultLocale(date);
    specificLocale(Locale.GERMANY, date);
    specificLocale(Locale.FRANCE, date);
    specificLocale(Locale.CHINA, date);
    f.setVisible(true);
  }
  
  static void defaultLocale(Date date) {
    msg("\nDefault Locale:");
    for (int style : styles) {
      // Calling getDateTimeInstance() without specifying a locale
      // will apply the default locale.
      DateFormat nfDefault = DateFormat.getDateInstance(style);
      msg(desc[style]+"\t:" + nfDefault.format(date));
    }
  }
  
  static void specificLocale(Locale locale, Date date) {
    msg("\n"+locale.getDisplayCountry());
    for (int style : styles) {
      DateFormat spec = DateFormat.getDateInstance(style, locale);
      msg(desc[style]+"\t:" + spec.format(date));
    }
  }
  
  static void msg(String str) { textArea.append("\n" + str); }
}
