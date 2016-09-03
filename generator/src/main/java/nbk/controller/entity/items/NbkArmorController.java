package nbk.controller.entity.items;

import commons.controller.entity.EntityController;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.view.entity.EntityResultRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.items.characteristics.primary.enums.EBodyPart;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkPredefinedArmor;
import nbk.view.entity.items.NbkArmorOptionRow;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 23/07/2016.
 */
public class NbkArmorController extends EntityController<NbkGame> {

  private final EnumMap<EBodyPart, ActionListener> bodyPartActionListenerMap = new EnumMap<>(EBodyPart.class);

  public NbkArmorController(NbkArmorOptionRow entityOptionRow, EntityResultRow entityResultRow) {
    super(entityOptionRow);
    generateEntityActionListener = new GenerateNbkArmorActionListener(this, entityOptionRow, entityResultRow);
    Arrays.stream(EBodyPart.values()).forEach(bodyPart ->
            bodyPartActionListenerMap.put(bodyPart, new BodyPartActionListener(this, bodyPart)));
  }

  public ActionListener getBodyPartActionListener(EBodyPart bodyPart) {
    return bodyPartActionListenerMap.get(bodyPart);
  }

  @Override
  public void updateRarityConstraint(GenericConstraint<EItemRarity> constraint) {
    globalConstraints.clear(ENbkPredefinedArmor.getConstraints(), EItemRarity.class);
    globalConstraints.update(ENbkPredefinedArmor.getConstraints(), EItemRarity.class, constraint);
  }

  public void updateBodyPartConstraint(GenericConstraint<EBodyPart> constraint) {
    globalConstraints.update(ENbkPredefinedArmor.getConstraints(), EBodyPart.class, constraint);
  }

}
