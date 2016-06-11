package mvc.controller.entity;

import mvc.view.entity.EntityOptionRow;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Germain on 11/06/2016.
 */
public class ConstraintsItemListener implements ItemListener {

  private final EntityOptionRow entityOptionRow;

  public ConstraintsItemListener(EntityOptionRow entityOptionRow) {
    this.entityOptionRow = entityOptionRow;
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    entityOptionRow.updateConstraintsAbility(entityOptionRow.isConstraintsCheckBoxSelected());
  }
}
