package commons.model.entity.items;

import commons.model.entity.game.Game;
import commons.model.entity.utils.ERarity;
import commons.model.entity.utils.HasRarity;
import commons.utils.MathUtils;

/**
 * Created by Germain on 04/06/2016.
 */
public abstract class Item<T extends Game> implements HasRarity {

  private final ERarity rarity;
  private final int quantity;

  protected Item(ItemBuilder builder) {
    this.rarity = builder.getRarity();
    this.quantity = builder.getQuantity();
  }

  @Override
  public ERarity getRarity() {
    return rarity;
  }

  protected String printRandomQuantity() {
    return (quantity == 1) ? "" : "(" + MathUtils.random(quantity / 2, quantity) + ") ";
  }


  protected abstract static class ItemBuilder {

    protected final ERarity rarity;

    protected ItemBuilder(ERarity rarity) {
      this.rarity = rarity;
    }

    public ERarity getRarity() {
      return rarity;
    }

    public abstract int getQuantity();

    protected abstract Item build();
  }
}
