package commons.model.entity.utils;

import commons.utils.MathUtils;
import commons.utils.exception.NoAvailableItemTypeException;

import java.util.Arrays;
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


  public static <E extends Enum<E> & HasRarity> E selectRandomRarity(E[] values, Predicate<E> predicate)
          throws NoAvailableItemTypeException {
    return selectRandomRarityFromMap(fillMap(Arrays.asList(values).stream(), predicate));
  }

  public static <E extends Enum<E> & HasRarity> E selectRandomRarity(List<E> values, Predicate<E> predicate)
          throws NoAvailableItemTypeException {
    return selectRandomRarityFromMap(fillMap(values.stream(), predicate));
  }

  public static <E extends Enum<E> & HasRarity> E selectRandomRarity(Stream<E> values, Predicate<E> predicate)
          throws NoAvailableItemTypeException {
    return selectRandomRarityFromMap(fillMap(values, predicate));
  }

  public static <E extends Enum<E> & HasRarity> E selectRandomRarity(E[] values)
          throws NoAvailableItemTypeException {
    return selectRandomRarityFromMap(fillMap(Arrays.asList(values).stream(), p -> true));
  }

  public static <E extends Enum<E> & HasRarity> E selectRandomRarity(List<E> values)
          throws NoAvailableItemTypeException {
    return selectRandomRarityFromMap(fillMap(values.stream(), p -> true));
  }

  public static <E extends Enum<E> & HasRarity> E selectRandomRarity(Stream<E> values)
          throws NoAvailableItemTypeException {
    return selectRandomRarityFromMap(fillMap(values, p -> true));
  }

  private static <E extends Enum<E> & HasRarity> Map<E, Integer> fillMap(Stream<E> values, Predicate<E> predicate) {
    return values.filter(predicate).collect(Collectors.toMap(Function.identity(), e -> e.getRarity().getProba()));
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
