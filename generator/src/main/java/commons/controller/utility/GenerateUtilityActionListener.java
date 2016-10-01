package commons.controller.utility;

import commons.controller.GenerateActionListener;
import commons.model.commons.Game;
import commons.model.utility.IUtilityDrawKey;
import commons.model.utility.UtilityConstraint;
import commons.view.utility.UtilityOptionRow;
import commons.view.utility.UtilityResultRow;
import commons.view.utility.result.UtilityResult;

/**
 * Created by Germain on 01/10/2016.
 */
public abstract class GenerateUtilityActionListener<G extends Game, K extends IUtilityDrawKey>
    extends GenerateActionListener<UtilityOptionRow, UtilityResultRow, UtilityResult, String, UtilityConstraint> {

  private final UtilityController<G, K> utilityController;

  protected GenerateUtilityActionListener(UtilityOptionRow utilityOptionRow, UtilityResultRow utilityResultRow,
                                          UtilityController<G, K> utilityController) {
    super(utilityOptionRow, utilityResultRow);
    this.utilityController = utilityController;
  }

  @Override
  protected UtilityConstraint getConstraints() {
    return (optionRow.isConstraintsCheckBoxSelected())
        ? utilityController.getUtilityConstraint()
        : new UtilityConstraint();
  }
}
