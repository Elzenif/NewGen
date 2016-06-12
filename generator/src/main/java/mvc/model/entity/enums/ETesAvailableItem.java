package mvc.model.entity.enums;

import mvc.model.entity.items.Item;
import mvc.model.entity.utils.IAvailableItem;

/**
 * Created by Germain on 11/06/2016.
 */
public enum ETesAvailableItem implements IAvailableItem {
  ;

  @Override
  public String getName() {
    return null;
  }

  @Override
  public Class<? extends Item> getItemClass() {
    return null;
  }

}
