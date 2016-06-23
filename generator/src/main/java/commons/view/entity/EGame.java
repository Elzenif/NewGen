package commons.view.entity;

import commons.model.entity.game.Game;
import nbk.model.entity.game.NbkGame;
import nbk.view.entity.NbkEntityPanelEmbedded;
import tes.model.entity.game.TesGame;
import tes.view.entity.TesEntityPanelEmbedded;

import java.util.Arrays;

/**
 * Created by Germain on 12/06/2016.
 */
public enum EGame {

  NBK(NbkGame.getInstance(), true) {
    NbkEntityPanelEmbedded entityPanelEmbedded = null;
    @Override
    public EntityPanelEmbedded getEntityPanelEmbedded() {
      if (entityPanelEmbedded == null)
        entityPanelEmbedded = new NbkEntityPanelEmbedded();
      return entityPanelEmbedded;
    }
  },
  TES(TesGame.getInstance(), false) {
    TesEntityPanelEmbedded entityPanelEmbedded = null;
    @Override
    public EntityPanelEmbedded getEntityPanelEmbedded() {
      if (entityPanelEmbedded == null)
        entityPanelEmbedded = new TesEntityPanelEmbedded();
      return entityPanelEmbedded;
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

  public abstract EntityPanelEmbedded getEntityPanelEmbedded();

  public static final int NB_GAMES = EGame.values().length;

  public static Game getDefault() {
    return Arrays.asList(EGame.values()).stream()
            .filter(EGame::isDefault).findFirst().map(EGame::getGame).orElse(NBK.getGame());
  }
}
