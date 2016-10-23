package nbk.controller.entity.items;

import commons.controller.entity.items.ItemController;
import commons.model.commons.constraints.PredicateConstraints;
import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.view.entity.EntityResultRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.items.characteristics.primary.enums.ENbHands;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkPredefinedWeapon;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkQuality;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkWeaponType;
import nbk.view.entity.items.options.NbkWeaponOptionRow;

import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 23/07/2016.
 */
public class NbkWeaponController extends ItemController<NbkGame> {

  private final EnumMap<ENbHands, NbHandsActionListener> nbHandsActionListenerEnumMap = new EnumMap<>(ENbHands.class);

  public NbkWeaponController(NbkWeaponOptionRow nbkWeaponOptionRow, EntityResultRow entityResultRow) {
    super(nbkWeaponOptionRow);
    generateActionListener = new GenerateNbkWeaponActionListener(nbkWeaponOptionRow, entityResultRow, this);
    Arrays.stream(ENbHands.values()).forEach(nbHands ->
            nbHandsActionListenerEnumMap.put(nbHands, new NbHandsActionListener(this, nbHands)));
  }

  public NbHandsActionListener getNbHandsActionListener(ENbHands nbHands) {
    return nbHandsActionListenerEnumMap.get(nbHands);
  }

  @Override
  public void updateRarityConstraint(GenericPredicateConstraint<EItemRarity> constraint) {
    // different for randomly generated and predefined weapons
    PredicateConstraints predicateConstraints = generationConstraints.getPredicateConstraints();
    predicateConstraints.clear(ENbkQuality.getConstraints(), EItemRarity.class);
    predicateConstraints.update(ENbkQuality.getConstraints(), EItemRarity.class, constraint);
    predicateConstraints.clear(ENbkPredefinedWeapon.getConstraints(), EItemRarity.class);
    predicateConstraints.update(ENbkPredefinedWeapon.getConstraints(), EItemRarity.class, constraint);

  }

  public void updateNbHandsConstraint(GenericPredicateConstraint<ENbHands> constraint) {
    generationConstraints.getPredicateConstraints().update(ENbkWeaponType.getConstraints(), ENbHands.class, constraint);
  }

}
