package nbk.controller.entity.items;

import commons.controller.entity.EntityController;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.view.entity.EntityResultRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.items.characteristics.primary.enums.ENbHands;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkPredefinedWeapon;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkQuality;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkWeaponType;
import nbk.view.entity.items.options.NbkWeaponOptionRow;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 23/07/2016.
 */
public class NbkWeaponController extends EntityController<NbkGame> {

  private final EnumMap<ENbHands, ActionListener> nbHandsActionListenerEnumMap = new EnumMap<>(ENbHands.class);

  public NbkWeaponController(NbkWeaponOptionRow nbkWeaponOptionRow, EntityResultRow entityResultRow) {
    super(nbkWeaponOptionRow);
    generateActionListener = new GenerateNbkWeaponActionListener(nbkWeaponOptionRow, entityResultRow, this);
    Arrays.stream(ENbHands.values()).forEach(nbHands ->
            nbHandsActionListenerEnumMap.put(nbHands, new NbHandsActionListener(this, nbHands)));
  }

  public ActionListener getNbHandsActionListener(ENbHands nbHands) {
    return nbHandsActionListenerEnumMap.get(nbHands);
  }

  @Override
  public void updateRarityConstraint(GenericConstraint<EItemRarity> constraint) {
    // different for randomly generated and predefined weapons
    generationConstraint.clear(ENbkQuality.getConstraints(), EItemRarity.class);
    generationConstraint.update(ENbkQuality.getConstraints(), EItemRarity.class, constraint);
    generationConstraint.clear(ENbkPredefinedWeapon.getConstraints(), EItemRarity.class);
    generationConstraint.update(ENbkPredefinedWeapon.getConstraints(), EItemRarity.class, constraint);

  }

  public void updateNbHandsConstraint(GenericConstraint<ENbHands> constraint) {
    generationConstraint.update(ENbkWeaponType.getConstraints(), ENbHands.class, constraint);
  }

}
