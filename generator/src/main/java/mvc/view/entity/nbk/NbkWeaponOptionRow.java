package mvc.view.entity.nbk;

import mvc.controller.entity.*;
import mvc.controller.entity.nbk.*;
import mvc.model.entity.enums.*;
import mvc.model.entity.utils.*;
import mvc.view.entity.*;

import javax.swing.*;
import java.util.*;
import java.util.function.*;

/**
 * Created by Germain on 13/06/2016.
 */
public class NbkWeaponOptionRow extends NbkEntityOptionRow {

  private final JPanel nbHandsPanel;
  private final ButtonGroup nbHandsButtonGroup;
  private final Map<JRadioButton, Predicate<ENbkWeaponType>> nbHandsButtons;
  private final JRadioButton noHandButton;
  private final JRadioButton oneHandButton;
  private final JRadioButton twoHandsButton;

  private final JButton generateItemButton;

  NbkWeaponOptionRow() {
    super(ENbkAvailableItem.WEAPON);
    // hands constraints
    noHandButton = new JRadioButton("no", true);
    oneHandButton = new JRadioButton("1h", false);
    twoHandsButton = new JRadioButton("2h", false);
    nbHandsButtons = new LinkedHashMap<>(3);
    nbHandsButtons.put(noHandButton, wt -> true);
    nbHandsButtons.put(oneHandButton, wt -> wt.getNbHands() == 1);
    nbHandsButtons.put(twoHandsButton, wt -> wt.getNbHands() == 2);
    nbHandsButtonGroup = new ButtonGroup();
    nbHandsPanel = new JPanel();
    nbHandsPanel.setLayout(new BoxLayout(nbHandsPanel, BoxLayout.Y_AXIS));
    nbHandsPanel.setEnabled(false);
    nbHandsButtons.keySet().stream().forEach(rb -> {
      rb.setEnabled(false);
      nbHandsButtonGroup.add(rb);
      nbHandsPanel.add(rb);
    });
    add(nbHandsPanel);
    constraints.put(ENbkWeaponType.class, new GenericConstraint<>());

    generateItemButton = new JButton("Generate");
    add(generateItemButton);
  }

  @Override
  public void setControllers(EntityResultRow entityResultRow) {
    super.setControllers(entityResultRow);
    generateItemButton.addActionListener(new GenerateNbkWeaponActionListener(this, entityResultRow));
    nbHandsButtons.keySet().stream()
            .forEach(rb -> rb.addActionListener(new NbHandsActionListener(this, nbHandsButtons.get(rb))));
  }

  @Override
  public void updateConstraintsAbility(boolean checkBoxSelected) {
    nbHandsPanel.setEnabled(checkBoxSelected);
    nbHandsButtons.keySet().stream().forEach(rb -> rb.setEnabled(checkBoxSelected));
  }

  public void updateNbHandsConstraint(Predicate<ENbkWeaponType> predicate) {
    constraints.put(ENbkWeaponType.class, new GenericConstraint<>(predicate));
  }

}
