package nbk.controller.entity.items;

import commons.controller.entity.items.ConstraintItemActionListener;
import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import nbk.model.commons.NbkGame;
import nbk.model.entity.items.characteristics.primary.enums.EBodyPart;

import java.awt.event.ActionEvent;

/**
 * Created by Germain on 20/07/2016.
 */
public class BodyPartActionListener extends ConstraintItemActionListener<NbkGame, EBodyPart> {

  public BodyPartActionListener(NbkArmorController armorController, GenericPredicateConstraint<EBodyPart> constraint) {
    super(armorController, constraint);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ((NbkArmorController) entityController).updateBodyPartConstraint(constraint);
  }
}
