package nbk.view.entity;

import commons.view.entity.EntityResultRow;
import nbk.controller.entity.GenerateNbkArmorActionListener;

/**
 * Created by Germain on 26/06/2016.
 */
public class NbkArmorOptionRow extends NbkEntityOptionRow {

  NbkArmorOptionRow() {
    super(ENbkAvailableItem.ARMOR);

    finalizeRowConstruction();
  }

  @Override
  public void setControllers(EntityResultRow entityResultRow) {
    super.setControllers(entityResultRow);
    generateItemButton.addActionListener(new GenerateNbkArmorActionListener(this, entityResultRow));
  }
}
