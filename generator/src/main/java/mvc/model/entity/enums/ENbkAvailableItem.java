package mvc.model.entity.enums;

import mvc.model.entity.items.Item;
import mvc.model.entity.items.NbkWeapon;
import mvc.model.entity.utils.IAvailableItem;

/**
 * Created by Germain on 11/06/2016.
 */
public enum ENbkAvailableItem implements IAvailableItem {

  WEAPON("Weapon", NbkWeapon.class);

  private final String name;
  private final Class<? extends Item> itemClass;

  ENbkAvailableItem(String name, Class<? extends Item> itemClass) {
    this.name = name;
    this.itemClass = itemClass;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Class<? extends Item> getItemClass() {
    return itemClass;
  }

}
