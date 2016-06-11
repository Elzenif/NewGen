package mvc.controller.entity;

import mvc.model.entity.enums.EWeaponType;
import mvc.view.entity.EntityOptionRow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
public class NbHandsActionListener implements ActionListener {

  private final EntityOptionRow entityOptionRow;
  private final Predicate<EWeaponType> predicate;

  public NbHandsActionListener(EntityOptionRow entityOptionRow, Predicate<EWeaponType> predicate) {
    this.entityOptionRow = entityOptionRow;
    this.predicate = predicate;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    entityOptionRow.updateNbHandsConstraint(predicate);
  }
}
