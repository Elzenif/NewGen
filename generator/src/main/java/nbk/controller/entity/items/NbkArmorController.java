package nbk.controller.entity.items;

import commons.controller.entity.items.ItemController;
import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.view.entity.EntityResultRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.characteristics.primary.enums.EBodyPart;
import nbk.model.entity.characteristics.secondary.enums.ENbkPredefinedArmor;
import nbk.view.entity.items.NbkArmorOptionRow;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 23/07/2016.
 */
public class NbkArmorController extends ItemController<NbkGame> {

  private EnumMap<EBodyPart, ActionListener> bodyPartActionListenerMap = new EnumMap<>(EBodyPart.class);

  public NbkArmorController(NbkArmorOptionRow entityOptionRow, EntityResultRow entityResultRow) {
    super(entityOptionRow);
    generateItemActionListener = new GenerateNbkArmorActionListener(this, entityOptionRow, entityResultRow);
    Arrays.stream(EBodyPart.values()).forEach(bodyPart ->
            bodyPartActionListenerMap.put(bodyPart, new BodyPartActionListener(this, bodyPart)));
  }

  public ActionListener getBodyPartActionListener(EBodyPart bodyPart) {
    return bodyPartActionListenerMap.get(bodyPart);
  }

  @Override
  public void updateRarityConstraint(GenericConstraint<ERarity> constraint) {
    globalConstraints.clear(ENbkPredefinedArmor.getConstraints(), ERarity.class);
    globalConstraints.update(ENbkPredefinedArmor.getConstraints(), ERarity.class, constraint);
  }

  public void updateBodyPartConstraint(GenericConstraint<EBodyPart> constraint) {
    globalConstraints.update(ENbkPredefinedArmor.getConstraints(), EBodyPart.class, constraint);
  }

}
