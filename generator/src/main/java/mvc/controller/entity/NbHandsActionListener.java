package mvc.controller.entity;

import mvc.model.entity.constraints.NbHandsConstraint;
import mvc.view.entity.nbk.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 11/06/2016.
 */
public class NbHandsActionListener implements ActionListener {

  private final NbkWeaponOptionRow entityOptionRow;
  private final NbHandsConstraint nbHandsConstraint;

  public NbHandsActionListener(NbkWeaponOptionRow entityOptionRow, NbHandsConstraint nbHandsConstraint) {
    this.entityOptionRow = entityOptionRow;
    this.nbHandsConstraint = nbHandsConstraint;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    entityOptionRow.updateNbHandsConstraint(nbHandsConstraint);
  }
}
