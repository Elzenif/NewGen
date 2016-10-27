package nbk.controller.entity.items;

import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.view.entity.items.ItemOptionRow;
import nbk.model.commons.NbkGame;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static commons.utils.MathUtils.findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues;

/**
 * Created by Germain on 26/10/2016.
 */
public class NbkRarityChangeListener implements ChangeListener {

  private final NbkItemController itemController;
  private final ItemOptionRow<NbkGame> itemOptionRow;

  public NbkRarityChangeListener(NbkItemController itemController, ItemOptionRow<NbkGame> itemOptionRow) {
    this.itemController = itemController;
    this.itemOptionRow = itemOptionRow;
  }

  @Override
  public void stateChanged(ChangeEvent e) {
    GenericPredicateConstraint<EItemRarity> constraint;
    int rarityLevel = itemOptionRow.getQuality();
    constraint = findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues(rarityLevel,
        EItemRarity.getConstraintMapView());
    itemController.updateRarityConstraint(constraint);
  }
}
