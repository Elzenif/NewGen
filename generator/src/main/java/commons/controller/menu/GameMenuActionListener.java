package commons.controller.menu;

import commons.view.GameMainFrame;
import commons.view.commons.game.GameTabbedPanel;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 08/06/2016.
 */
public class GameMenuActionListener implements ActionListener {

  private final GameMainFrame mainFrame;
  private final String gameName;

  public GameMenuActionListener(GameMainFrame view, String gameName) {
    this.mainFrame = view;
    this.gameName = gameName;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    GameTabbedPanel tabbedPanel = mainFrame.getGameTabbedPanel();
    ((CardLayout) tabbedPanel.getLayout()).show(tabbedPanel, gameName);
  }
}
