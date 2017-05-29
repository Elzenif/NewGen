package generator.utils;

import commons.model.dice.Dice;
import commons.utils.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Germain on 27/05/2017.
 */
public class GeneratorUtils {

  /**
   * Get the multiplier from the detail string.
   * @param detail must follow the pattern (.*)x(.*).
   *               The part before the 'x' must be an integer or a dice value
   * @return the integer or the dice rolled and the right side of the
   */
  @NotNull
  public static Pair<Integer, String> getMultiplier(String detail) {
    String[] split = detail.split("x", 2);
    if (split.length != 2) {
      String s = String.format("String %s is not parsed correctly. Split: %s", detail, Arrays.toString(split));
      throw new IllegalArgumentException(s);
    }
    Optional<Integer> roll = Dice.getRollFromString(split[0]);
    if (!roll.isPresent()) {
      String message = String.format("String %s is not parsed correctly", split[0]);
      throw new IllegalArgumentException(message);
    }
    return new Pair<>(roll.get(), split[1]);
  }
}
