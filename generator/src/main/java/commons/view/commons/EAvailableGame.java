package commons.view.commons;

import commons.model.commons.Game;
import nbk.model.commons.NbkGame;
import nbk.view.commons.NbkTabbedPanelEmbedded;

import java.util.Arrays;

/**
 * Created by Germain on 12/06/2016.
 */
public enum EAvailableGame implements IAvailableGame {

  NBK(NbkGame.getInstance(), true) {
    GameTabbedPanelEmbedded gameTabbedPanelEmbedded = null;
    @Override
    public GameTabbedPanelEmbedded getGameTabbedPanelEmbedded() {
      if (gameTabbedPanelEmbedded == null)
        gameTabbedPanelEmbedded = new NbkTabbedPanelEmbedded();
      return gameTabbedPanelEmbedded;
    }
  };

  public static final int NB_GAMES = EAvailableGame.values().length;
  private final Game game;
  private final boolean isDefault;

  EAvailableGame(Game game, boolean isDefault) {
    this.game = game;
    this.isDefault = isDefault;
  }

  public static Game getDefault() {
    return Arrays.stream(EAvailableGame.values())
        .filter(EAvailableGame::isDefault)
        .findFirst()
        .map(EAvailableGame::getGame)
        .orElse(NBK.getGame());
  }

  @Override
  public Game getGame() {
    return game;
  }

  @Override
  public boolean isDefault() {
    return isDefault;
  }

}
