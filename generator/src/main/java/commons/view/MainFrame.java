package commons.view;

import commons.controller.MainFrameWindowListener;
import commons.controller.intf.Controller;
import commons.view.commons.GameTabbedPanel;
import commons.view.menu.MainMenu;
import commons.view.utils.Constants;
import commons.view.utils.ScreenCheck;
import org.jetbrains.annotations.NonNls;

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 07/05/2016.
 */
public class MainFrame extends JFrame {

  @NonNls
  public static final String GUI_PROP_FILE = "gui.properties";
  private final List<Controller> controllers = new ArrayList<>();
  private MainMenu mainMenu;
  private GameTabbedPanel tabbedPane;

  public MainFrame() throws HeadlessException {
    setUpUIComponents();
    setControllers();

    setTitle(resourceBundle.getString("title"));
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


    File file = new File(GUI_PROP_FILE);
    if (file.exists()) {
      try {
        restoreOptions(file);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      setDefaultBounds("set location by platform");
    }
    setResizable(true);
    setVisible(true);
  }

  private void setDefaultBounds(@NonNls String message) {
    System.out.println(message);
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
      System.out.println(message);
    } else {
      setDefaultBounds("out of bounds -> back to default properties");
    }
  }

  private void setUpUIComponents() {
    Container container = getContentPane();

    mainMenu = new MainMenu();
    setJMenuBar(mainMenu);
    controllers.add(mainMenu);

    tabbedPane = new GameTabbedPanel();
    controllers.addAll(tabbedPane.getControllers());

    container.add(tabbedPane);
  }

  private void setControllers() {
    addWindowListener(new MainFrameWindowListener(this));
    controllers.forEach(controller -> controller.setControllers(this));
  }

  public GameTabbedPanel getGameTabbedPanel() {
    return tabbedPane;
  }
}
