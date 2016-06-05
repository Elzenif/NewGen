package mvc;

import mvc.view.MainFrame;

import javax.swing.*;
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
      setUIFont(new FontUIResource("Source Code Pro", Font.PLAIN, 12));
    } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException
            | IllegalAccessException e) {
      e.printStackTrace();
    }

    new MainFrame();
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
