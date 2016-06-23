package commons.utils;

import commons.model.commons.HasName;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

/**
 * Created by Germain on 04/06/2016.
 */
public class MathUtils {

  private static final Random seed = new Random();

  public static int random(int min, int max) {
    return seed.nextInt(max - min + 1) + min;
  }

  public static <T> T chooseRandom(List<T> list) {
    return list.get(random(0, list.size() - 1));
  }

  public static <E extends HasName<String>> int maxLength(List<E> namedEnumValues) {
    Optional<Integer> max = namedEnumValues.stream().map(e -> e.getName().length()).reduce(Integer::max);
    if (max.isPresent())
      return max.get();
    else
      throw new NoSuchElementException("Cannot find max value");
  }

  /**
   * Find the first key of map such as ref is lower than the sum of precedent values, i.e.
   * 0 <= i <= map.size()-1
   * if (ref <= map.first())
   *    i = 0
   * else
   *    ref > sum(0,i-1)(map)
   *    ref <= sum(0,i)(map)
   * @param ref the integer used to compare
   * @param map the map of values
   * @return key in the i_th position with i that satisfies the constraints
   */
  public static <T> T findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues(int ref, Map<T, Integer> map) {
    int sum = 0;
    for (Map.Entry<T, Integer> entry : map.entrySet()) {
      sum += entry.getValue();
      if (ref <= sum) {
        return entry.getKey();
      }
    }
    throw new IllegalArgumentException("ref " + ref + " is greater than the sum of map values");
  }
}
