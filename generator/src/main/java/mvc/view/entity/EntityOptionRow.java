package mvc.view.entity;

import mvc.controller.entity.ConstraintsItemListener;
import mvc.model.entity.game.*;
import mvc.model.entity.utils.Constraints;
import mvc.view.commons.OptionRow;
import utils.MathUtils;
import utils.StringUtils;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * Created by Germain on 05/06/2016.
 */
public abstract class EntityOptionRow<S extends Game> extends OptionRow<EntityResultRow> {

  private final int labelSize;

  private final String itemName;

  private final JSpinner numberOfItemsSpinner;
  private final SpinnerNumberModel numberOfItemsModel;

  private final JLabel infoLabel;

  private final JPanel constraintsPanel;
  private final JCheckBox constraintsCheckBox;
  private final JLabel constraintsLabel;
  protected final Constraints constraints;

  protected EntityOptionRow(IAvailableItem availableItem, S game) {
    super();
    labelSize = MathUtils.maxLength(IAvailableItem.getValues(game.getAvailableItems()));
    this.itemName = availableItem.getName();

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
  }

  @Override
  public void setControllers(EntityResultRow entityResultRow) {
    constraintsCheckBox.addItemListener(new ConstraintsItemListener(this));
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

  public abstract void updateConstraintsAbility(boolean checkBoxSelected);

}
