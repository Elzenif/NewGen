package commons.view.commons;

import commons.controller.intf.Controller;
import commons.utils.CollectionUtils;

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

  private final List<Controller> controllers = new ArrayList<>();

  public GameTabbedPanel() {

    cardLayout = new CardLayout();
    setLayout(cardLayout);
    tabbedPanels = CollectionUtils.setMaxSizeSet(new HashSet<>(), EGame.NB_GAMES);

    Arrays.stream(EGame.values()).forEach(eGame -> {
      GameTabbedPanelEmbedded gameTabbedPanelEmbedded = eGame.getGameTabbedPanelEmbedded();
      tabbedPanels.add(gameTabbedPanelEmbedded);
      controllers.add(gameTabbedPanelEmbedded);
      add(eGame.getGame().getName(), gameTabbedPanelEmbedded);
    });

    cardLayout.show(this, EGame.getDefault().getName());
  }

  public List<Controller> getControllers() {
    return controllers;
  }
}