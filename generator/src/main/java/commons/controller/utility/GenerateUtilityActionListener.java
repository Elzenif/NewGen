package commons.controller.utility;

import commons.controller.commons.GenerateActionListener;
import commons.model.utility.constraints.IUtilityDrawKey;
import commons.model.utility.constraints.UtilityConstraint;
import commons.view.utility.UtilityOptionRow;
import commons.view.utility.UtilityResultRow;
import commons.view.utility.result.UtilityResult;

/**
 * Created by Germain on 01/10/2016.
 */
public abstract class GenerateUtilityActionListener<K extends IUtilityDrawKey>
    extends GenerateActionListener<UtilityOptionRow<K>, UtilityResultRow, UtilityResult, String, UtilityConstraint> {

  protected GenerateUtilityActionListener(UtilityOptionRow<K> utilityOptionRow, UtilityResultRow utilityResultRow,
                                          UtilityController<K> utilityController) {
    super(utilityOptionRow, utilityResultRow, utilityController);
  }

  @Override
  protected UtilityConstraint newConstraint() {
    return new UtilityConstraint();
  }
}
