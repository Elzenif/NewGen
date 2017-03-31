package commons.view.entity;

import commons.Constants;
import commons.view.commons.results.StringResultRow;
import commons.view.entity.results.EntityResult;


/**
 * Created by Germain on 05/06/2016.
 */
public class EntityResultRow extends StringResultRow<EntityResult> {

  public EntityResultRow(IAvailableEntityRow availableEntityOptionRow) {
    super((String) availableEntityOptionRow.getName(), true, Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP);
  }

}
