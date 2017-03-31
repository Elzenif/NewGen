package commons;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/**
 * Created by Germain on 31/03/2017.
 */
public final class MainHelper {

  public static Font initFont(String name, float sizeInc) throws IOException, FontFormatException {
    String pathname = "/fonts/" + name + ".TTF";
    InputStream is = new BufferedInputStream(Thread.currentThread().getClass().getResourceAsStream(pathname));
    Font font = Font.createFont(Font.TRUETYPE_FONT, is);
    is.close();
    return font.deriveFont(Constants.FONT_SIZE_FLOAT + sizeInc);
  }

  public static void setUIFont(FontUIResource font) {
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
