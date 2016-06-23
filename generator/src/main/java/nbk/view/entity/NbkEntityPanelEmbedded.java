package nbk.view.entity;

import commons.view.entity.EntityPanelEmbedded;
import nbk.model.entity.game.NbkGame;

/**
 * Created by Germain on 12/06/2016.
 */
public class NbkEntityPanelEmbedded extends EntityPanelEmbedded<NbkGame, ENbkAvailableItem> {

  public NbkEntityPanelEmbedded() {
    super(NbkGame.getInstance(), ENbkAvailableItem.values());
  }
}
