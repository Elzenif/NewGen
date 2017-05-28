package commons.utils;

import commons.model.utils.HasName;

import java.util.Collection;
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

  public static int nextPositiveGaussian(int deviation, int mean) {
    return Math.abs((int) seed.nextGaussian() * deviation + mean);
  }

  public static boolean nextBoolean() {
    return seed.nextBoolean();
  }

  public static <E extends HasName<String>> int maxLength(Collection<E> namedEnumValues) {
    Optional<Integer> max = namedEnumValues.stream().map(e -> e.getName().length()).reduce(Integer::max);
    if (max.isPresent())
      return max.get();
    else
      throw new NoSuchElementException("Cannot find max value");
  }

  /**
   * Find the first key of map such as ref is lower than the sum of precedent values, i.e.<br>
   * 0 <= i <= map.size()-1<br>
   * if (ref <= map.first())<br>
   *    i = 0<br>
   * else<br>
   *    ref > sum(0,i-1)(map)<br>
   *    ref <= sum(0,i)(map)<br>
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

  public static int roundM(int n, int m) {
    return (int) (Math.floor((n + m - 1) / m) * m);
  }

  public static Pair<Integer, Integer> getRandomPointInCircle(int radius, int tileSize) {
    double t = 2 * Math.PI * Math.random();
    double u = Math.random() + Math.random();
    double r = (u > 1) ? 2 - u : u;
    return new Pair<>(
        roundM((int) (radius * r * Math.cos(t)), tileSize),
        roundM((int) (radius * r * Math.sin(t)), tileSize));
  }

  public static double mean(int x, int y) {
    return Math.sqrt(x * x + y * y);
  }

  public static int floor(double x) {
    return (int) Math.floor(x);
  }

}
