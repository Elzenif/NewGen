package nbk.controller.entity.items;

import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.view.entity.EntityResultRow;
import nbk.model.entity.items.characteristics.primary.enums.EBodyPart;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkPredefinedArmor;
import nbk.view.entity.items.options.NbkArmorOptionRow;

import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 23/07/2016.
 */
public class NbkArmorController extends NbkItemController {

  private final EnumMap<EBodyPart, BodyPartActionListener> bodyPartActionListenerMap = new EnumMap<>(EBodyPart.class);

  public NbkArmorController(NbkArmorOptionRow entityOptionRow, EntityResultRow entityResultRow) {
    super(entityOptionRow);
    generateActionListener = new GenerateNbkArmorActionListener(entityOptionRow, entityResultRow, this);
    Arrays.stream(EBodyPart.values()).forEach(bodyPart ->
            bodyPartActionListenerMap.put(bodyPart, new BodyPartActionListener(this, bodyPart)));
    updateBodyPartConstraint(() -> p -> true);
  }

  public BodyPartActionListener getBodyPartActionListener(EBodyPart bodyPart) {
    return bodyPartActionListenerMap.get(bodyPart);
  }

  @Override
  public void updateRarityConstraint(GenericPredicateConstraint<EItemRarity> constraint) {
    generationConstraints.getPredicateConstraints().clear(ENbkPredefinedArmor.getConstraints(), EItemRarity.class);
    generationConstraints.getPredicateConstraints().update(ENbkPredefinedArmor.getConstraints(), EItemRarity.class,
        constraint);
  }

  public void updateBodyPartConstraint(GenericPredicateConstraint<EBodyPart> constraint) {
    generationConstraints.getPredicateConstraints().update(ENbkPredefinedArmor.getConstraints(), EBodyPart.class,
        constraint);
  }

}
