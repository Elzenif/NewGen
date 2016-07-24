package commons.controller.menu;

import commons.view.MainFrame;
import commons.view.commons.GameTabbedPanel;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 08/06/2016.
 */
public class GameMenuActionListener implements ActionListener {

  private final MainFrame mainFrame;
  private final String gameName;

  public GameMenuActionListener(MainFrame view, String gameName) {
    this.mainFrame = view;
    this.gameName = gameName;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    GameTabbedPanel tabbedPanel = mainFrame.getGameTabbedPanel();
    ((CardLayout) tabbedPanel.getLayout()).show(tabbedPanel, gameName);
  }
}
