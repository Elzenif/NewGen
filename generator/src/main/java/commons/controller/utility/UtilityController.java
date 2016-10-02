package commons.controller.utility;

import commons.controller.AbstractOptionRowController;
import commons.controller.entity.items.ConstraintsItemListener;
import commons.controller.intf.HasDrawKeysController;
import commons.model.utility.IUtilityDrawKey;
import commons.model.utility.UtilityConstraint;
import commons.view.utility.UtilityOptionRow;

/**
 * Created by Germain on 01/10/2016.
 */
public abstract class UtilityController<K extends IUtilityDrawKey>
    extends AbstractOptionRowController<UtilityConstraint> implements HasDrawKeysController<K> {

  protected final UtilityOptionRow utilityOptionRow;

  protected UtilityController(UtilityOptionRow utilityOptionRow) {
    super(new ConstraintsItemListener(utilityOptionRow), new UtilityConstraint());
    this.utilityOptionRow = utilityOptionRow;
  }
}
