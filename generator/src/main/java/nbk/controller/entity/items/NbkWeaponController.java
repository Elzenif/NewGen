package nbk.controller.entity.items;

import commons.controller.entity.items.ItemController;
import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.view.entity.EntityResultRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.characteristics.primary.enums.ENbHands;
import nbk.model.entity.characteristics.secondary.enums.ENbkPredefinedWeapon;
import nbk.model.entity.characteristics.secondary.enums.ENbkQuality;
import nbk.model.entity.characteristics.secondary.enums.ENbkWeaponType;
import nbk.view.entity.items.NbkWeaponOptionRow;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 23/07/2016.
 */
public class NbkWeaponController extends ItemController<NbkGame> {

  private EnumMap<ENbHands, ActionListener> nbHandsActionListenerEnumMap = new EnumMap<>(ENbHands.class);

  public NbkWeaponController(NbkWeaponOptionRow nbkWeaponOptionRow, EntityResultRow entityResultRow) {
    super(nbkWeaponOptionRow);
    generateItemActionListener = new GenerateNbkWeaponActionListener(this, nbkWeaponOptionRow, entityResultRow);
    Arrays.stream(ENbHands.values()).forEach(nbHands ->
            nbHandsActionListenerEnumMap.put(nbHands, new NbHandsActionListener(this, nbHands)));
  }

  public ActionListener getNbHandsActionListener(ENbHands nbHands) {
    return nbHandsActionListenerEnumMap.get(nbHands);
  }

  @Override
  public void updateRarityConstraint(GenericConstraint<ERarity> constraint) {
    // different for randomly generated and predefined weapons
    globalConstraints.clear(ENbkQuality.getConstraints(), ERarity.class);
    globalConstraints.update(ENbkQuality.getConstraints(), ERarity.class, constraint);
    globalConstraints.clear(ENbkPredefinedWeapon.getConstraints(), ERarity.class);
    globalConstraints.update(ENbkPredefinedWeapon.getConstraints(), ERarity.class, constraint);

  }

  public void updateNbHandsConstraint(GenericConstraint<ENbHands> constraint) {
    globalConstraints.update(ENbkWeaponType.getConstraints(), ENbHands.class, constraint);
  }

}
