package commons.controller.menu;

import commons.utils.CollectionUtils;
import commons.view.MainFrame;
import commons.view.commons.EGame;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Germain on 08/06/2016.
 */
public class GameMenuActionListener implements ActionListener {

  private final Set<JPanel> cardPanels;
  private final String gameName;

  public GameMenuActionListener(MainFrame view, String gameName) {
    this.gameName = gameName;
    cardPanels = CollectionUtils.setMaxSizeSet(new HashSet<>(), EGame.NB_GAMES);
    cardPanels.add(view.getEntityPanel());
    cardPanels.add(view.getHiddenPanel());
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    cardPanels.forEach(jPanel -> ((CardLayout) jPanel.getLayout()).show(jPanel, gameName));
  }
}
