package commons;

import commons.view.PkMainFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import static commons.Constants.PKMON_FONT;


/**
 * Created by Germain on 31/03/2017.
 */
public class PkMain {

  private static final Logger LOGGER = LoggerFactory.getLogger(PkMain.class);

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    initFonts();
    MainHelper.setUIFont(new FontUIResource(Constants.SOURCE_CODE_PRO, Font.PLAIN, Constants.FONT_SIZE_INT));
    SwingUtilities.invokeLater(PkMainFrame::new);
  }

  @SuppressWarnings("SpellCheckingInspection")
  private static void initFonts() {
    try {
      PKMON_FONT = MainHelper.initFont("PKMNDB", 0f);
    } catch (IOException | FontFormatException e) {
      LOGGER.error("Cannot load fonts");
    }
  }
}
