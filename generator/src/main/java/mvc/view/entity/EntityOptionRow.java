package mvc.view.entity;

import mvc.controller.entity.ConstraintsItemListener;
import mvc.controller.entity.RarityChangeListener;
import mvc.model.entity.constraints.GlobalConstraints;
import mvc.model.entity.constraints.RarityConstraint;
import mvc.model.entity.enums.ENbkQuality;
import mvc.model.entity.game.Game;
import mvc.model.entity.utils.ERarity;
import mvc.view.commons.Constants;
import mvc.view.commons.ConstraintPanel;
import mvc.view.commons.OptionRow;
import utils.MathUtils;
import utils.StringUtils;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;

import static utils.TextFieldUtils.createTwoDigitsField;

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


  protected EntityOptionRow(IAvailableItem availableItem, S game) {
    super();
    labelSize = MathUtils.maxLength(IAvailableItem.getValues(game.getAvailableItems()));
    itemName = (String) availableItem.getName();

    numberOfItemsModel = new SpinnerNumberModel(1, 1, 9, 1);
    numberOfItemsSpinner = new JSpinner(numberOfItemsModel);
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
    globalConstraints.put(ERarity.class, RarityConstraint.class, RarityConstraint.NO_CONSTRAINT);
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

  public void updateRarityConstraint(RarityConstraint rarityConstraint) {
    globalConstraints.put(ERarity.class, RarityConstraint.class, rarityConstraint);
  }

}
