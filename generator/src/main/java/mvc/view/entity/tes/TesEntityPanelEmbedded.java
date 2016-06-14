package mvc.view.entity.tes;

import mvc.model.entity.game.TesGame;
import mvc.view.entity.*;

/**
 * Created by Germain on 12/06/2016.
 */
public class TesEntityPanelEmbedded extends EntityPanelEmbedded<TesGame, ETesAvailableItem> {

  public TesEntityPanelEmbedded() {
    super(TesGame.getInstance(), ETesAvailableItem.values());
  }
}
