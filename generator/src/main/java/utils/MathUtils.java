package utils;

import java.util.List;
import java.util.Random;

/**
 * Created by Germain on 04/06/2016.
 */
public class MathUtils {

  private static Random seed = new Random();

  public static int random(int min, int max) {
    return seed.nextInt(max - min + 1) + min;
  }

  public static <T> T chooseRandom(List<T> list) {
    return list.get(random(0, list.size() - 1));
  }

}
