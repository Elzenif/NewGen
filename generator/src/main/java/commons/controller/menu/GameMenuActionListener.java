package commons.controller.menu;

import commons.view.MainFrame;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 08/06/2016.
 */
public class GameMenuActionListener implements ActionListener {

  private final JPanel cardPanel;
  private final String gameName;

  public GameMenuActionListener(MainFrame view, String gameName) {
    this.gameName = gameName;
    cardPanel = view.getEntityPanel();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ((CardLayout) cardPanel.getLayout()).show(cardPanel, gameName);
  }
}
