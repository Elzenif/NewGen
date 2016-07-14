package nbk.view.entity;

import commons.model.entity.constraints.GenericConstraint;
import commons.view.entity.EntityResultRow;
import commons.view.utils.ConstraintPanel;
import nbk.controller.entity.GenerateNbkWeaponActionListener;
import nbk.controller.entity.NbHandsActionListener;
import nbk.model.entity.characteristics.secondary.enums.ENbkWeaponType;
import nbk.model.entity.constraints.NbHandsConstraints;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Germain on 13/06/2016.
 */
public class NbkWeaponOptionRow extends NbkEntityOptionRow {

  private final ConstraintPanel nbHandsPanel;
  private final NbHandsConstraints<ENbkWeaponType> nbHandsConstraints;
  private final Map<GenericConstraint<ENbkWeaponType>, JCheckBox> nbHandsButtons;
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
    nbHandsConstraints = new NbHandsConstraints<>(ENbkWeaponType.class);
    nbHandsButtons.put(nbHandsConstraints.ONE_HAND, oneHandButton);
    nbHandsButtons.put(nbHandsConstraints.TWO_HANDS, twoHandsButton);
    nbHandsPanel = new ConstraintPanel();
    nbHandsPanel.setLayout(new BoxLayout(nbHandsPanel, BoxLayout.Y_AXIS));
    nbHandsButtons.values().forEach(nbHandsPanel::add);
    constraintPanel.add(nbHandsPanel);

    finalizeRowConstruction();
  }

  @Override
  public void setControllers(EntityResultRow entityResultRow) {
    super.setControllers(entityResultRow);
    generateItemButton.addActionListener(new GenerateNbkWeaponActionListener(this, entityResultRow));
    nbHandsButtons.keySet().forEach(nbhConstraint ->
            nbHandsButtons.get(nbhConstraint).addActionListener(new NbHandsActionListener(this, nbhConstraint)));
  }

  public void updateNbHandsConstraint(GenericConstraint<ENbkWeaponType> constraint) {
    globalConstraints.update(ENbkWeaponType.class, nbHandsConstraints, constraint);
  }
}
