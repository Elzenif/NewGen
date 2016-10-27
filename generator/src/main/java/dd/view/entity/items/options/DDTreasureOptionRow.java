package dd.view.entity.items.options;

import commons.view.entity.EntityResultRow;
import dd.controller.entity.items.DDTreasureController;
import dd.model.entity.items.EDDAvailableItem;

import java.text.MessageFormat;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 25/10/2016.
 */
public class DDTreasureOptionRow extends DDItemOptionRow {

  protected DDTreasureOptionRow() {
    super(EDDAvailableItem.TREASURE);

    finalizeRowConstruction(MessageFormat.format(resourceBundle.getString("tooltip.entity.generate"), name));
  }

  @Override
  public void setControllers(EntityResultRow resultRow) {
    super.setControllers(new DDTreasureController(this, resultRow));
  }
}
