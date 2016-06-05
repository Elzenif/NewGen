package mvc.model.entity.enums;

import mvc.model.commons.Result;
import mvc.model.entity.Item;
import mvc.model.entity.Weapon;
import mvc.model.entity.results.WeaponResult;

/**
 * Created by Germain on 05/06/2016.
 */
public enum EAvailableItem {

  WEAPON("Weapon", Weapon.class, WeaponResult.class);

  private final String name;
  private final Class<? extends Item> itemClass;
  private final Class<? extends Result> resultClass;

  EAvailableItem(String name, Class<? extends Item> itemClass, Class<? extends Result> resultClass) {
    this.name = name;
    this.itemClass = itemClass;
    this.resultClass = resultClass;
  }

  public String getName() {
    return name;
  }

  public Class<? extends Item> getItemClass() {
    return itemClass;
  }

  public Class<? extends Result> getResultClass() {
    return resultClass;
  }
}
