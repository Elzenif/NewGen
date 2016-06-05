package mvc.view;

import mvc.view.commons.Constants;
import mvc.view.dice.DicePanel;
import mvc.view.entity.EntityPanel;
import mvc.view.menu.MainMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.Container;
import java.awt.HeadlessException;

/**
 * Created by Germain on 07/05/2016.
 */
public class MainFrame extends JFrame {

  public MainFrame() throws HeadlessException {
    setUpUIComponents();

    setTitle("Generator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(Constants.JFRAME_WIDTH, Constants.JFRAME_HEIGHT);
    setResizable(true);
    setVisible(true);
  }

  private void setUpUIComponents() {
    Container container = getContentPane();
    setJMenuBar(new MainMenu());

    JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
    tabbedPane.addTab("Hidden", new JPanel());
    tabbedPane.addTab("Dice", new DicePanel());
    tabbedPane.addTab("Entity", new EntityPanel());
    container.add(tabbedPane);
  }

}
