package commons.model.entity.items;

import commons.model.commons.Game;
import commons.model.entity.Entity;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.characteristics.primary.enums.EMagic;
import commons.model.entity.characteristics.primary.fields.HasMagic;
import commons.model.entity.characteristics.primary.fields.HasQuantity;
import commons.utils.MathUtils;
import commons.utils.SPositive;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 04/06/2016.
 */
public abstract class Item<T extends Game> extends Entity implements HasMagic {

  private final SPositive quantity;
  private final EMagic magic;

  protected Item(ItemBuilder builder) {
    super(builder);
    quantity = builder.getQuantity();
    magic = builder.getMagic();
  }

  private Item() {
    super();
    quantity = SPositive.ONE;
    magic = EMagic.NOPE;
  }

  @Contract(" -> !null")
  public static StubbedItem stubbedItem() {
    return new StubbedItem();
  }

  @Override
  public EItemRarity getRarity() {
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

  protected abstract static class ItemBuilder extends EntityBuilder implements HasMagic, HasQuantity {
  }

  private static class StubbedItem extends Item {

    @Override
    public String toString() {
      return "#####";
    }
  }
}
