package nbk.controller.utility.love;

import commons.controller.entity.items.ConstraintsItemListener;
import commons.view.utility.UtilityResultRow;
import nbk.view.utility.love.LoveOptionRow;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 * Created by Germain on 24/07/2016.
 */
public class LoveController {

  private final ItemListener constraintsItemListener;
  private final ActionListener makeLoveActionListener;

  public LoveController(LoveOptionRow loveOptionRow, UtilityResultRow loveResultRow) {
    constraintsItemListener = new ConstraintsItemListener(loveOptionRow);
    makeLoveActionListener = new MakeLoveActionListener(loveOptionRow, loveResultRow);
  }

  public ItemListener getConstraintsItemListener() {
    return constraintsItemListener;
  }

  public ActionListener getMakeLoveActionListener() {
    return makeLoveActionListener;
  }
}
