package commons.controller.entity.items;

import commons.view.utils.HasConstraintPanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Germain on 11/06/2016.
 */
public class ConstraintsItemListener implements ItemListener {

  private final HasConstraintPanel optionRow;

  public ConstraintsItemListener(HasConstraintPanel optionRow) {
    this.optionRow = optionRow;
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    optionRow.updateConstraintsAbility(optionRow.isConstraintsCheckBoxSelected());
  }
}
