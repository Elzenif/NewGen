package dd.view.entity.items.options;

import commons.model.entity.items.IAvailableItem;
import commons.view.entity.items.ItemOptionRow;
import dd.model.commons.DDGame;

/**
 * Created by Germain on 25/10/2016.
 */
public abstract class DDItemOptionRow extends ItemOptionRow<DDGame> {

  protected DDItemOptionRow(IAvailableItem<DDGame> availableItem) {
    super(availableItem, DDGame.getInstance().getAvailableItems());
  }
}
