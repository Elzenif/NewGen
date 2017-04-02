package commons.view.commons.game;

import commons.model.commons.Game;
import commons.view.intf.ITabbedPanel;
import dd.model.commons.DDGame;
import dd.view.commons.DDTabbedPanelEmbedded;
import nbk.model.commons.NbkGame;
import nbk.view.commons.NbkTabbedPanelEmbedded;
import org.jetbrains.annotations.Contract;

import java.util.Arrays;

/**
 * Created by Germain on 12/06/2016.
 */
public enum EAvailableGame implements ITabbedPanel<GameTabbedPanelEmbedded> {

  NBK(NbkGame.getInstance(), true, new NbkTabbedPanelEmbedded()),
  DD(DDGame.getInstance(), false, new DDTabbedPanelEmbedded());

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

  @Contract(pure = true)
  public Game getGame() {
    return game;
  }

  @Contract(pure = true)
  @Override
  public boolean isDefault() {
    return def;
  }

  @Contract(pure = true)
  @Override
  public GameTabbedPanelEmbedded getTabbedPanelEmbedded() {
    return gameTabbedPanelEmbedded;
  }

}
