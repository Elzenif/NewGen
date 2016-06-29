package commons.model.entity.items;

import commons.model.entity.enums.EMagic;
import commons.model.entity.enums.ERarity;
import commons.model.entity.game.Game;
import commons.model.entity.utils.fields.HasMagic;
import commons.model.entity.utils.fields.HasQuantity;
import commons.model.entity.utils.fields.HasRarity;
import commons.utils.MathUtils;
import commons.utils.SPositive;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 04/06/2016.
 */
public abstract class Item<T extends Game> implements HasRarity, HasMagic {

  private final ERarity rarity;
  private final SPositive quantity;
  private final EMagic magic;

  protected Item(ItemBuilder builder) {
    rarity = builder.getRarity();
    quantity = builder.getQuantity();
    magic = builder.getMagic();
  }

  private Item() {
    rarity = ERarity.COMMON;
    quantity = SPositive.ONE;
    magic = EMagic.NOPE;
  }

  @Override
  public ERarity getRarity() {
    return rarity;
  }

  protected String printRandomQuantity() {
    int value = quantity.getValue();
    return value == 1
            ? ""
            : "(" + MathUtils.random(value / 2, value) + ") ";
  }

  @Override
  public EMagic getMagic() {
    return magic;
  }

  @Contract(" -> !null")
  public static StubbedItem stubbedItem() {
    return new StubbedItem();
  }


  protected abstract static class ItemBuilder implements HasRarity, HasMagic, HasQuantity {

    protected final ERarity rarity;

    protected ItemBuilder(ERarity rarity) {
      this.rarity = rarity;
    }

    @Override
    public ERarity getRarity() {
      return rarity;
    }

    protected abstract Item build();

  }

  private static class StubbedItem extends Item {

    @Override
    public String toString() {
      return "#####";
    }
  }
}
