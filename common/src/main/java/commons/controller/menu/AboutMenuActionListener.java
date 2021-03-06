package commons.controller.menu;

import commons.view.AMainFrame;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 08/10/2016.
 */
public class AboutMenuActionListener implements ActionListener {

  private final AMainFrame mainFrame;

  public AboutMenuActionListener(AMainFrame mainFrame) {
    this.mainFrame = mainFrame;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(mainFrame, resourceBundle.getString("menu.help.about.message"),
        resourceBundle.getString("menu.help.about"), JOptionPane.INFORMATION_MESSAGE);
  }
}
