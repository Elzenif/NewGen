package commons.view;

import commons.controller.intf.Controller;
import commons.view.commons.GameTabbedPanel;
import commons.view.menu.MainMenu;
import commons.view.utils.Constants;

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Germain on 07/05/2016.
 */
public class MainFrame extends JFrame {

  private MainMenu mainMenu;
  private GameTabbedPanel tabbedPane;

  private final List<Controller> controllers = new ArrayList<>();

  public MainFrame() throws HeadlessException {
    setUpUIComponents();
    setControllers();

    setTitle("Generator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(Constants.JFRAME_WIDTH, Constants.JFRAME_HEIGHT);
    setResizable(true);
    setVisible(true);
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
    controllers.forEach(controller -> controller.setControllers(this));
  }

  public GameTabbedPanel getGameTabbedPanel() {
    return tabbedPane;
  }
}
