package nbk.controller.entity.items;

import commons.controller.entity.items.ItemController;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.view.entity.EntityResultRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.items.characteristics.primary.enums.EBodyPart;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkPredefinedArmor;
import nbk.view.entity.items.options.NbkArmorOptionRow;

import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 23/07/2016.
 */
public class NbkArmorController extends ItemController<NbkGame> {

  private final EnumMap<EBodyPart, BodyPartActionListener> bodyPartActionListenerMap = new EnumMap<>(EBodyPart.class);

  public NbkArmorController(NbkArmorOptionRow entityOptionRow, EntityResultRow entityResultRow) {
    super(entityOptionRow);
    generateActionListener = new GenerateNbkArmorActionListener(entityOptionRow, entityResultRow, this);
    Arrays.stream(EBodyPart.values()).forEach(bodyPart ->
            bodyPartActionListenerMap.put(bodyPart, new BodyPartActionListener(this, bodyPart)));
  }

  public BodyPartActionListener getBodyPartActionListener(EBodyPart bodyPart) {
    return bodyPartActionListenerMap.get(bodyPart);
  }

  @Override
  public void updateRarityConstraint(GenericConstraint<EItemRarity> constraint) {
    generationConstraint.clear(ENbkPredefinedArmor.getConstraints(), EItemRarity.class);
    generationConstraint.update(ENbkPredefinedArmor.getConstraints(), EItemRarity.class, constraint);
  }

  public void updateBodyPartConstraint(GenericConstraint<EBodyPart> constraint) {
    generationConstraint.update(ENbkPredefinedArmor.getConstraints(), EBodyPart.class, constraint);
  }

}
