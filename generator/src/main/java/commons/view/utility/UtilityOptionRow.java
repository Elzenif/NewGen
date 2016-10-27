package commons.view.utility;

import commons.controller.utility.UtilityController;
import commons.model.commons.IDrawKeyIntegerValue;
import commons.view.commons.options.ConstraintOptionRow;
import commons.view.commons.options.HasDrawKeysOptionRow;

/**
 * Created by Germain on 24/07/2016.
 */
public abstract class UtilityOptionRow
    extends ConstraintOptionRow<UtilityResultRow> implements HasDrawKeysOptionRow<IDrawKeyIntegerValue> {

  protected UtilityOptionRow(int labelSize, String name) {
    super(labelSize + 3, name + " : ");

    leftPanel.add(infoLabel);

    centerPanel.add(constraintsCheckBoxPanel);
  }

  protected void setControllers(UtilityController utilityController) {
    super.setControllers(utilityController);
  }
}
