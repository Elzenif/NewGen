package commons.controller.entity.items;

import commons.model.commons.Game;
import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.view.entity.items.ItemOptionRow;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static commons.utils.MathUtils.findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues;

/**
 * Created by Germain on 18/06/2016.
 */
public class RarityChangeListener<G extends Game> implements PropertyChangeListener {

  private final ItemController<G> itemController;
  private final ItemOptionRow<G> itemOptionRow;

  public RarityChangeListener(ItemController<G> itemController, ItemOptionRow<G> itemOptionRow) {
    this.itemController = itemController;
    this.itemOptionRow = itemOptionRow;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    GenericPredicateConstraint<EItemRarity> constraint;
    try {
      int rarityLevel = itemOptionRow.getQuality();
      constraint = findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues(rarityLevel, EItemRarity.getConstraintMapView());
    } catch (NumberFormatException e) {
      constraint = () -> p -> true;
    }
    itemController.updateRarityConstraint(constraint);
  }
}
