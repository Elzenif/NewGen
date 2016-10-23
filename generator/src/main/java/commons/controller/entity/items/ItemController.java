package commons.controller.entity.items;

import commons.controller.entity.EntityController;
import commons.model.commons.Game;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.model.entity.constraints.GlobalConstraints;
import commons.view.entity.items.ItemOptionRow;

/**
 * Created by Germain on 23/10/2016.
 */
public abstract class ItemController<G extends Game> extends EntityController<G, GlobalConstraints> {

  private final RarityChangeListener<G> rarityChangeListener;

  protected ItemController(ItemOptionRow<G> itemOptionRow) {
    super(itemOptionRow, new GlobalConstraints());
    this.rarityChangeListener = new RarityChangeListener<>(this, itemOptionRow);
  }

  public RarityChangeListener<G> getRarityChangeListener() {
    return rarityChangeListener;
  }

  public abstract void updateRarityConstraint(GenericConstraint<EItemRarity> constraint);
}
