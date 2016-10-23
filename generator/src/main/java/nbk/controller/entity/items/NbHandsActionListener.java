package nbk.controller.entity.items;

import commons.controller.entity.items.ConstraintItemActionListener;
import commons.controller.entity.items.ItemController;
import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import nbk.model.commons.NbkGame;
import nbk.model.entity.items.characteristics.primary.enums.ENbHands;

import java.awt.event.ActionEvent;

/**
 * Created by Germain on 11/06/2016.
 */
public class NbHandsActionListener extends ConstraintItemActionListener<NbkGame, ENbHands> {

  public NbHandsActionListener(ItemController<NbkGame> entityController,
                               GenericPredicateConstraint<ENbHands> nbHandsConstraint) {
    super(entityController, nbHandsConstraint);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ((NbkWeaponController) entityController).updateNbHandsConstraint(constraint);
  }
}
