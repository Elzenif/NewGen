package nbk.controller.entity;

import nbk.model.entity.constraints.NbkNbHandsConstraint;
import nbk.view.entity.NbkWeaponOptionRow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 11/06/2016.
 */
public class NbkNbHandsActionListener implements ActionListener {

  private final NbkWeaponOptionRow entityOptionRow;
  private final NbkNbHandsConstraint nbHandsConstraint;

  public NbkNbHandsActionListener(NbkWeaponOptionRow entityOptionRow, NbkNbHandsConstraint nbHandsConstraint) {
    this.entityOptionRow = entityOptionRow;
    this.nbHandsConstraint = nbHandsConstraint;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    entityOptionRow.updateNbHandsConstraint(nbHandsConstraint);
  }
}
