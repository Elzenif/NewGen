package nbk.view.entity.items;

import commons.model.entity.items.IAvailableItem;
import commons.view.entity.EntityOptionRow;
import commons.view.entity.EntityResultRow;
import commons.view.entity.IAvailableEntityRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.items.ENbkAvailableItem;

/**
 * Created by Germain on 11/06/2016.
 */
public enum ENbkAvailableItemsRow implements IAvailableEntityRow<NbkGame> {

  WEAPON_ROW(ENbkAvailableItem.WEAPON) {
    NbkWeaponOptionRow entityOptionRow = null;
    @Override
    public EntityOptionRow<NbkGame> getOptionRow() {
      if (entityOptionRow == null)
        entityOptionRow = new NbkWeaponOptionRow();
      return entityOptionRow;
    }
  }, ARMOR_ROW(ENbkAvailableItem.ARMOR) {
    NbkArmorOptionRow entityOptionRow = null;
    @Override
    public EntityOptionRow<NbkGame> getOptionRow() {
      if (entityOptionRow == null)
        entityOptionRow = new NbkArmorOptionRow();
      return entityOptionRow;
    }
  };

  private final IAvailableItem<NbkGame> item;
  private EntityResultRow entityResultRow;

  ENbkAvailableItemsRow(IAvailableItem<NbkGame> item) {
    this.item = item;
  }

  @Override
  public String getName() {
    return item.getName();
  }


  @Override
  public EntityResultRow getResultRow() {
    if (entityResultRow == null)
      entityResultRow = new EntityResultRow(this);
    return entityResultRow;
  }
}
