package commons.controller.utility;

import commons.controller.commons.AbstractOptionRowController;
import commons.controller.entity.items.ConstraintsItemListener;
import commons.controller.intf.HasDrawKeysController;
import commons.model.commons.IDrawKeyIntegerValue;
import commons.view.utility.UtilityOptionRow;

/**
 * Created by Germain on 01/10/2016.
 */
public abstract class UtilityController
    extends AbstractOptionRowController implements HasDrawKeysController<IDrawKeyIntegerValue> {

  protected final UtilityOptionRow utilityOptionRow;

  protected UtilityController(UtilityOptionRow utilityOptionRow) {
    super(new ConstraintsItemListener(utilityOptionRow));
    this.utilityOptionRow = utilityOptionRow;
  }
}
