package mvc.controller.entity;

import mvc.model.entity.enums.ENbkWeaponType;
import mvc.view.entity.nbk.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
public class NbHandsActionListener implements ActionListener {

  private final NbkWeaponOptionRow entityOptionRow;
  private final Predicate<ENbkWeaponType> predicate;

  public NbHandsActionListener(NbkWeaponOptionRow entityOptionRow, Predicate<ENbkWeaponType> predicate) {
    this.entityOptionRow = entityOptionRow;
    this.predicate = predicate;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    entityOptionRow.updateNbHandsConstraint(predicate);
  }
}
