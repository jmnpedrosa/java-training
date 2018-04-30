package localization;

import java.util.ListResourceBundle;

/*
 * Example of a ResourceBundle defined in code.
 */

public class ArtShowcaseBundle extends ListResourceBundle {

  @Override
  protected Object[][] getContents() {
    return new Object[][] {
      {"total_bookings", "Total Bookings"},
      {"when", "When"},
      {"price", "Price"},
      {"book_now", "Book Now"},
      {"sample_art", "flag_fish.png"}
    };
  }
  
}
