package commons.controller.utility;

import commons.controller.entity.items.ConstraintsItemListener;
import commons.controller.intf.ConstraintOptionRowController;
import commons.model.commons.Game;
import commons.model.utility.IUtilityDrawKey;
import commons.model.utility.UtilityConstraint;
import commons.view.utility.UtilityOptionRow;

/**
 * Created by Germain on 01/10/2016.
 */
public abstract class UtilityController<G extends Game, K extends IUtilityDrawKey>
    implements ConstraintOptionRowController {

  protected final UtilityOptionRow utilityOptionRow;
  protected final UtilityConstraint utilityConstraint;
  private final ConstraintsItemListener constraintsItemListener;
  protected GenerateUtilityActionListener<G, K> generateUtilityActionListener;

  protected UtilityController(UtilityOptionRow utilityOptionRow) {
    this.utilityOptionRow = utilityOptionRow;
    utilityConstraint = new UtilityConstraint();
    constraintsItemListener = new ConstraintsItemListener(utilityOptionRow);
  }

  public UtilityConstraint getUtilityConstraint() {
    return utilityConstraint;
  }

  @Override
  public ConstraintsItemListener getConstraintsItemListener() {
    return constraintsItemListener;
  }

  public GenerateUtilityActionListener<G, K> getGenerateUtilityActionListener() {
    return generateUtilityActionListener;
  }

  public abstract void updateDrawKeyValue(K drawKey);
}
