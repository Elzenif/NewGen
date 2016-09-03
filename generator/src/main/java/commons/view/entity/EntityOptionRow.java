package commons.view.entity;

import commons.controller.entity.EntityController;
import commons.model.commons.Game;
import commons.model.entity.IAvailableEntity;
import commons.utils.StringUtils;
import commons.utils.TextFieldUtils;
import commons.view.utils.Constants;
import commons.view.utils.ConstraintPanel;
import commons.view.utils.HasConstraintPanel;
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

/**
 * Created by Germain on 05/06/2016.
 */
public abstract class EntityOptionRow<T extends Game> extends OptionRow<EntityResultRow> implements HasConstraintPanel {

  private final int labelSize;
  private final String entityName;

  private final JSpinner numberOfEntitiesSpinner;
  private final SpinnerNumberModel numberOfEntitiesModel;

  private final JLabel infoLabel;

  private final JPanel constraintsCheckBoxPanel;
  private final JCheckBox constraintsCheckBox;
  private final JLabel constraintsCheckBoxLabel;

  protected final ConstraintPanel constraintPanel;

  private final ConstraintPanel qualityPanel;
  private final JFormattedTextField qualityTextField;

  private JButton generateEntityButton;

  protected EntityController<T> entityController;

  protected EntityOptionRow(IAvailableEntity<T> availableEntity, int labelSize) {
    super();
    this.labelSize = labelSize;
    entityName = availableEntity.getName();

    numberOfEntitiesModel = new SpinnerNumberModel(1, 1, 9, 1);
    numberOfEntitiesSpinner = new JSpinner(numberOfEntitiesModel);
    numberOfEntitiesSpinner.setToolTipText("The number of " + entityName + " to generate");
    add(numberOfEntitiesSpinner);

    infoLabel = new JLabel(StringUtils.leftAlign(labelSize, entityName));
    add(infoLabel);

    // globalConstraints
    constraintsCheckBoxLabel = new JLabel("Constraints");
    constraintsCheckBoxLabel.setAlignmentX(CENTER_ALIGNMENT);
    constraintsCheckBox = new JCheckBox();
    constraintsCheckBox.setAlignmentX(CENTER_ALIGNMENT);
    constraintsCheckBoxPanel = new JPanel();
    constraintsCheckBoxPanel.setLayout(new BoxLayout(constraintsCheckBoxPanel, BoxLayout.Y_AXIS));
    constraintsCheckBoxPanel.add(constraintsCheckBoxLabel);
    constraintsCheckBoxPanel.add(constraintsCheckBox);
    add(constraintsCheckBoxPanel);

    constraintPanel = new ConstraintPanel();
    constraintPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP));

    // quality constraints
    qualityTextField = TextFieldUtils.createTwoDigitsField();
    qualityTextField.setToolTipText("Put a D100 roll result. The lower the result, the better the " + entityName);
    qualityPanel = new ConstraintPanel();
    qualityPanel.setLayout(new BoxLayout(qualityPanel, BoxLayout.Y_AXIS));
    qualityPanel.add(qualityTextField);
    constraintPanel.add(qualityPanel);
  }

  protected void finalizeRowConstruction() {
    add(constraintPanel);

    generateEntityButton = new JButton("Generate");
    generateEntityButton.setToolTipText("Generate a random " + entityName);
    add(generateEntityButton);

    updateConstraintsAbility(false);
  }

  protected void setControllers(EntityController<T> entityController) {
    this.entityController = entityController;
    constraintsCheckBox.addItemListener(entityController.getConstraintsItemListener());
    qualityTextField.addPropertyChangeListener(entityController.getRarityChangeListener());
    generateEntityButton.addActionListener(entityController.getGenerateEntityActionListener());
  }

  public int getNumberOfEntitiesSelected() {
    return numberOfEntitiesModel.getNumber().intValue();
  }

  @Override
  public boolean isConstraintsCheckBoxSelected() {
    return constraintsCheckBox.isSelected();
  }

  @Override
  public void updateConstraintsAbility(boolean checkBoxSelected) {
    constraintPanel.setEnabled(checkBoxSelected);
  }

  public JFormattedTextField getQualityTextField() {
    return qualityTextField;
  }
}
