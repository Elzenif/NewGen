package mvc.model.entity.game;

import java.util.Arrays;

/**
 * Created by Germain on 12/06/2016.
 */
public enum EGame {

  NBK(NbkGame.getInstance(), true),
  TES(TesGame.getInstance(), false);

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

  public static Game getDefault() {
    return Arrays.asList(EGame.values()).stream()
            .filter(EGame::isDefault).findFirst().map(EGame::getGame).orElse(NBK.getGame());
  }
}
