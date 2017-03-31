package commons.view.commons.game;

import commons.controller.intf.Controller;
import commons.utils.CollectionUtils;
import commons.view.MainFrame;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Germain on 24/07/2016.
 */
public class GameTabbedPanel extends JPanel {

  private final CardLayout cardLayout;
  private final Set<GameTabbedPanelEmbedded> tabbedPanels;

  private final List<Controller<MainFrame>> controllers = new ArrayList<>();

  public GameTabbedPanel() {

    cardLayout = new CardLayout();
    setLayout(cardLayout);
    tabbedPanels = CollectionUtils.setMaxSizeSet(new HashSet<>(), EAvailableGame.NB_GAMES);

    Arrays.stream(EAvailableGame.values()).forEach(game -> {
      GameTabbedPanelEmbedded gameTabbedPanelEmbedded = game.getGameTabbedPanelEmbedded();
      tabbedPanels.add(gameTabbedPanelEmbedded);
      controllers.add(gameTabbedPanelEmbedded);
      add(game.getGame().getName(), gameTabbedPanelEmbedded);
    });

    cardLayout.show(this, EAvailableGame.getDefault().getName());
  }

  public List<Controller<MainFrame>> getControllers() {
    return controllers;
  }
}
