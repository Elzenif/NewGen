package nbk.controller.entity.items;

import commons.controller.entity.items.ItemController;
import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.view.entity.items.ItemOptionRow;
import nbk.model.commons.NbkGame;

/**
 * Created by Germain on 26/10/2016.
 */
public abstract class NbkItemController extends ItemController<NbkGame> {

  private final NbkRarityChangeListener rarityChangeListener;

  protected NbkItemController(ItemOptionRow<NbkGame> itemOptionRow) {
    super(itemOptionRow);
    rarityChangeListener = new NbkRarityChangeListener(this, itemOptionRow);
  }

  public abstract void updateRarityConstraint(GenericPredicateConstraint<EItemRarity> constraint);

  @Override
  public NbkRarityChangeListener getRarityChangeListener() {
    return rarityChangeListener;
  }
}
