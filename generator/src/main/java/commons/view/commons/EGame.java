package commons.view.commons;

import commons.model.commons.Game;
import nbk.model.commons.NbkGame;
import nbk.view.commons.NbkTabbedPanelEmbedded;
import tes.model.commons.TesGame;
import tes.view.commons.TesTabbedPanelEmbedded;

import java.util.Arrays;

/**
 * Created by Germain on 12/06/2016.
 */
public enum EGame {

  NBK(NbkGame.getInstance(), true) {
    GameTabbedPanelEmbedded gameTabbedPanelEmbedded = null;
    @Override
    public GameTabbedPanelEmbedded getGameTabbedPanelEmbedded() {
      if (gameTabbedPanelEmbedded == null)
        gameTabbedPanelEmbedded = new NbkTabbedPanelEmbedded();
      return gameTabbedPanelEmbedded;
    }
  },
  TES(TesGame.getInstance(), false) {
    GameTabbedPanelEmbedded gameTabbedPanelEmbedded = null;
    @Override
    public GameTabbedPanelEmbedded getGameTabbedPanelEmbedded() {
      if (gameTabbedPanelEmbedded == null)
        gameTabbedPanelEmbedded = new TesTabbedPanelEmbedded();
      return gameTabbedPanelEmbedded;
    }
  };

  private final Game game;
  private final boolean isDefault;

  EGame(Game game, boolean isDefault) {
    this.game = game;
    this.isDefault = isDefault;
  }

  public Game getGame() {
    return game;
  }

  public boolean isDefault() {
    return isDefault;
  }

  public static final int NB_GAMES = EGame.values().length;

  public static Game getDefault() {
    return Arrays.stream(EGame.values())
            .filter(EGame::isDefault)
            .findFirst()
            .map(EGame::getGame)
            .orElse(NBK.getGame());
  }

  public abstract GameTabbedPanelEmbedded getGameTabbedPanelEmbedded();
}
