package commons;

import commons.view.MainFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import static commons.Constants.BENGUIAB_FONT;
import static commons.Constants.DAUPHINN_FONT;
import static commons.Constants.LITHOGRB_FONT;
import static commons.Constants.LITHOGRL_FONT;

/**
 * Created by Germain on 01/05/2016.
 */
public class Main {

  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

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

  @SuppressWarnings({"SpellCheckingInspection", "HardCodedStringLiteral"})
  private static void initFonts() {
    try {
      DAUPHINN_FONT = MainHelper.initFont("DAUPHINN", 4f);
      BENGUIAB_FONT = MainHelper.initFont("BENGUIAB", 0f);
      LITHOGRB_FONT = MainHelper.initFont("LITHOGRB", 0f);
      LITHOGRL_FONT = MainHelper.initFont("LITHOGRL", 0f);
    } catch (IOException | FontFormatException e) {
      LOGGER.error("Cannot load fonts");
      e.printStackTrace();
    }
  }

}
