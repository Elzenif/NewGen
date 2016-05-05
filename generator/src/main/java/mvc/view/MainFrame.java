package mvc.view;

import mvc.view.menu.MainMenu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Germain on 01/05/2016.
 */
public class MainFrame extends JFrame {
  private final JMenuBar mainMenu = new MainMenu();
  private JPanel mainPanel;
  private JTabbedPane tabbedPane1;
  private JPanel DefaultPanel;

  public MainFrame() throws HeadlessException {
    setContentPane(mainPanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Generator");
    setSize(800, 600);

    setJMenuBar(mainMenu);
  }



  {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
    $$$setupUI$$$();
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer
   * >>> IMPORTANT!! <<<
   * DO NOT edit this method OR call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    mainPanel = new JPanel();
    mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(5, 5, 5, 5), -1, -1));
    mainPanel.setBorder(BorderFactory.createTitledBorder(""));
    tabbedPane1 = new JTabbedPane();
    mainPanel.add(tabbedPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
    DefaultPanel = new JPanel();
    DefaultPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
    tabbedPane1.addTab("Default", null, DefaultPanel, "Useful to hide other tabs");
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return mainPanel;
  }
}
