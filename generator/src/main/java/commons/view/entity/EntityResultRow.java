package commons.view.entity;

import commons.view.entity.results.EntityResult;
import commons.view.utils.ResultRow;


/**
 * Created by Germain on 05/06/2016.
 */
public class EntityResultRow extends ResultRow<EntityResult> {

  public EntityResultRow(IAvailableEntityRow availableEntityOptionRow) {
    super((String) availableEntityOptionRow.getName());
  }

}
