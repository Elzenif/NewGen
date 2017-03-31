package pk.view;

import commons.controller.intf.Controller;
import org.jetbrains.annotations.NonNls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.JFrame;
import java.awt.MenuBar;
import java.util.ArrayList;
import java.util.List;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 31/03/2017.
 */
public class MainFrame extends JFrame {

  @NonNls
  public static final String GUI_PROP_FILE = "gui.properties";
  private static final Logger LOGGER = LoggerFactory.getLogger(MainFrame.class);
  private final List<Controller> controllers = new ArrayList<>();
  private MenuBar menuBar;


  public MainFrame() {

    setTitle(resourceBundle.getString("title"));
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    setResizable(true);
    setVisible(true);
  }
}
