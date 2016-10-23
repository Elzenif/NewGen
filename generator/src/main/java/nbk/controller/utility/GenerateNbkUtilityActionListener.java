package nbk.controller.utility;

import commons.controller.utility.GenerateUtilityActionListener;
import commons.controller.utility.UtilityController;
import commons.view.utility.UtilityOptionRow;
import commons.view.utility.UtilityResultRow;

/**
 * Created by Germain on 01/10/2016.
 */
public abstract class GenerateNbkUtilityActionListener extends GenerateUtilityActionListener {

  protected GenerateNbkUtilityActionListener(UtilityOptionRow utilityOptionRow,
                                             UtilityResultRow utilityResultRow,
                                             UtilityController utilityController) {
    super(utilityOptionRow, utilityResultRow, utilityController);
  }
}
