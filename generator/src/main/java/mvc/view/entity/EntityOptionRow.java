package mvc.view.entity;

import mvc.controller.entity.ConstraintsItemListener;
import mvc.controller.entity.GenerateItemActionListener;
import mvc.controller.entity.NbHandsActionListener;
import mvc.model.entity.enums.ENbkWeaponType;
import mvc.model.entity.items.Item;
import mvc.model.entity.utils.Constraints;
import mvc.model.entity.utils.GenericConstraint;
import mvc.model.entity.utils.IAvailableItem;
import mvc.view.commons.OptionRow;
import utils.MathUtils;
import utils.StringUtils;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by Germain on 05/06/2016.
 */
public abstract class EntityOptionRow extends OptionRow<EntityResultRow> {

  private final int labelSize;
  private final Class<? extends Item> itemClass;

  private final String itemName;

  private final JSpinner numberOfItemsSpinner;
  private final SpinnerNumberModel numberOfItemsModel;

  private final JLabel infoLabel;

  private final JPanel constraintsPanel;
  private final JCheckBox constraintsCheckBox;
  private final JLabel constraintsLabel;
  private final Constraints constraints;

  private final JPanel nbHandsPanel;
  private final ButtonGroup nbHandsButtonGroup;
  private final Map<JRadioButton, Predicate<ENbkWeaponType>> nbHandsButtons;
  private final JRadioButton noHandButton;
  private final JRadioButton oneHandButton;
  private final JRadioButton twoHandsButton;

  private final JButton generateItemButton;


  EntityOptionRow(IAvailableItem availableItem) {
    super();
    labelSize = MathUtils.maxLength(IAvailableItem.getValues(availableItem.getClass()));
    this.itemName = availableItem.getName();
    this.itemClass = availableItem.getItemClass();

    numberOfItemsModel = new SpinnerNumberModel(1, 1, 9, 1);
    numberOfItemsSpinner = new JSpinner(numberOfItemsModel);
    add(numberOfItemsSpinner);

    infoLabel = new JLabel(StringUtils.leftAlign(labelSize, itemName));
    add(infoLabel);

    // constraints
    constraintsLabel = new JLabel("Constraints");
    constraintsLabel.setAlignmentX(CENTER_ALIGNMENT);
    constraintsCheckBox = new JCheckBox();
    constraintsCheckBox.setAlignmentX(CENTER_ALIGNMENT);
    constraintsPanel = new JPanel();
    constraintsPanel.setLayout(new BoxLayout(constraintsPanel, BoxLayout.Y_AXIS));
    constraintsPanel.add(constraintsLabel);
    constraintsPanel.add(constraintsCheckBox);
    add(constraintsPanel);
    constraints = new Constraints();

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
    generateItemButton.addActionListener(new GenerateItemActionListener(this, entityResultRow, itemClass));
    constraintsCheckBox.addItemListener(new ConstraintsItemListener(this));
    nbHandsButtons.keySet().stream()
            .forEach(rb -> rb.addActionListener(new NbHandsActionListener(this, nbHandsButtons.get(rb))));
  }

  public int getNumberOfItemsSelected() {
    return numberOfItemsModel.getNumber().intValue();
  }

  public Constraints getConstraints() {
    return constraints;
  }

  public boolean isConstraintsCheckBoxSelected() {
    return constraintsCheckBox.isSelected();
  }

  public void updateConstraintsAbility(boolean checkBoxSelected) {
    nbHandsPanel.setEnabled(checkBoxSelected);
    nbHandsButtons.keySet().stream().forEach(rb -> rb.setEnabled(checkBoxSelected));
  }

  public void updateNbHandsConstraint(Predicate<ENbkWeaponType> predicate) {
    constraints.put(ENbkWeaponType.class, new GenericConstraint<>(predicate));
  }
}
