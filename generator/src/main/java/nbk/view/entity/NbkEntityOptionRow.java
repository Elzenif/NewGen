package nbk.view.entity;

import commons.view.entity.EntityOptionRow;
import nbk.model.commons.NbkGame;

/**
 * Created by Germain on 08/06/2016.
 */
abstract class NbkEntityOptionRow extends EntityOptionRow<NbkGame> {

  NbkEntityOptionRow(ENbkAvailableItem availableItem) {
    super(availableItem, NbkGame.getInstance());
  }
}
