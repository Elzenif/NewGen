package commons.controller.utility;

import commons.controller.commons.GenerateActionListener;
import commons.view.utility.UtilityOptionRow;
import commons.view.utility.UtilityResultRow;
import commons.view.utility.result.UtilityResult;

/**
 * Created by Germain on 01/10/2016.
 */
public abstract class GenerateUtilityActionListener
    extends GenerateActionListener<UtilityOptionRow, UtilityResultRow, UtilityResult, String> {

  protected GenerateUtilityActionListener(UtilityOptionRow utilityOptionRow, UtilityResultRow utilityResultRow,
                                          UtilityController utilityController) {
    super(utilityOptionRow, utilityResultRow, utilityController);
  }

}
