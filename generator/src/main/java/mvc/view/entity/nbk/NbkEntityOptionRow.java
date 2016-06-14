package mvc.view.entity.nbk;

import mvc.model.entity.game.*;
import mvc.view.entity.*;

/**
 * Created by Germain on 08/06/2016.
 */
abstract class NbkEntityOptionRow extends EntityOptionRow<NbkGame> {

  NbkEntityOptionRow(ENbkAvailableItem availableItem) {
    super(availableItem, NbkGame.getInstance());
  }
}
