package pk;

import commons.Constants;
import commons.MainHelper;
import pk.view.MainFrame;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;


/**
 * Created by Germain on 31/03/2017.
 */
public class Main {

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    initFonts();
    MainHelper.setUIFont(new FontUIResource(Constants.SOURCE_CODE_PRO, Font.PLAIN, Constants.FONT_SIZE_INT));
    SwingUtilities.invokeLater(MainFrame::new);
  }

  private static void initFonts() {
  }
}
