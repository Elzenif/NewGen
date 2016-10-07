package commons.view.entity;

import commons.view.entity.results.EntityResult;
import commons.view.utils.Constants;
import commons.view.utils.StringResultRow;


/**
 * Created by Germain on 05/06/2016.
 */
public class EntityResultRow extends StringResultRow<EntityResult> {

  public EntityResultRow(IAvailableEntityRow availableEntityOptionRow) {
    super((String) availableEntityOptionRow.getName(), true, Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP);
  }

}
