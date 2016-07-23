package nbk.view.entity.items;

import commons.view.entity.EntityOptionRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.items.ENbkAvailableItem;

/**
 * Created by Germain on 08/06/2016.
 */
abstract class NbkEntityOptionRow extends EntityOptionRow<NbkGame> {

  NbkEntityOptionRow(ENbkAvailableItem availableItem) {
    super(availableItem, NbkGame.getInstance());
  }
}
