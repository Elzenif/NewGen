package nbk.view.entity.items.options;

import commons.model.entity.items.IAvailableItem;
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
  private final NbkItemOptionRow itemOptionRow;
  private final EntityResultRow entityResultRow;

  ENbkAvailableItemsRow(IAvailableItem<NbkGame> item, NbkItemOptionRow itemOptionRow) {
    this.item = item;
    this.itemOptionRow = itemOptionRow;
    this.entityResultRow = new EntityResultRow(this);
  }

  @Override
  public String getName() {
    return item.getName();
  }

  @Override
  public NbkItemOptionRow getOptionRow() {
    return itemOptionRow;
  }

  @Override
  public EntityResultRow getResultRow() {
    return entityResultRow;
  }
}
