package nbk.view.entity;

import commons.model.entity.constraints.GenericConstraint;
import commons.view.entity.EntityResultRow;
import commons.view.utils.ConstraintPanel;
import nbk.controller.entity.GenerateNbkWeaponActionListener;
import nbk.controller.entity.NbHandsActionListener;
import nbk.model.entity.constraints.NbHandsConstraints;
import nbk.model.entity.enums.ENbkWeaponType;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Germain on 13/06/2016.
 */
public class NbkWeaponOptionRow extends NbkEntityOptionRow {

  private final ConstraintPanel nbHandsPanel;
  private final ButtonGroup nbHandsButtonGroup;
  private final NbHandsConstraints<ENbkWeaponType> nbHandsConstraints;
  private final Map<GenericConstraint<ENbkWeaponType>, JRadioButton> nbHandsButtons;
  private final JRadioButton noHandButton;
  private final JRadioButton oneHandButton;
  private final JRadioButton twoHandsButton;

  NbkWeaponOptionRow() {
    super(ENbkAvailableItem.WEAPON);

    // hands constraints
    noHandButton = new JRadioButton("no", true);
    noHandButton.setToolTipText("No hand constraint");
    oneHandButton = new JRadioButton("1h", false);
    oneHandButton.setToolTipText("Will generate a one hand weapon");
    twoHandsButton = new JRadioButton("2h", false);
    twoHandsButton.setToolTipText("Will generate a two hands weapon");
    nbHandsButtons = new LinkedHashMap<>(3);
    nbHandsConstraints = new NbHandsConstraints<>(ENbkWeaponType.class);
    nbHandsButtons.put(nbHandsConstraints.getNoConstraint(), noHandButton);
    nbHandsButtons.put(nbHandsConstraints.getOneHand(), oneHandButton);
    nbHandsButtons.put(nbHandsConstraints.getTwoHands(), twoHandsButton);
    nbHandsButtonGroup = new ButtonGroup();
    nbHandsPanel = new ConstraintPanel();
    nbHandsPanel.setLayout(new BoxLayout(nbHandsPanel, BoxLayout.Y_AXIS));
    nbHandsButtons.values().forEach(rb -> {
      nbHandsButtonGroup.add(rb);
      nbHandsPanel.add(rb);
    });
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
    globalConstraints.put(ENbkWeaponType.class, nbHandsConstraints, constraint);
  }
}
