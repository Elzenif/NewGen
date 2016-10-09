package commons.view.commons.game;

import commons.model.commons.Game;
import nbk.model.commons.NbkGame;
import nbk.view.commons.NbkTabbedPanelEmbedded;

import java.util.Arrays;

/**
 * Created by Germain on 12/06/2016.
 */
public enum EAvailableGame implements IAvailableGame {

  NBK(NbkGame.getInstance(), true, new NbkTabbedPanelEmbedded());

  public static final int NB_GAMES = EAvailableGame.values().length;
  private final Game game;
  private final boolean def;
  private final GameTabbedPanelEmbedded gameTabbedPanelEmbedded;

  EAvailableGame(Game game, boolean def, GameTabbedPanelEmbedded gameTabbedPanelEmbedded) {
    this.game = game;
    this.def = def;
    this.gameTabbedPanelEmbedded = gameTabbedPanelEmbedded;
  }

  public static Game getDefault() {
    return Arrays.stream(EAvailableGame.values())
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
    return def;
  }

  @Override
  public GameTabbedPanelEmbedded getGameTabbedPanelEmbedded() {
    return gameTabbedPanelEmbedded;
  }

}
