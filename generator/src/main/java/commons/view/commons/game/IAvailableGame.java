package commons.view.commons.game;

import commons.model.commons.Game;

/**
 * Created by Germain on 08/10/2016.
 */
public interface IAvailableGame {

  Game getGame();

  boolean isDefault();

  GameTabbedPanelEmbedded getGameTabbedPanelEmbedded();
}
