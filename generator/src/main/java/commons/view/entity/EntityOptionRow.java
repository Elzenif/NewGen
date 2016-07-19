package commons.view.entity;

import commons.controller.entity.ConstraintsItemListener;
import commons.controller.entity.RarityChangeListener;
import commons.model.commons.Game;
import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.items.IAvailableItem;
import commons.utils.MathUtils;
import commons.utils.StringUtils;
import commons.view.utils.Constants;
import commons.view.utils.ConstraintPanel;
import commons.view.utils.OptionRow;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;

import static commons.utils.TextFieldUtils.createTwoDigitsField;

/**
 * Created by Germain on 05/06/2016.
 */
public abstract class EntityOptionRow<S extends Game> extends OptionRow<EntityResultRow> {

  private final int labelSize;
  private final String itemName;

  private final JSpinner numberOfItemsSpinner;
  private final SpinnerNumberModel numberOfItemsModel;

  private final JLabel infoLabel;

  private final JPanel constraintsCheckBoxPanel;
  private final JCheckBox constraintsCheckBox;
  private final JLabel constraintsCheckBoxLabel;

  protected final GlobalConstraints globalConstraints;
  protected final ConstraintPanel constraintPanel;

  private final ConstraintPanel qualityPanel;
  private final JFormattedTextField qualityTextField;

  protected JButton generateItemButton;


  protected EntityOptionRow(IAvailableItem<S> availableItem, S game) {
    super();
    labelSize = MathUtils.maxLength(game.getAvailableItems());
    itemName = availableItem.getName();

    numberOfItemsModel = new SpinnerNumberModel(1, 1, 9, 1);
    numberOfItemsSpinner = new JSpinner(numberOfItemsModel);
    numberOfItemsSpinner.setToolTipText("The number of " + itemName + " to generate");
    add(numberOfItemsSpinner);

    infoLabel = new JLabel(StringUtils.leftAlign(labelSize, itemName));
    add(infoLabel);

    // globalConstraints
    constraintsCheckBoxLabel = new JLabel("constraints");
    constraintsCheckBoxLabel.setAlignmentX(CENTER_ALIGNMENT);
    constraintsCheckBox = new JCheckBox();
    constraintsCheckBox.setAlignmentX(CENTER_ALIGNMENT);
    constraintsCheckBoxPanel = new JPanel();
    constraintsCheckBoxPanel.setLayout(new BoxLayout(constraintsCheckBoxPanel, BoxLayout.Y_AXIS));
    constraintsCheckBoxPanel.add(constraintsCheckBoxLabel);
    constraintsCheckBoxPanel.add(constraintsCheckBox);
    add(constraintsCheckBoxPanel);

    globalConstraints = new GlobalConstraints();
    constraintPanel = new ConstraintPanel();
    constraintPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));

    // quality constraints
    qualityTextField = createTwoDigitsField();
    qualityTextField.setToolTipText("Put a D100 roll result. The lower the result, the better the " + itemName);
    qualityPanel = new ConstraintPanel();
    qualityPanel.setLayout(new BoxLayout(qualityPanel, BoxLayout.Y_AXIS));
    qualityPanel.add(qualityTextField);
    constraintPanel.add(qualityPanel);
  }

  protected void finalizeRowConstruction() {
    add(constraintPanel);

    generateItemButton = new JButton("Generate");
    generateItemButton.setToolTipText("Generate a random " + itemName);
    add(generateItemButton);

    updateConstraintsAbility(false);
  }

  @Override
  public void setControllers(EntityResultRow entityResultRow) {
    constraintsCheckBox.addItemListener(new ConstraintsItemListener(this));
    qualityTextField.addPropertyChangeListener(new RarityChangeListener(this, qualityTextField));
  }

  public int getNumberOfItemsSelected() {
    return numberOfItemsModel.getNumber().intValue();
  }

  public GlobalConstraints getGlobalConstraints() {
    return globalConstraints;
  }

  public boolean isConstraintsCheckBoxSelected() {
    return constraintsCheckBox.isSelected();
  }

  public void updateConstraintsAbility(boolean checkBoxSelected) {
    constraintPanel.setEnabled(checkBoxSelected);
  }

  public void updateRarityConstraint(GenericConstraint<ERarity> constraint) {
    globalConstraints.clear(ERarity.getConstraints());
    globalConstraints.update(ERarity.getConstraints(), ERarity.class, constraint);
  }
}
