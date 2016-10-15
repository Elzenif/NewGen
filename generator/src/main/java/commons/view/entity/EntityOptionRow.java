package commons.view.entity;

import commons.controller.entity.EntityController;
import commons.model.commons.Game;
import commons.model.entity.IAvailableEntity;
import commons.utils.TextFieldUtils;
import commons.view.commons.options.ConstraintOptionRow;
import commons.view.utils.ConstraintPanel;

import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.text.MessageFormat;

import static commons.view.utils.Constants.resourceBundle;

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
    numberOfEntitiesSpinner.setToolTipText(resourceBundle.getString("tooltip.entity.numberToGenerate"));
    leftPanel.add(numberOfEntitiesSpinner);

    leftPanel.add(infoLabel);

    centerPanel.add(constraintsCheckBoxPanel);

    // quality constraints
    qualityTextField = TextFieldUtils.createTwoDigitsField();
    qualityTextField.setToolTipText(MessageFormat.format(resourceBundle.getString("tooltip.entity.qualityTextField"), name));
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
