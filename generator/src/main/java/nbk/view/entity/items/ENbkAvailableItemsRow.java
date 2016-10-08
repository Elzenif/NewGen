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

  WEAPON_ROW(ENbkAvailableItem.WEAPON, new NbkWeaponOptionRow()),
  ARMOR_ROW(ENbkAvailableItem.ARMOR, new NbkArmorOptionRow());

  private final IAvailableItem<NbkGame> item;
  private final EntityOptionRow<NbkGame> entityOptionRow;
  private final EntityResultRow entityResultRow;

  ENbkAvailableItemsRow(IAvailableItem<NbkGame> item, EntityOptionRow<NbkGame> entityOptionRow) {
    this.item = item;
    this.entityOptionRow = entityOptionRow;
    this.entityResultRow = new EntityResultRow(this);
  }

  @Override
  public String getName() {
    return item.getName();
  }

  @Override
  public EntityOptionRow<NbkGame> getOptionRow() {
    return entityOptionRow;
  }

  @Override
  public EntityResultRow getResultRow() {
    return entityResultRow;
  }
}
