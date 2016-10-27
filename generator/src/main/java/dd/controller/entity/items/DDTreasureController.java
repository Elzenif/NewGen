package dd.controller.entity.items;

import commons.view.entity.EntityResultRow;
import dd.view.entity.items.options.DDTreasureOptionRow;

/**
 * Created by Germain on 27/10/2016.
 */
public class DDTreasureController extends DDItemController {

  public DDTreasureController(DDTreasureOptionRow treasureOptionRow, EntityResultRow entityResultRow) {
    super(treasureOptionRow);
    generateActionListener = new GenerateDDTreasureActionListener(treasureOptionRow, entityResultRow, this);
  }
}
