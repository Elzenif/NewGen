package nbk.view.entity;

import commons.controller.entity.MagicOrRelicActionListener;
import commons.model.entity.constraints.MagicOrRelicConstraint;
import commons.model.entity.enums.EMagic;
import commons.view.entity.EntityResultRow;
import commons.view.utils.ConstraintPanel;
import nbk.controller.entity.GenerateNbkWeaponActionListener;
import nbk.controller.entity.NbkNbHandsActionListener;
import nbk.model.entity.constraints.NbkNbHandsConstraint;
import nbk.model.entity.enums.ENbkPredefinedWeapon;
import nbk.model.entity.enums.ENbkWeaponType;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Germain on 13/06/2016.
 */
public class NbkWeaponOptionRow extends NbkEntityOptionRow {

  private final ConstraintPanel magicPanel;
  private final ButtonGroup magicButtonGroup;
  private final Map<MagicOrRelicConstraint<ENbkPredefinedWeapon>, JRadioButton> magicButtons;
  private final JRadioButton notMagicButton;
  private final JRadioButton magicOrRelicButton;

  private final ConstraintPanel nbHandsPanel;
  private final ButtonGroup nbHandsButtonGroup;
  private final EnumMap<NbkNbHandsConstraint, JRadioButton> nbHandsButtons;
  private final JRadioButton noHandButton;
  private final JRadioButton oneHandButton;
  private final JRadioButton twoHandsButton;

  private final JButton generateItemButton;

  NbkWeaponOptionRow() {
    super(ENbkAvailableItem.WEAPON);

    // magic constraints
    notMagicButton = new JRadioButton("no", true);
    notMagicButton.setToolTipText("No magic or relic constraint");
    magicOrRelicButton = new JRadioButton("magic", false);
    magicOrRelicButton.setToolTipText("Will generate a magic or relic weapon");
    magicButtons = new LinkedHashMap<>();
    magicButtons.put(new MagicOrRelicConstraint<>(w -> true), notMagicButton);
    magicButtons.put(new MagicOrRelicConstraint<>(w -> w.getMagic() == EMagic.MAGIC || w.getMagic() == EMagic.RELIC),
            magicOrRelicButton);
    magicButtonGroup = new ButtonGroup();
    magicPanel = new ConstraintPanel();
    magicPanel.setLayout(new BoxLayout(magicPanel, BoxLayout.Y_AXIS));
    magicButtons.values().forEach(rb -> {
      magicButtonGroup.add(rb);
      magicPanel.add(rb);
    });
    constraintPanel.add(magicPanel);
    globalConstraints.put(ENbkPredefinedWeapon.class, MagicOrRelicConstraint.class, new MagicOrRelicConstraint<>(w -> true));

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
    nbHandsButtons.values().forEach(rb -> {
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
    magicButtons.keySet().forEach(morConstraint ->
            magicButtons.get(morConstraint).addActionListener(new MagicOrRelicActionListener(this, morConstraint)));
    nbHandsButtons.keySet().forEach(nbhConstraint ->
            nbHandsButtons.get(nbhConstraint).addActionListener(new NbkNbHandsActionListener(this, nbhConstraint)));
  }

  public void updateNbHandsConstraint(NbkNbHandsConstraint nbHandsConstraint) {
    globalConstraints.put(ENbkWeaponType.class, NbkNbHandsConstraint.class, nbHandsConstraint);
  }

  public void updateMagicOrRelicConstraint(MagicOrRelicConstraint magicOrRelicConstraint) {
    globalConstraints.put(ENbkPredefinedWeapon.class, MagicOrRelicConstraint.class, magicOrRelicConstraint);
  }

  public boolean isMagicOrRelicConstraint() {
    return isConstraintsCheckBoxSelected() && magicOrRelicButton.isSelected();
  }
}
