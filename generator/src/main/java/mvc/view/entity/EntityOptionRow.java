package mvc.view.entity;

import mvc.controller.entity.ConstraintsItemListener;
import mvc.model.entity.constraints.GlobalConstraints;
import mvc.model.entity.game.Game;
import mvc.view.commons.Constants;
import mvc.view.commons.ConstraintPanel;
import mvc.view.commons.OptionRow;
import utils.MathUtils;
import utils.StringUtils;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;

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
  protected final ConstraintPanel constraintPanel;
  protected final GlobalConstraints globalConstraints;

  protected EntityOptionRow(IAvailableItem availableItem, S game) {
    super();
    labelSize = MathUtils.maxLength(IAvailableItem.getValues(game.getAvailableItems()));
    this.itemName = (String) availableItem.getName();

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
    constraintPanel = new ConstraintPanel();
    constraintPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    globalConstraints = new GlobalConstraints();
  }

  @Override
  public void setControllers(EntityResultRow entityResultRow) {
    constraintsCheckBox.addItemListener(new ConstraintsItemListener(this));
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

}
