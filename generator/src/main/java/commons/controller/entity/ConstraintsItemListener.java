package commons.controller.entity;

import commons.model.commons.Game;
import commons.view.entity.EntityOptionRow;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Germain on 11/06/2016.
 */
public class ConstraintsItemListener<T extends Game> implements ItemListener {

  private final EntityOptionRow<T> entityOptionRow;

  public ConstraintsItemListener(EntityOptionRow<T> entityOptionRow) {
    this.entityOptionRow = entityOptionRow;
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    entityOptionRow.updateConstraintsAbility(entityOptionRow.isConstraintsCheckBoxSelected());
  }
}
