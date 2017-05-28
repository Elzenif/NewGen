package generator.utils;

import commons.model.dice.Dice;
import commons.utils.MathUtils;
import commons.utils.Pair;
import commons.utils.exception.NoAvailableEntityTypeException;
import generator.model.entity.DDRandomEntity;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Germain on 27/05/2017.
 */
public class GeneratorUtils {

  public static <T extends DDRandomEntity> List<T> findAll(List<T> randomEntities) throws NoAvailableEntityTypeException {
    int random = MathUtils.random(1, 100);
    return MathUtils.findAllElementsAcceptingThePredicate(randomEntities,
        e -> e.getPrcMin() <= random && e.getPrcMax() >= random);
  }

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
    List<Integer> integers = Arrays.stream(split[0].split("d"))
        .map(Integer::valueOf)
        .collect(Collectors.toList());
    if (split[0].contains("d") && integers.size() != 2) {
      String s = String.format("String %s is not parsed correctly. Split: %s", split[0],  integers);
      throw new IllegalArgumentException(s);
    }
    int score;
    if (integers.size() == 1) {
      score = integers.get(0);
    } else if (integers.size() == 2) {
      Dice dice = new Dice(integers.get(0), integers.get(1));
      score = dice.rollAndGetScore();
    } else {
      String s = String.format("String %s is not parsed correctly. Split: %s", split[0],  integers);
      throw new IllegalArgumentException(s);
    }
    return new Pair<>(score, split[1]);
  }
}
