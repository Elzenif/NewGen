package commons.controller;

import commons.view.AMainFrame;
import org.jetbrains.annotations.NonNls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Germain on 04/10/2016.
 */
public class MainFrameWindowListener extends WindowAdapter {

  private static final Logger LOGGER = LoggerFactory.getLogger(MainFrameWindowListener.class);

  private final AMainFrame mainFrame;

  public MainFrameWindowListener(AMainFrame mainFrame) {
    this.mainFrame = mainFrame;
  }

  @Override
  public void windowClosing(WindowEvent e) {
    // restore the mainFrame from full screen
    mainFrame.setExtendedState(Frame.NORMAL);
    Rectangle bounds = mainFrame.getBounds();
    int x = (int) bounds.getX();
    int y = (int) bounds.getY();
    int width = (int) bounds.getWidth();
    int height = (int) bounds.getHeight();

    File file = new File(mainFrame.getGuiPropFile());
    Properties properties = new Properties();
    properties.setProperty("x", "" + x);
    properties.setProperty("y", "" + y);
    properties.setProperty("width", "" + width);
    properties.setProperty("height", "" + height);

    try {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
      @NonNls String comments = "Properties of the user mainFrame";
      properties.store(bufferedWriter, comments);
    } catch (IOException e1) {
      e1.printStackTrace();
    }

    @NonNls String message = "Storing preferences " + x + ", " + y + ", " + width + ", " + height;
    LOGGER.info(message);
    System.exit(0);
  }
}
