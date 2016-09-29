package commons;

import commons.view.MainFrame;
import commons.view.utils.Constants;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;
import java.util.Enumeration;

/**
 * Created by Germain on 01/05/2016.
 */
public class Main {

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      setUIFont(new FontUIResource(Constants.FONT_NAME, Font.PLAIN, Constants.FONT_SIZE));
    } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException
            | IllegalAccessException e) {
      e.printStackTrace();
    }
    SwingUtilities.invokeLater(MainFrame::new);
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
