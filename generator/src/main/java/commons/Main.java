package commons;

import commons.view.MainFrame;
import commons.view.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Enumeration;

import static commons.view.utils.Constants.BENGUIAB_FONT;
import static commons.view.utils.Constants.DAUPHINN_FONT;
import static commons.view.utils.Constants.FONT_SIZE_FLOAT;
import static commons.view.utils.Constants.LITHOGRB_FONT;
import static commons.view.utils.Constants.LITHOGRL_FONT;

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
    setUIFont(new FontUIResource(Constants.SOURCE_CODE_PRO, Font.PLAIN, Constants.FONT_SIZE_INT));
    SwingUtilities.invokeLater(MainFrame::new);
  }

  @SuppressWarnings({"SpellCheckingInspection", "HardCodedStringLiteral"})
  private static void initFonts() {
    try {
      DAUPHINN_FONT = initFont("DAUPHINN", 4f);
      BENGUIAB_FONT = initFont("BENGUIAB", 0f);
      LITHOGRB_FONT = initFont("LITHOGRB", 0f);
      LITHOGRL_FONT = initFont("LITHOGRL", 0f);
    } catch (IOException | FontFormatException | URISyntaxException e) {
      LOGGER.error("Cannot load fonts");
      e.printStackTrace();
    }
  }

  private static Font initFont(String name, float sizeInc) throws IOException, FontFormatException, URISyntaxException {
    String pathname = "/fonts/" + name + ".TTF";
    InputStream is = new BufferedInputStream(Thread.currentThread().getClass().getResourceAsStream(pathname));
    Font font = Font.createFont(Font.TRUETYPE_FONT, is);
    is.close();
    return font.deriveFont(FONT_SIZE_FLOAT + sizeInc);
  }

  private static void setUIFont(FontUIResource font) {
    Enumeration keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      Object value = UIManager.get(key);
      if (value != null && value instanceof FontUIResource) {
        UIManager.put(key, font);
      }
    }
  }
}
