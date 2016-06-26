package commons.model.entity.utils;

import commons.model.entity.enums.ERarity;
import commons.utils.MathUtils;
import commons.utils.exception.NoAvailableItemTypeException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static commons.utils.MathUtils.findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues;

/**
 * Created by Germain on 22/06/2016.
 */
public class ItemUtils {

  private static final Comparator<HasRarity> BY_RARITY = (i1, i2) -> i1.getRarity().compareTo(i2.getRarity());

  public static <E extends Enum<E> & HasRarity> Stream<E> streamSortedByRarity(E[] values) {
    return Stream.of(values).sorted(BY_RARITY);
  }

  public static <E extends Enum<E> & HasRarity> List<E> listSortedByRarity(E[] values) {
    return Stream.of(values).sorted(BY_RARITY).collect(Collectors.toList());
  }

  public static <E extends Enum<E> & HasRarity> E selectRandomRarity(E[] values)
          throws NoAvailableItemTypeException {
    return selectRandomRarityFromMap(fillMap(Arrays.asList(values).stream()));
  }

  public static <E extends Enum<E> & HasRarity> E selectRandomRarity(E[] values, Predicate<E> predicate)
          throws NoAvailableItemTypeException {
    return selectRandomRarityFromMap(fillMap(Arrays.asList(values).stream(), predicate));
  }

  public static <E extends Enum<E> & HasRarity> E selectRandomRarity(E[] values, ERarity rarity)
          throws NoAvailableItemTypeException {
    return selectRandomRarityFromMap(fillMap(Arrays.asList(values).stream(), rarity));
  }

  public static <E extends Enum<E> & HasRarity> E selectRandomRarity(E[] values, Predicate<E> predicate, ERarity rarity)
          throws NoAvailableItemTypeException {
    return selectRandomRarityFromMap(fillMap(Arrays.asList(values).stream(), predicate, rarity));
  }

  private static <E extends Enum<E> & HasRarity> Map<E, Integer> fillMap(Stream<E> values) {
    return values.collect(Collectors.toMap(Function.identity(), e -> e.getRarity().getProba()));
  }

  private static <E extends Enum<E> & HasRarity> Map<E, Integer> fillMap(Stream<E> values, Predicate<E> predicate) {
    return fillMap(values.filter(predicate));
  }

  private static <E extends Enum<E> & HasRarity> Map<E, Integer> fillMap(Stream<E> values, ERarity rarity) {
    return fillMap(values.filter(e -> e.getRarity() == rarity));
  }

  private static <E extends Enum<E> & HasRarity> Map<E, Integer> fillMap(Stream<E> values, Predicate<E> predicate,
                                                                         ERarity rarity) {
    return fillMap(values.filter(predicate).filter(e -> e.getRarity() == rarity));
  }

  private static <E extends Enum<E> & HasRarity> E selectRandomRarityFromMap(Map<E, Integer> itemTypes)
          throws NoAvailableItemTypeException {
    if (itemTypes.isEmpty()) {
      throw new NoAvailableItemTypeException();
    }
    int probaMax = itemTypes.values().stream().reduce(0, Integer::sum);
    int random = MathUtils.random(1, probaMax);
    return findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues(random, itemTypes);
  }

}
