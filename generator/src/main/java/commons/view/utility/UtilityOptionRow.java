package commons.view.utility;

import commons.controller.utility.UtilityController;
import commons.model.commons.IDrawKey;
import commons.view.utils.ConstraintOptionRow;
import commons.view.utils.HasDrawKeysOptionRow;

/**
 * Created by Germain on 24/07/2016.
 */
public abstract class UtilityOptionRow<K extends IDrawKey>
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
