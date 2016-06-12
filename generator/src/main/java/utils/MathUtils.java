package utils;

import mvc.model.commons.HasName;

import java.util.List;
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

  public static <E extends HasName> int maxLength(List<E> namedEnumValues) {
    Optional<Integer> max = namedEnumValues.stream().map(e -> e.getName().length()).reduce(Integer::max);
    if (max.isPresent())
      return max.get();
    else
      throw new NoSuchElementException("Cannot find max value");
  }
}
