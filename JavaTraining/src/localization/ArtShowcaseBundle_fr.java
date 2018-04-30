package localization;

import java.util.ListResourceBundle;

/*
 * Example of a ResourceBundle defined in code.
 */

public class ArtShowcaseBundle_fr extends ListResourceBundle {

  @Override
  protected Object[][] getContents() {
    return new Object[][] {
      {"total_bookings", "Réservations totales"},
      {"when", "Lors de"},
      {"price", "Prix"},
      {"book_now", "Réserver"},
      {"sample_art", "flag_mango_oval.png"}
    };
  }

}
