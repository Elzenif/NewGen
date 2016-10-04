package commons.controller;

import commons.view.MainFrame;

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

  private final Frame frame;

  public MainFrameWindowListener(Frame frame) {
    this.frame = frame;
  }

  @Override
  public void windowClosing(WindowEvent e) {
    // restore the frame from full screen
    frame.setExtendedState(Frame.NORMAL);
    Rectangle bounds = frame.getBounds();
    int x = (int) bounds.getX();
    int y = (int) bounds.getY();
    int width = (int) bounds.getWidth();
    int height = (int) bounds.getHeight();

    File file = new File(MainFrame.GUI_PROP_FILE);
    Properties properties = new Properties();
    properties.setProperty("x", "" + x);
    properties.setProperty("y", "" + y);
    properties.setProperty("width", "" + width);
    properties.setProperty("height", "" + height);

    try {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
      properties.store(bufferedWriter, "Properties of the user frame");
    } catch (IOException e1) {
      e1.printStackTrace();
    }

    System.out.println("Storing preferences " + x + ", " + y + ", " + width + ", " + height);
    System.exit(0);
  }
}
