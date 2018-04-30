package localization;

import java.util.Locale;
import java.util.MissingResourceException;

/*
 * Examples of how Locales are used and created in Java
 */

public class LocaleExamples {
  
  public static void main(String[] args) {
    
    System.out.println("Default Locale: " + Locale.getDefault());
    Locale.setDefault(Locale.ITALY);
    
    // Returns a list of all available locales in the current system
    Locale[] all = Locale.getAvailableLocales();
    
    Locale loc = new Locale("fr", "FR");
    
    System.out.println("Code Country: " + loc.getCountry());
    System.out.println("Code Language: " + loc.getLanguage());
    System.out.println("Display Country: " + loc.getDisplayCountry());
    System.out.println("Display Language: " + loc.getDisplayLanguage());
    System.out.println("Display Name: " + loc.getDisplayName());
    
    System.out.println();
    
    // Using a Locale.Builder
    Locale.Builder builder = new Locale.Builder();
    builder.setRegion("620");
    Locale locale = builder.build();
    
    try {
      System.out.println("ISO 3166-1 Country: " + locale.getISO3Country());
    } catch (MissingResourceException e) {
      System.out.println("ISO 3166-1 Country: " + e);
    }
    System.out.println("Code Country: " + locale.getCountry());
    System.out.println("Code Language: " + locale.getLanguage());
    System.out.println("Display Country: " + locale.getDisplayCountry());
    System.out.println("Display Language: " + locale.getDisplayLanguage());
    System.out.println("Display Name: " + locale.getDisplayName());
    
  }
}
