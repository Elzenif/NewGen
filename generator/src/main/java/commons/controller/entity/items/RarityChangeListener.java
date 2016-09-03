package commons.controller.entity.items;

import commons.controller.entity.EntityController;
import commons.model.commons.Game;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.view.entity.EntityOptionRow;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static commons.utils.MathUtils.findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues;

/**
 * Created by Germain on 18/06/2016.
 */
public class RarityChangeListener<T extends Game> implements PropertyChangeListener {

  private final EntityController<T> entityController;
  private final EntityOptionRow<T> entityOptionRow;

  public RarityChangeListener(EntityController<T> entityController, EntityOptionRow<T> entityOptionRow) {
    this.entityController = entityController;
    this.entityOptionRow = entityOptionRow;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    GenericConstraint<EItemRarity> constraint;
    try {
      int rarityLevel = Integer.parseInt(entityOptionRow.getQualityTextField().getText()) + 1; // so that the result belongs to [1;100]
      constraint = findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues(rarityLevel, EItemRarity.getConstraintMapView());
    } catch (NumberFormatException e) {
      constraint = () -> p -> true;
    }
    entityController.updateRarityConstraint(constraint);
  }
}
