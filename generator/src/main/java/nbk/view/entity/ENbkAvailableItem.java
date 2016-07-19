package nbk.view.entity;

import commons.view.entity.EntityOptionRow;
import commons.view.entity.IAvailableItem;
import nbk.model.commons.NbkGame;

/**
 * Created by Germain on 11/06/2016.
 */
public enum ENbkAvailableItem implements IAvailableItem<NbkGame> {

  WEAPON("Weapon") {
    NbkWeaponOptionRow entityOptionRow = null;
    @Override
    public EntityOptionRow<NbkGame> getEntityOptionRow() {
      if (entityOptionRow == null)
        entityOptionRow = new NbkWeaponOptionRow();
      return entityOptionRow;
    }
  }, ARMOR("Armor") {
    NbkArmorOptionRow entityOptionRow = null;
    @Override
    public EntityOptionRow<NbkGame> getEntityOptionRow() {
      if (entityOptionRow == null)
        entityOptionRow = new NbkArmorOptionRow();
      return entityOptionRow;
    }
  };

  private final String name;

  ENbkAvailableItem(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

}
