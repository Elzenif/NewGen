package commons.view.utility;

import commons.view.utility.result.UtilityResult;
import commons.view.utils.Constants;
import commons.view.utils.StringResultRow;

/**
 * Created by Germain on 24/07/2016.
 */
public class UtilityResultRow extends StringResultRow<UtilityResult> {

  public UtilityResultRow(String labelText) {
    super(labelText, false, Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP);
  }
}
