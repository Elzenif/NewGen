package commons.view;

import commons.Constants;
import commons.view.intf.IMainFrame;
import commons.view.utils.ScreenCheck;
import org.jetbrains.annotations.NonNls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Germain on 31/03/2017.
 */
public abstract class AMainFrame extends JFrame implements IMainFrame {

  private static final Logger LOGGER = LoggerFactory.getLogger(AMainFrame.class);

  protected void manageOptionFile(File file) {
    if (file.exists()) {
      try {
        restoreOptions(file);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      setDefaultBounds("set location by platform");
    }
  }

  private void setDefaultBounds(@NonNls String message) {
    LOGGER.info(message);
    setLocationByPlatform(true);
    setSize(Constants.JFRAME_WIDTH, Constants.JFRAME_HEIGHT);
  }

  private void restoreOptions(File file) throws IOException {
    Properties properties = new Properties();
    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    properties.load(bufferedReader);

    int x = Integer.parseInt(properties.getProperty("x"));
    int y = Integer.parseInt(properties.getProperty("y"));
    int width = Integer.parseInt(properties.getProperty("width"));
    int height = Integer.parseInt(properties.getProperty("height"));

    Rectangle bounds = new Rectangle(x, y, width, height);
    if (ScreenCheck.getVirtualBounds().contains(bounds)) {
      setBounds(bounds);
      @NonNls String message = "set bounds stored in pref";
      LOGGER.info(message);
    } else {
      setDefaultBounds("out of bounds -> back to default properties");
    }
  }


}
