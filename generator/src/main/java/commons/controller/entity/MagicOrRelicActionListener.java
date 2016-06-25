package commons.controller.entity;

import commons.model.entity.constraints.MagicOrRelicConstraint;
import nbk.view.entity.NbkWeaponOptionRow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 25/06/2016.
 */
public class MagicOrRelicActionListener implements ActionListener {

  private final NbkWeaponOptionRow entityOptionRow;
  private final MagicOrRelicConstraint magicOrRelicConstraint;

  public MagicOrRelicActionListener(NbkWeaponOptionRow entityOptionRow, MagicOrRelicConstraint magicOrRelicConstraint) {
    this.entityOptionRow = entityOptionRow;
    this.magicOrRelicConstraint = magicOrRelicConstraint;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    entityOptionRow.updateMagicOrRelicConstraint(magicOrRelicConstraint);
  }
}
