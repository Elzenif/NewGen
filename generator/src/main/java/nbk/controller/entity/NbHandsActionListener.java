package nbk.controller.entity;

import commons.controller.entity.AbstractConstraintActionListener;
import commons.controller.entity.ItemController;
import commons.model.entity.constraints.GenericConstraint;
import nbk.model.commons.NbkGame;
import nbk.model.entity.characteristics.primary.enums.ENbHands;

import java.awt.event.ActionEvent;

/**
 * Created by Germain on 11/06/2016.
 */
public class NbHandsActionListener extends AbstractConstraintActionListener<NbkGame, ENbHands> {

  public NbHandsActionListener(ItemController<NbkGame> itemController,
                               GenericConstraint<ENbHands> nbHandsConstraint) {
    super(itemController, nbHandsConstraint);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ((NbkWeaponController) itemController).updateNbHandsConstraint(constraint);
  }
}
