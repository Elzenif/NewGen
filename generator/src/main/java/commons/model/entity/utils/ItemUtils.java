package commons.model.entity.utils;

import commons.model.entity.characteristics.primary.fields.HasRarity;
import commons.utils.MathUtils;
import commons.utils.exception.NoAvailableItemTypeException;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Germain on 22/06/2016.
 */
public class ItemUtils {

  public static <E extends Enum<E> & HasRarity> E selectRandomRarity(E[] values, Predicate<E> predicate)
          throws NoAvailableItemTypeException {
    return selectRandomRarityFromMap(fillMap(Arrays.stream(values), predicate));
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
    return MathUtils.findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues(random, itemTypes);
  }

}
