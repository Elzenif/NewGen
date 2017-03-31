package commons.view.utility;

import commons.Constants;
import commons.view.commons.results.StringResultRow;
import commons.view.utility.result.UtilityResult;

/**
 * Created by Germain on 24/07/2016.
 */
public class UtilityResultRow extends StringResultRow<UtilityResult> {

  public UtilityResultRow(String labelText) {
    super(labelText, false, Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP);
  }
}
