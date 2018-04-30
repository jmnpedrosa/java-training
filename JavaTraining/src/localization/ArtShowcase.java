package localization;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * A demo that exemplifies how to load custom resources like 
 * text and image paths from a Resource Bundle, based on a 
 * given Locale.
 */

public class ArtShowcase {
  JFrame f = new JFrame("BookNow");
  JLabel lTotalBookings = new JLabel();
  JLabel lWhen = new JLabel();
  JLabel lPrice = new JLabel();
  JLabel lImage;
  JButton btnBook = new JButton();

  private void buildShowUI() {
    f.getContentPane().setLayout(new FlowLayout());
    f.setSize(300, 400);
    f.getContentPane().add(lTotalBookings);
    f.getContentPane().add(lImage);
    JPanel panel1 = new JPanel();
    panel1.setLayout(new GridLayout(4, 1));
    panel1.add(lWhen);
    panel1.add(lPrice);
    panel1.add(new JLabel(""));
    panel1.add(btnBook);
    f.getContentPane().add(panel1);
    f.setVisible(true);
  }

  private void setLocaleSpecificData(Locale locale) {
    // Retrieve resource bundle called ArtShowcaseBundle from subdirectory
    // resource-bundle passing it a locale.
    ResourceBundle labels = ResourceBundle.getBundle("resource-bundle.ArtShowcaseBundle", locale);
    String text = null;
    text = labels.getString("total_bookings");
    lTotalBookings.setText(text);
    text = labels.getString("when");
    lWhen.setText(text);
    text = labels.getString("price");
    lPrice.setText(text);
    text = labels.getString("book_now");
    btnBook.setText(text);
    ImageIcon artImage = new ImageIcon(labels.getString("sample_art"));
    lImage = new JLabel(artImage);
  }

  public static void main(String[] args) {
    ArtShowcase as = new ArtShowcase();
    as.setLocaleSpecificData(new Locale("pt", "PT"));
    // as.setLocaleSpecificData(Locale.FRANCE);
    as.buildShowUI();
  }

}
