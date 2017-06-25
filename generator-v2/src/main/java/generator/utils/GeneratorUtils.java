package generator.utils;

import commons.model.dice.Dice;
import commons.utils.Pair;
import generator.model.entity.ProprieteSpeciale;
import generator.model.entity.ProprieteSpecialePrix;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Germain on 27/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
public class GeneratorUtils {

  /**
   * Get the multiplier from the detail string.
   *
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

  public static int getTotalBonus(List<? extends ProprieteSpeciale> proprieteSpeciales) {
    return proprieteSpeciales.stream()
        .filter(p -> p.getModificateur() != null)
        .mapToInt(ProprieteSpeciale::getModificateur)
        .sum();
  }

  public static int getTotalPrix(List<? extends ProprieteSpecialePrix> proprieteSpeciales) {
    return proprieteSpeciales.stream()
        .filter(p -> p.getModificateurPrix() != null)
        .mapToInt(ProprieteSpecialePrix::getModificateurPrix)
        .sum();
  }

  @NotNull
  public static String getProprietes(List<? extends ProprieteSpeciale> proprieteSpeciales) {
    return " " + proprieteSpeciales.stream()
        .map(ProprieteSpeciale::getNom)
        .collect(Collectors.joining(", "));
  }
}
