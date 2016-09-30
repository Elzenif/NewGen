package nbk.controller.utility.love;

import commons.controller.entity.items.ConstraintsItemListener;
import commons.controller.intf.ConstraintOptionRowController;
import commons.view.utility.UtilityResultRow;
import nbk.view.utility.love.LoveOptionRow;

/**
 * Created by Germain on 24/07/2016.
 */
public class LoveController implements ConstraintOptionRowController {

  private final ConstraintsItemListener constraintsItemListener;
  private final MakeLoveActionListener makeLoveActionListener;

  public LoveController(LoveOptionRow loveOptionRow, UtilityResultRow loveResultRow) {
    constraintsItemListener = new ConstraintsItemListener(loveOptionRow);
    makeLoveActionListener = new MakeLoveActionListener(loveOptionRow, loveResultRow);
  }

  @Override
  public ConstraintsItemListener getConstraintsItemListener() {
    return constraintsItemListener;
  }

  public MakeLoveActionListener getMakeLoveActionListener() {
    return makeLoveActionListener;
  }
}
