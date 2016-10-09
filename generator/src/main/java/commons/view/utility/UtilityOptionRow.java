package commons.view.utility;

import commons.controller.utility.UtilityController;
import commons.model.utility.constraints.IUtilityDrawKey;
import commons.view.commons.options.ConstraintOptionRow;
import commons.view.commons.options.HasDrawKeysOptionRow;

/**
 * Created by Germain on 24/07/2016.
 */
public abstract class UtilityOptionRow<K extends IUtilityDrawKey>
    extends ConstraintOptionRow<UtilityResultRow> implements HasDrawKeysOptionRow<K> {

  protected UtilityOptionRow(int labelSize, String name) {
    super(labelSize + 3, name + " : ");

    add(infoLabel);

    add(constraintsCheckBoxPanel);
  }

  protected void setControllers(UtilityController utilityController) {
    super.setControllers(utilityController);
    generateButton.addActionListener(controller.getGenerateActionListener());
  }
}
