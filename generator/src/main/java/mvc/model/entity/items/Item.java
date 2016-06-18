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

  ERarity rarity;

  @Override
  public ERarity getRarity() {
    return rarity;
  }

  abstract static class ItemBuilder {

    final List<HasRarity> rarities = new ArrayList<>();

    ERarity computeRarity() {
      return rarities.isEmpty() ? ERarity.COMMON : ERarity.computeRarity(rarities);
    }

    <E extends Enum<E> & ItemType> E selectRandomItemType(E[] values, Predicate<E> predicate) {
      return selectRandomItemType(fillMap(Arrays.asList(values), predicate));
    }

    @SuppressWarnings("Convert2MethodRef")
    private <E extends Enum<E> & ItemType> Map<E, Integer> fillMap(List<E> values, Predicate<E> predicate) {
      return values.stream().filter(predicate)
              .collect(Collectors.toMap(Function.identity(), e -> e.getRarity().getProba()));
    }

    private <E extends Enum<E> & ItemType> E selectRandomItemType(Map<E, Integer> itemTypes) {
      int probaMax = itemTypes.values().stream().reduce(0, Integer::sum);
      int random = MathUtils.random(1, probaMax);
      return findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues(random, itemTypes);
    }
  }
}
