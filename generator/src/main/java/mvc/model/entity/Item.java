package mvc.model.entity;

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

/**
 * Created by Germain on 04/06/2016.
 */
public abstract class Item implements HasRarity {

  protected ERarity rarity;

  @Override
  public ERarity getRarity() {
    return rarity;
  }

  abstract static class ItemBuilder {

    protected final List<HasRarity> rarities = new ArrayList<>();

    ERarity computeRarity() {
      return ERarity.computeRarity(rarities);
    }

    <E extends Enum<E> & ItemType> E selectRandomItemType(E[] values, Predicate<E> predicate) {
      return selectRandomItemType(fillMap(Arrays.asList(values), predicate));
    }

    @SuppressWarnings("Convert2MethodRef")
    private <E extends Enum<E> & ItemType> Map<E, Integer> fillMap(List<E> values, Predicate<E> predicate) {
      return values.stream().filter(predicate)
              .collect(Collectors.toMap(Function.identity(), e -> e.getRarity().getProba()));
    }

    @Nullable
    private <E extends Enum<E> & ItemType> E selectRandomItemType(Map<E, Integer> itemTypes) {
      int probaMax = itemTypes.values().stream().reduce(0, Integer::sum);
      int random = MathUtils.random(1, probaMax);
      for (Map.Entry<E, Integer> pair : itemTypes.entrySet()) {
        int proba = pair.getValue();
        if (random <= proba) {
          return pair.getKey();
        } else {
          random -= proba;
        }
      }
      return null;
    }

  }
}