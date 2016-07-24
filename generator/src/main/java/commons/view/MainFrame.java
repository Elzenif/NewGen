package commons.view;

import commons.controller.intf.Controller;
import commons.view.dice.DicePanel;
import commons.view.entity.EntityPanel;
import commons.view.hidden.HiddenPanel;
import commons.view.menu.MainMenu;
import commons.view.utils.Constants;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.Container;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Germain on 07/05/2016.
 */
public class MainFrame extends JFrame {

  private MainMenu mainMenu;
  private HiddenPanel hiddenPanel;
  private DicePanel dicePanel;
  private EntityPanel entityPanel;

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

  public MainMenu getMainMenu() {
    return mainMenu;
  }

  public JPanel getHiddenPanel() {
    return hiddenPanel;
  }

  public DicePanel getDicePanel() {
    return dicePanel;
  }

  public EntityPanel getEntityPanel() {
    return entityPanel;
  }

  private void setUpUIComponents() {
    Container container = getContentPane();
    mainMenu = new MainMenu();
    setJMenuBar(mainMenu);
    controllers.add(mainMenu);

    JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);

    hiddenPanel = new HiddenPanel();
    tabbedPane.addTab("Hidden", hiddenPanel);

    dicePanel = new DicePanel();
    controllers.add(dicePanel);
    tabbedPane.addTab("Dice", dicePanel);

    entityPanel = new EntityPanel();
    controllers.add(entityPanel);
    tabbedPane.addTab("Entity", entityPanel);

    container.add(tabbedPane);
  }

  private void setControllers() {
    controllers.forEach(controller -> controller.setControllers(this));
  }
}
