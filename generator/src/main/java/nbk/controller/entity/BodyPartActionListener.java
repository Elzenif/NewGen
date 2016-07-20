package nbk.controller.entity;

import commons.model.entity.constraints.GenericConstraint;
import nbk.model.entity.characteristics.primary.enums.EBodyPart;
import nbk.view.entity.NbkArmorOptionRow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 20/07/2016.
 */
public class BodyPartActionListener implements ActionListener {

  private final NbkArmorOptionRow nbkArmorOptionRow;
  private final GenericConstraint<EBodyPart> bpConstraint;

  public BodyPartActionListener(NbkArmorOptionRow nbkArmorOptionRow, GenericConstraint<EBodyPart> bpConstraint) {
    this.nbkArmorOptionRow = nbkArmorOptionRow;
    this.bpConstraint = bpConstraint;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    nbkArmorOptionRow.updateBodyPartConstraint(bpConstraint);
  }
}
