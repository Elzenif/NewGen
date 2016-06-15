package mvc.view.entity.nbk;

import mvc.controller.entity.NbHandsActionListener;
import mvc.controller.entity.nbk.GenerateNbkWeaponActionListener;
import mvc.model.entity.constraints.NbHandsConstraint;
import mvc.model.entity.enums.ENbkWeaponType;
import mvc.view.entity.EntityResultRow;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.util.EnumMap;

/**
 * Created by Germain on 13/06/2016.
 */
public class NbkWeaponOptionRow extends NbkEntityOptionRow {

  private final JPanel nbHandsPanel;
  private final ButtonGroup nbHandsButtonGroup;
  private final EnumMap<NbHandsConstraint, JRadioButton> nbHandsButtons;
  private final JRadioButton noHandButton;
  private final JRadioButton oneHandButton;
  private final JRadioButton twoHandsButton;

  private final JButton generateItemButton;

  NbkWeaponOptionRow() {
    super(ENbkAvailableItem.WEAPON);
    // hands globalConstraints
    noHandButton = new JRadioButton("no", true);
    oneHandButton = new JRadioButton("1h", false);
    twoHandsButton = new JRadioButton("2h", false);
    nbHandsButtons = new EnumMap<>(NbHandsConstraint.class);
    nbHandsButtons.put(NbHandsConstraint.NO_CONSTRAINT, noHandButton);
    nbHandsButtons.put(NbHandsConstraint.ONE_HAND, oneHandButton);
    nbHandsButtons.put(NbHandsConstraint.TWO_HANDS, twoHandsButton);
    nbHandsButtonGroup = new ButtonGroup();
    nbHandsPanel = new JPanel();
    nbHandsPanel.setLayout(new BoxLayout(nbHandsPanel, BoxLayout.Y_AXIS));
    nbHandsPanel.setEnabled(false);
    nbHandsButtons.values().stream().forEach(rb -> {
      rb.setEnabled(false);
      nbHandsButtonGroup.add(rb);
      nbHandsPanel.add(rb);
    });
    add(nbHandsPanel);
    globalConstraints.put(ENbkWeaponType.class, NbHandsConstraint.class, NbHandsConstraint.NO_CONSTRAINT);

    generateItemButton = new JButton("Generate");
    add(generateItemButton);
  }

  @Override
  public void setControllers(EntityResultRow entityResultRow) {
    super.setControllers(entityResultRow);
    generateItemButton.addActionListener(new GenerateNbkWeaponActionListener(this, entityResultRow));
    nbHandsButtons.keySet().stream().forEach(nbHandsConstraint ->
            nbHandsButtons.get(nbHandsConstraint).addActionListener(new NbHandsActionListener(this, nbHandsConstraint)));
  }

  @Override
  public void updateConstraintsAbility(boolean checkBoxSelected) {
    nbHandsPanel.setEnabled(checkBoxSelected);
    nbHandsButtons.values().stream().forEach(rb -> rb.setEnabled(checkBoxSelected));
  }

  public void updateNbHandsConstraint(NbHandsConstraint nbHandsConstraint) {
    globalConstraints.put(ENbkWeaponType.class, NbHandsConstraint.class, nbHandsConstraint);
  }

}
