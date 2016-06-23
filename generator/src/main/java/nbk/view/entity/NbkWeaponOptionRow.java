package nbk.view.entity;

import commons.view.entity.EntityResultRow;
import commons.view.utils.ConstraintPanel;
import nbk.controller.entity.GenerateNbkWeaponActionListener;
import nbk.controller.entity.NbkNbHandsActionListener;
import nbk.model.entity.constraints.NbkNbHandsConstraint;
import nbk.model.entity.enums.ENbkWeaponType;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.util.EnumMap;

/**
 * Created by Germain on 13/06/2016.
 */
public class NbkWeaponOptionRow extends NbkEntityOptionRow {

  private final ConstraintPanel nbHandsPanel;
  private final ButtonGroup nbHandsButtonGroup;
  private final EnumMap<NbkNbHandsConstraint, JRadioButton> nbHandsButtons;
  private final JRadioButton noHandButton;
  private final JRadioButton oneHandButton;
  private final JRadioButton twoHandsButton;

  private final JButton generateItemButton;

  NbkWeaponOptionRow() {
    super(ENbkAvailableItem.WEAPON);
    // hands constraints
    noHandButton = new JRadioButton("no", true);
    noHandButton.setToolTipText("No hand constraint");
    oneHandButton = new JRadioButton("1h", false);
    oneHandButton.setToolTipText("Will generate a one hand weapon");
    twoHandsButton = new JRadioButton("2h", false);
    twoHandsButton.setToolTipText("Will generate a two hands weapon");
    nbHandsButtons = new EnumMap<>(NbkNbHandsConstraint.class);
    nbHandsButtons.put(NbkNbHandsConstraint.NO_CONSTRAINT, noHandButton);
    nbHandsButtons.put(NbkNbHandsConstraint.ONE_HAND, oneHandButton);
    nbHandsButtons.put(NbkNbHandsConstraint.TWO_HANDS, twoHandsButton);
    nbHandsButtonGroup = new ButtonGroup();
    nbHandsPanel = new ConstraintPanel();
    nbHandsPanel.setLayout(new BoxLayout(nbHandsPanel, BoxLayout.Y_AXIS));
    nbHandsButtons.values().stream().forEach(rb -> {
      nbHandsButtonGroup.add(rb);
      nbHandsPanel.add(rb);
    });
    constraintPanel.add(nbHandsPanel);
    globalConstraints.put(ENbkWeaponType.class, NbkNbHandsConstraint.class, NbkNbHandsConstraint.NO_CONSTRAINT);

    add(constraintPanel);

    generateItemButton = new JButton("Generate");
    add(generateItemButton);

    updateConstraintsAbility(false);
  }

  @Override
  public void setControllers(EntityResultRow entityResultRow) {
    super.setControllers(entityResultRow);
    generateItemButton.addActionListener(new GenerateNbkWeaponActionListener(this, entityResultRow));
    nbHandsButtons.keySet().stream().forEach(nbhConstraint ->
            nbHandsButtons.get(nbhConstraint).addActionListener(new NbkNbHandsActionListener(this, nbhConstraint)));
  }

  public void updateNbHandsConstraint(NbkNbHandsConstraint nbHandsConstraint) {
    globalConstraints.put(ENbkWeaponType.class, NbkNbHandsConstraint.class, nbHandsConstraint);
  }
}
