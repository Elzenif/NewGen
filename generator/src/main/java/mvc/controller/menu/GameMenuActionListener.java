package mvc.controller.menu;

import mvc.view.MainFrame;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 08/06/2016.
 */
public class GameMenuActionListener implements ActionListener {

  private final JPanel cardOptionPanel;
  private final JPanel cardResultPanel;
  private final String gameName;

  public GameMenuActionListener(MainFrame view, String gameName) {
    cardOptionPanel = view.getEntityPanel().getLeftPanel();
    cardResultPanel = view.getEntityPanel().getRightPanel();
    this.gameName = gameName;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ((CardLayout) cardOptionPanel.getLayout()).show(cardOptionPanel, gameName);
    ((CardLayout) cardResultPanel.getLayout()).show(cardResultPanel, gameName);
  }
}
