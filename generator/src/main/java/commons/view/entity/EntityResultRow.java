package commons.view.entity;

import commons.view.entity.results.ItemResult;
import commons.view.utils.ResultRow;


/**
 * Created by Germain on 05/06/2016.
 */
public class EntityResultRow extends ResultRow<ItemResult> {

  EntityResultRow(IAvailableItem availableItem) {
    super((String) availableItem.getName());
  }

}
