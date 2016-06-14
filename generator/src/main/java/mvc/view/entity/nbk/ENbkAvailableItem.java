package mvc.view.entity.nbk;

import mvc.model.entity.game.*;
import mvc.view.entity.*;

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
