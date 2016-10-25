package dd.view.entity.items.options;

import commons.model.entity.items.IAvailableItem;
import commons.view.entity.EntityResultRow;
import commons.view.entity.IAvailableEntityRow;
import dd.model.commons.DDGame;
import dd.model.entity.items.EDDAvailableItem;

/**
 * Created by Germain on 25/10/2016.
 */
public enum EDDAvailableItemsRow implements IAvailableEntityRow<DDGame> {

  TREASURE_ROW(EDDAvailableItem.TREASURE, new DDTreasureOptionRow());

  private final IAvailableItem<DDGame> item;
  private final DDItemOptionRow itemOptionRow;
  private final EntityResultRow entityResultRow;

  EDDAvailableItemsRow(IAvailableItem<DDGame> item, DDItemOptionRow itemOptionRow) {
    this.item = item;
    this.itemOptionRow = itemOptionRow;
    this.entityResultRow = new EntityResultRow(this);
  }

  @Override
  public String getName() {
    return item.getName();
  }

  @Override
  public DDItemOptionRow getOptionRow() {
    return itemOptionRow;
  }

  @Override
  public EntityResultRow getResultRow() {
    return entityResultRow;
  }
}
