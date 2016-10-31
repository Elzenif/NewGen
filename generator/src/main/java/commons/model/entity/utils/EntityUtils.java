package commons.model.entity.utils;

import commons.model.entity.characteristics.primary.fields.HasMultipleRarities;
import commons.model.entity.characteristics.primary.fields.HasRarity;
import commons.model.entity.characteristics.primary.fields.IRarityKey;
import commons.utils.MathUtils;
import commons.utils.exception.NoAvailableEntityTypeException;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Germain on 22/06/2016.
 */
public class EntityUtils {

  public static <E extends HasRarity> E selectRandomRarity(E[] values, Predicate<E> predicate)
      throws NoAvailableEntityTypeException {
    return selectRandomRarityFromMap(fillMap(Arrays.stream(values), predicate));
  }

  public static <E extends HasMultipleRarities<K>, K extends IRarityKey>
  E selectRandomWithCustomRarity(E[] values, K key) throws NoAvailableEntityTypeException {
    return selectRandomRarityFromMap(fillMap(Arrays.stream(values), key));
  }

  private static <E extends HasRarity> Map<E, Integer> fillMap(Stream<E> values, Predicate<E> predicate) {
    return values.filter(predicate).collect(Collectors.toMap(Function.identity(), e -> e.getRarity().getProba()));
  }

  private static <E extends HasMultipleRarities<K>, K extends IRarityKey> Map<E, Integer> fillMap(Stream<E> values,
                                                                                                  K key) {
    return values.collect(Collectors.toMap(Function.identity(), e -> e.getRarities().get(key).getRarity().getProba()));
  }

  private static <E> E selectRandomRarityFromMap(Map<E, Integer> itemTypes)
      throws NoAvailableEntityTypeException {
    if (itemTypes.isEmpty()) {
      throw new NoAvailableEntityTypeException();
    }
    int probaMax = itemTypes.values().stream().reduce(0, Integer::sum);
    int random = MathUtils.random(1, probaMax);
    return MathUtils.findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues(random, itemTypes);
  }
}
