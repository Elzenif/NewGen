package commons.model.entity.items;

import commons.model.entity.game.Game;
import commons.model.entity.utils.ERarity;
import commons.model.entity.utils.HasRarity;

/**
 * Created by Germain on 04/06/2016.
 */
public abstract class Item<T extends Game> implements HasRarity {

  protected final ERarity rarity;

  protected Item(ERarity rarity) {
    this.rarity = rarity;
  }

  @Override
  public ERarity getRarity() {
    return rarity;
  }

  protected abstract static class ItemBuilder {

    protected final ERarity rarity;

    protected ItemBuilder(ERarity rarity) {
      this.rarity = rarity;
    }

    public ERarity getRarity() {
      return rarity;
    }
  }
}
