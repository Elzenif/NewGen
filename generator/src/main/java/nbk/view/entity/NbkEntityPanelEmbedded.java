package nbk.view.entity;

import commons.view.entity.EntityPanelEmbedded;
import nbk.model.commons.NbkGame;

/**
 * Created by Germain on 12/06/2016.
 */
public class NbkEntityPanelEmbedded extends EntityPanelEmbedded<NbkGame, ENbkAvailableEntityOptionRow> {

  public NbkEntityPanelEmbedded() {
    super(ENbkAvailableEntityOptionRow.values());
  }
}
