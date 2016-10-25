package nbk.view.entity.items.options;

import commons.model.entity.items.IAvailableItem;
import commons.view.entity.items.ItemOptionRow;
import nbk.model.commons.NbkGame;

/**
 * Created by Germain on 28/08/2016.
 */
public abstract class NbkItemOptionRow extends ItemOptionRow<NbkGame> {

  protected NbkItemOptionRow(IAvailableItem<NbkGame> availableEntity) {
    super(availableEntity, NbkGame.getInstance().getAvailableItems());
  }
}
