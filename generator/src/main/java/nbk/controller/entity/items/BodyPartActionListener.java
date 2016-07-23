package nbk.controller.entity.items;

import commons.controller.entity.items.AbstractConstraintActionListener;
import commons.controller.entity.items.ItemController;
import commons.model.entity.constraints.GenericConstraint;
import nbk.model.commons.NbkGame;
import nbk.model.entity.characteristics.primary.enums.EBodyPart;

import java.awt.event.ActionEvent;

/**
 * Created by Germain on 20/07/2016.
 */
public class BodyPartActionListener extends AbstractConstraintActionListener<NbkGame, EBodyPart> {

  public BodyPartActionListener(ItemController<NbkGame> itemController, GenericConstraint<EBodyPart> constraint) {
    super(itemController, constraint);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ((NbkArmorController) itemController).updateBodyPartConstraint(constraint);
  }
}
