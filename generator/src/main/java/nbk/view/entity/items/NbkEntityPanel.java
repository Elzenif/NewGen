package nbk.view.entity.items;

import commons.view.entity.EntityPanel;
import nbk.model.commons.NbkGame;

/**
 * Created by Germain on 12/06/2016.
 */
public class NbkEntityPanel extends EntityPanel<NbkGame, ENbkAvailableEntityOptionRow> {

  public NbkEntityPanel() {
    super(ENbkAvailableEntityOptionRow.values());
  }
}
