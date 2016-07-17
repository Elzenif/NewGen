package commons.controller.entity;

import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.view.entity.EntityOptionRow;

import javax.swing.JFormattedTextField;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static commons.utils.MathUtils.findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues;

/**
 * Created by Germain on 18/06/2016.
 */
public class RarityChangeListener implements PropertyChangeListener {

  private final EntityOptionRow entityOptionRow;
  private final JFormattedTextField qualityTextField;

  public RarityChangeListener(EntityOptionRow entityOptionRow, JFormattedTextField qualityTextField) {
    this.entityOptionRow = entityOptionRow;
    this.qualityTextField = qualityTextField;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    GenericConstraint<ERarity> constraint;
    try {
      int rarityLevel = Integer.parseInt(qualityTextField.getText()) + 1; // so that the result belongs to [1;100]
      constraint = findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues(
              rarityLevel, ERarity.getConstraintMapView());
    } catch (NumberFormatException e) {
      constraint = () -> p -> true;
    }
    entityOptionRow.updateRarityConstraint(constraint);
  }
}
