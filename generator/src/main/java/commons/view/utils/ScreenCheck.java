package commons.view.utils;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

/**
 * Created by Germain on 04/10/2016.
 */
public class ScreenCheck {

  public static Rectangle getVirtualBounds() {
    Rectangle bounds = new Rectangle(0, 0, 0, 0);
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice lstGDs[] = ge.getScreenDevices();
    for (GraphicsDevice gd : lstGDs) {
      bounds.add(gd.getDefaultConfiguration().getBounds());
    }
    return bounds;
  }

}
