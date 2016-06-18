package mvc.controller.entity.nbk;

import mvc.model.entity.constraints.NbkQualityConstraint;
import mvc.view.entity.nbk.NbkWeaponOptionRow;

import javax.swing.JFormattedTextField;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static utils.MathUtils.findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues;

/**
 * Created by Germain on 18/06/2016.
 */
public class NbkQualityChangeListener implements PropertyChangeListener {

  private final NbkWeaponOptionRow entityOptionRow;
  private final JFormattedTextField qualityTextField;

  public NbkQualityChangeListener(NbkWeaponOptionRow entityOptionRow, JFormattedTextField qualityTextField) {
    this.entityOptionRow = entityOptionRow;
    this.qualityTextField = qualityTextField;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    NbkQualityConstraint qualityConstraint;
    try {
      int rarityLevel = Integer.parseInt(qualityTextField.getText()) + 1; // so that the result belongs to [1;100]
      qualityConstraint = findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues(
              rarityLevel, NbkQualityConstraint.constraintMap);
    } catch (NumberFormatException e) {
      qualityConstraint = NbkQualityConstraint.NO_CONSTRAINT;
    }
    entityOptionRow.updateQualityConstraint(qualityConstraint);
  }
}
