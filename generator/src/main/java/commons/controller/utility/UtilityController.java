package commons.controller.utility;

import commons.controller.commons.AbstractOptionRowController;
import commons.controller.entity.items.ConstraintsItemListener;
import commons.controller.intf.HasDrawKeysController;
import commons.model.utility.constraints.DrawKeyConstraint;
import commons.model.utility.constraints.IUtilityDrawKey;
import commons.view.utility.UtilityOptionRow;

/**
 * Created by Germain on 01/10/2016.
 */
public abstract class UtilityController<K extends IUtilityDrawKey>
    extends AbstractOptionRowController<DrawKeyConstraint> implements HasDrawKeysController<K> {

  protected final UtilityOptionRow<K> utilityOptionRow;

  protected UtilityController(UtilityOptionRow<K> utilityOptionRow) {
    super(new ConstraintsItemListener(utilityOptionRow), new DrawKeyConstraint());
    this.utilityOptionRow = utilityOptionRow;
  }
}
