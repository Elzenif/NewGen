package commons.controller.entity.items;

import commons.view.utils.HasConstraintPanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Germain on 11/06/2016.
 */
public class ConstraintsItemListener implements ItemListener {

  private final HasConstraintPanel entityOptionRow;

  public ConstraintsItemListener(HasConstraintPanel entityOptionRow) {
    this.entityOptionRow = entityOptionRow;
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    entityOptionRow.updateConstraintsAbility(entityOptionRow.isConstraintsCheckBoxSelected());
  }
}
