package nbk.view.entity.items;

import commons.model.entity.IAvailableEntity;
import nbk.model.commons.NbkGame;
import nbk.view.entity.NbkEntityOptionRow;

/**
 * Created by Germain on 28/08/2016.
 */
public abstract class NbkItemOptionRow extends NbkEntityOptionRow {
  
  protected NbkItemOptionRow(IAvailableEntity<NbkGame> availableEntity) {
    super(availableEntity, NbkGame.getInstance().getAvailableItems());
  }
}
