package commons.model.entity.utils;

import commons.utils.MathUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static commons.utils.MathUtils.findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues;

/**
 * Created by Germain on 22/06/2016.
 */
public class ItemUtils {


  public static <E extends Enum<E> & HasRarity> E selectRandomItemType(E[] values, Predicate<E> predicate) {
    return selectRandomItemType(fillMap(Arrays.asList(values), predicate));
  }

  @SuppressWarnings("Convert2MethodRef")
  private static <E extends Enum<E> & HasRarity> Map<E, Integer> fillMap(List<E> values, Predicate<E> predicate) {
    return values.stream().filter(predicate)
            .collect(Collectors.toMap(Function.identity(), e -> e.getRarity().getProba()));
  }

  private static <E extends Enum<E> & HasRarity> E selectRandomItemType(Map<E, Integer> itemTypes) {
    int probaMax = itemTypes.values().stream().reduce(0, Integer::sum);
    int random = MathUtils.random(1, probaMax);
    return findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues(random, itemTypes);
  }

}
