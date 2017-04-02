package commons.view;

import commons.controller.MainFrameWindowListener;
import commons.controller.intf.Controller;
import commons.view.commons.PkTabbedPanel;
import org.jetbrains.annotations.NonNls;
import commons.view.menu.MenuBar;

import javax.swing.JFrame;

import java.awt.Container;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 31/03/2017.
 */
public class PkMainFrame extends AMainFrame {

  @NonNls
  private static final String GUI_PROP_FILE = "gui.properties";
  private final List<Controller<PkMainFrame>> controllers = new ArrayList<>();
  private MenuBar menuBar;
  private PkTabbedPanel tabbedPanel;

  public PkMainFrame() {
    setUpUIComponents();
    setControllers();

    setTitle(resourceBundle.getString("title"));
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    manageOptionFile(new File(GUI_PROP_FILE));

    setResizable(true);
    setVisible(true);
  }

  @Override
  public String getGuiPropFile() {
    return GUI_PROP_FILE;
  }

  private void setUpUIComponents() {
    Container contentPane = getContentPane();

    menuBar = new MenuBar();
    setJMenuBar(menuBar);
    controllers.add(menuBar);

    tabbedPanel = new PkTabbedPanel();
    controllers.addAll(tabbedPanel.getControllers());

    contentPane.add(tabbedPanel);
  }

  private void setControllers() {
    addWindowListener(new MainFrameWindowListener(this));
    controllers.forEach(controller -> controller.setControllers(this));
  }

}
