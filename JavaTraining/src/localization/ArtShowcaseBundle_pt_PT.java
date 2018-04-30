package localization;

import java.util.ListResourceBundle;

/*
 * Example of a ResourceBundle defined in code.
 */

public class ArtShowcaseBundle_pt_PT extends ListResourceBundle {

  @Override
  protected Object[][] getContents() {
    return new Object[][] {
      {"total_bookings", "Total de reservas"},
      {"when", "Quando"},
      {"price", "Preço"},
      {"book_now", "Reservar agora"},
      {"sample_art", "mango_stripes.png"},
    };
  }

}
