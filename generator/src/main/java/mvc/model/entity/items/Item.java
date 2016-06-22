package mvc.model.entity.items;

import mvc.model.entity.game.Game;
import mvc.model.entity.utils.ERarity;
import mvc.model.entity.utils.HasRarity;
import mvc.model.entity.utils.ItemType;
import org.jetbrains.annotations.Nullable;
import utils.MathUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static utils.MathUtils.findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues;

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

  }
}
