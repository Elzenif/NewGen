package mvc.view.entity.nbk;

import mvc.controller.entity.nbk.NbkNbHandsActionListener;
import mvc.controller.entity.nbk.GenerateNbkWeaponActionListener;
import mvc.controller.entity.nbk.NbkQualityChangeListener;
import mvc.model.entity.constraints.NbkNbHandsConstraint;
import mvc.model.entity.constraints.NbkQualityConstraint;
import mvc.model.entity.enums.ENbkQuality;
import mvc.model.entity.enums.ENbkWeaponType;
import mvc.view.commons.ConstraintPanel;
import mvc.view.entity.EntityResultRow;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.util.EnumMap;

import static utils.TextFieldUtils.createTwoDigitsField;

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

  private final ConstraintPanel qualityPanel;
  private final JFormattedTextField qualityTextField;

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

    // quality constraints
    qualityTextField = createTwoDigitsField();
    qualityTextField.setToolTipText("Put a D100 roll result. The lower the result, the better the weapon");
    qualityPanel = new ConstraintPanel();
    qualityPanel.setLayout(new BoxLayout(qualityPanel, BoxLayout.Y_AXIS));
    qualityPanel.add(qualityTextField);
    constraintPanel.add(qualityPanel);
    globalConstraints.put(ENbkQuality.class, NbkQualityConstraint.class, NbkQualityConstraint.NO_CONSTRAINT);

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
    qualityTextField.addPropertyChangeListener(new NbkQualityChangeListener(this, qualityTextField));
  }

  public void updateNbHandsConstraint(NbkNbHandsConstraint nbHandsConstraint) {
    globalConstraints.put(ENbkWeaponType.class, NbkNbHandsConstraint.class, nbHandsConstraint);
  }

  public void updateQualityConstraint(NbkQualityConstraint qualityConstraint) {
    globalConstraints.put(ENbkQuality.class, NbkQualityConstraint.class, qualityConstraint);
  }
}
