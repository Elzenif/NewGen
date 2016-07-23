package commons.controller.entity;

import commons.model.commons.Game;
import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.view.entity.EntityOptionRow;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static commons.utils.MathUtils.findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues;

/**
 * Created by Germain on 18/06/2016.
 */
public class RarityChangeListener<T extends Game> implements PropertyChangeListener {

  private final EntityOptionRow<T> entityOptionRow;

  public RarityChangeListener(EntityOptionRow<T> entityOptionRow) {
    this.entityOptionRow = entityOptionRow;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    GenericConstraint<ERarity> constraint;
    try {
      int rarityLevel = Integer.parseInt(entityOptionRow.getQualityTextField().getText()) + 1; // so that the result belongs to [1;100]
      constraint = findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues(rarityLevel, ERarity.getConstraintMapView());
    } catch (NumberFormatException e) {
      constraint = () -> p -> true;
    }
    entityOptionRow.updateRarityConstraint(constraint);
  }
}
