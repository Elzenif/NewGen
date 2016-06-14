package mvc.view.entity.nbk;

import mvc.model.entity.game.NbkGame;
import mvc.view.entity.*;

/**
 * Created by Germain on 12/06/2016.
 */
public class NbkEntityPanelEmbedded extends EntityPanelEmbedded<NbkGame, ENbkAvailableItem> {

  public NbkEntityPanelEmbedded() {
    super(NbkGame.getInstance(), ENbkAvailableItem.values());
  }
}
