package commons.view.entity;

import commons.controller.entity.EntityController;
import commons.model.commons.Game;
import commons.model.entity.IAvailableEntity;
import commons.utils.TextFieldUtils;
import commons.view.utils.ConstraintOptionRow;
import commons.view.utils.ConstraintPanel;

import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * Created by Germain on 05/06/2016.
 */
public abstract class EntityOptionRow<G extends Game> extends ConstraintOptionRow<EntityResultRow> {

  private final JSpinner numberOfEntitiesSpinner;
  private final SpinnerNumberModel numberOfEntitiesModel;

  private final ConstraintPanel qualityPanel;
  private final JFormattedTextField qualityTextField;

  protected EntityOptionRow(IAvailableEntity<G> availableEntity, int labelSize) {
    super(labelSize, availableEntity.getName());

    numberOfEntitiesModel = new SpinnerNumberModel(1, 1, 9, 1);
    numberOfEntitiesSpinner = new JSpinner(numberOfEntitiesModel);
    numberOfEntitiesSpinner.setToolTipText("The number of " + name + " to generate");
    add(numberOfEntitiesSpinner);

    add(infoLabel);

    add(constraintsCheckBoxPanel);

    // quality constraints
    qualityTextField = TextFieldUtils.createTwoDigitsField();
    qualityTextField.setToolTipText("Put a D100 roll result. The lower the result, the better the " + name);
    qualityPanel = new ConstraintPanel();
    qualityPanel.setLayout(new BoxLayout(qualityPanel, BoxLayout.Y_AXIS));
    qualityPanel.add(qualityTextField);
    constraintPanel.add(qualityPanel);
  }

  protected void setControllers(EntityController<G> entityController) {
    super.setControllers(entityController);
    qualityTextField.addPropertyChangeListener(((EntityController) controller).getRarityChangeListener());
    generateButton.addActionListener(controller.getGenerateActionListener());
  }

  public int getNumberOfEntitiesSelected() {
    return numberOfEntitiesModel.getNumber().intValue();
  }

  public JFormattedTextField getQualityTextField() {
    return qualityTextField;
  }
}
