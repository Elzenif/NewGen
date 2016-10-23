package commons.view.entity;

import commons.controller.entity.EntityController;
import commons.model.commons.Game;
import commons.model.commons.GenerationConstraint;
import commons.model.entity.IAvailableEntity;
import commons.view.commons.options.ConstraintOptionRow;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 05/06/2016.
 */
public abstract class EntityOptionRow<G extends Game, GC extends GenerationConstraint>
    extends ConstraintOptionRow<EntityResultRow> {

  private final JSpinner numberOfEntitiesSpinner;
  private final SpinnerNumberModel numberOfEntitiesModel;

  protected EntityOptionRow(IAvailableEntity<G> availableEntity, int labelSize) {
    super(labelSize, availableEntity.getName());

    numberOfEntitiesModel = new SpinnerNumberModel(1, 1, 9, 1);
    numberOfEntitiesSpinner = new JSpinner(numberOfEntitiesModel);
    numberOfEntitiesSpinner.setToolTipText(resourceBundle.getString("tooltip.entity.numberToGenerate"));
    leftPanel.add(numberOfEntitiesSpinner);

    leftPanel.add(infoLabel);

    centerPanel.add(constraintsCheckBoxPanel);

  }

  protected void setControllers(EntityController<G, GC> entityController) {
    super.setControllers(entityController);
  }

  public int getNumberOfEntitiesSelected() {
    return numberOfEntitiesModel.getNumber().intValue();
  }
}
