package nbk.controller.entity;

import commons.controller.entity.ItemController;
import commons.view.entity.EntityResultRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.characteristics.primary.enums.ENbHands;
import nbk.view.entity.NbkWeaponOptionRow;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 23/07/2016.
 */
public class NbkWeaponController extends ItemController<NbkGame> {

  private EnumMap<ENbHands, ActionListener> nbHandsActionListenerEnumMap = new EnumMap<>(ENbHands.class);

  public NbkWeaponController(NbkWeaponOptionRow nbkWeaponOptionRow, EntityResultRow entityResultRow) {
    super(nbkWeaponOptionRow, new GenerateNbkWeaponActionListener(nbkWeaponOptionRow, entityResultRow));

    Arrays.stream(ENbHands.values()).forEach(nbHands ->
            nbHandsActionListenerEnumMap.put(nbHands, new NbHandsActionListener(nbkWeaponOptionRow, nbHands)));
  }

  public ActionListener getNbHandsActionListener(ENbHands nbHands) {
    return nbHandsActionListenerEnumMap.get(nbHands);
  }
}
