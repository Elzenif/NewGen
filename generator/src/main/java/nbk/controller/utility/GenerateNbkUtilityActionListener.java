package nbk.controller.utility;

import commons.controller.utility.GenerateUtilityActionListener;
import commons.controller.utility.UtilityController;
import commons.model.utility.IUtilityDrawKey;
import commons.view.utility.UtilityOptionRow;
import commons.view.utility.UtilityResultRow;
import nbk.model.commons.NbkGame;

/**
 * Created by Germain on 01/10/2016.
 */
public abstract class GenerateNbkUtilityActionListener<K extends IUtilityDrawKey>
    extends GenerateUtilityActionListener<NbkGame, K> {

  protected GenerateNbkUtilityActionListener(UtilityOptionRow utilityOptionRow,
                                             UtilityResultRow utilityResultRow,
                                             UtilityController<NbkGame, K> utilityController) {
    super(utilityOptionRow, utilityResultRow, utilityController);
  }
}
