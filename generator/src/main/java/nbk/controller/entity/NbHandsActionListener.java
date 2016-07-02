package nbk.controller.entity;

import commons.model.entity.constraints.GenericConstraint;
import nbk.model.entity.enums.ENbkWeaponType;
import nbk.view.entity.NbkWeaponOptionRow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 11/06/2016.
 */
public class NbHandsActionListener implements ActionListener {

  private final NbkWeaponOptionRow entityOptionRow;
  private final GenericConstraint<ENbkWeaponType> nbHandsConstraint;

  public NbHandsActionListener(NbkWeaponOptionRow entityOptionRow,
                               GenericConstraint<ENbkWeaponType> nbHandsConstraint) {
    this.entityOptionRow = entityOptionRow;
    this.nbHandsConstraint = nbHandsConstraint;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    entityOptionRow.updateNbHandsConstraint(nbHandsConstraint);
  }
}
