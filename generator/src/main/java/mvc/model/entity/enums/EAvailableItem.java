package mvc.model.entity.enums;

import mvc.model.commons.HasName;
import mvc.model.entity.Item;
import mvc.model.entity.Weapon;

/**
 * Created by Germain on 05/06/2016.
 */
public enum EAvailableItem implements HasName {

  WEAPON("Weapon", Weapon.class);

  private final String name;
  private final Class<? extends Item> itemClass;

  EAvailableItem(String name, Class<? extends Item> itemClass) {
    this.name = name;
    this.itemClass = itemClass;
  }

  @Override
  public String getName() {
    return name;
  }

  public Class<? extends Item> getItemClass() {
    return itemClass;
  }
}
