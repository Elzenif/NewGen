package nbk.controller.utility;

import commons.controller.utility.GenerateUtilityActionListener;
import commons.controller.utility.UtilityController;
import commons.model.utility.IUtilityDrawKey;
import commons.view.utility.UtilityOptionRow;
import commons.view.utility.UtilityResultRow;

/**
 * Created by Germain on 01/10/2016.
 */
public abstract class GenerateNbkUtilityActionListener<K extends IUtilityDrawKey>
    extends GenerateUtilityActionListener<K> {

  protected GenerateNbkUtilityActionListener(UtilityOptionRow<K> utilityOptionRow,
                                             UtilityResultRow utilityResultRow,
                                             UtilityController<K> utilityController) {
    super(utilityOptionRow, utilityResultRow, utilityController);
  }
}
