package nbk.view.entity;

import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.view.entity.EntityResultRow;
import commons.view.utils.ConstraintPanel;
import nbk.controller.entity.NbkWeaponController;
import nbk.model.entity.characteristics.primary.enums.ENbHands;
import nbk.model.entity.characteristics.secondary.enums.ENbkPredefinedWeapon;
import nbk.model.entity.characteristics.secondary.enums.ENbkQuality;
import nbk.model.entity.characteristics.secondary.enums.ENbkWeaponType;
import nbk.model.entity.items.ENbkAvailableItem;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Germain on 13/06/2016.
 */
public class NbkWeaponOptionRow extends NbkEntityOptionRow {

  private final ConstraintPanel nbHandsPanel;
  private final Map<ENbHands, JCheckBox> nbHandsButtons;
  private final JCheckBox oneHandButton;
  private final JCheckBox twoHandsButton;

  NbkWeaponOptionRow() {
    super(ENbkAvailableItem.WEAPON);

    // hands constraints
    oneHandButton = new JCheckBox("1h", false);
    oneHandButton.setToolTipText("Includes one hand weapons");
    twoHandsButton = new JCheckBox("2h", false);
    twoHandsButton.setToolTipText("Includes two hands weapons");
    nbHandsButtons = new LinkedHashMap<>(2);
    nbHandsButtons.put(ENbHands.ONE, oneHandButton);
    nbHandsButtons.put(ENbHands.TWO, twoHandsButton);
    nbHandsPanel = new ConstraintPanel();
    nbHandsPanel.setLayout(new BoxLayout(nbHandsPanel, BoxLayout.Y_AXIS));
    nbHandsButtons.values().forEach(nbHandsPanel::add);
    constraintPanel.add(nbHandsPanel);

    finalizeRowConstruction();
  }

  @Override
  public void setControllers(EntityResultRow entityResultRow) {
    super.setControllers(new NbkWeaponController(this, entityResultRow));
    nbHandsButtons.forEach((nbHands, jCheckBox) ->
            jCheckBox.addActionListener(((NbkWeaponController) itemController).getNbHandsActionListener(nbHands)));
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
