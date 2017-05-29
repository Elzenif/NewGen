package commons.model.dice;

import commons.utils.MathUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Germain on 25/06/2016.
 */
public class Dice {

  public static final List<Integer> values = Arrays.asList(4, 6, 8, 10, 12, 20, 100);
  public static final String REGEXP = "((\\d)+d(\\d)+)";
  private final int diceNumber;
  private final int addScore;
  private final DiceTestInfo diceTestInfo;
  private final int iterations;
  private int score;

  public Dice(int diceNumber, int addScore, DiceTestInfo diceTestInfo) {
    this.diceNumber = diceNumber;
    this.addScore = addScore;
    this.diceTestInfo = diceTestInfo;
    iterations = 1;
  }

  public Dice(Dice copy) {
    this.diceNumber = copy.getDiceNumber();
    this.addScore = copy.getAddScore();
    this.diceTestInfo = copy.getDiceTestInfo();
    this.score = copy.getScore();
    this.iterations = copy.getIterations();
  }

  public Dice(int diceNumber) {
    this.diceNumber = diceNumber;
    this.addScore = 0;
    this.diceTestInfo = null;
    this.iterations = 1;
  }

  public Dice(int iterations, int diceNumber) {
    this.diceNumber = diceNumber;
    this.addScore = 0;
    this.diceTestInfo = null;
    this.iterations = iterations;
  }

  public int getDiceNumber() {
    return diceNumber;
  }

  @Contract(pure = true)
  private int getAddScore() {
    return addScore;
  }

  @Contract(pure = true)
  private DiceTestInfo getDiceTestInfo() {
    return diceTestInfo;
  }

  public int getScore() {
    return score;
  }

  public int getFinalScore() {
    return score + addScore;
  }

  public void roll() {
    for (int i = 0; i < iterations; i++) {
      score += MathUtils.random(1, diceNumber);
    }
  }

  public int rollAndGetScore() {
    roll();
    return getFinalScore();
  }

  public boolean isTest() {
    return diceTestInfo.isTest();
  }

  public boolean isTestValid() {
    return diceTestInfo.getOperator().apply(getFinalScore(), diceTestInfo.getValueToTest());
  }

  @Contract(pure = true)
  private int getIterations() {
    return iterations;
  }

  public void resetScore() {
    score = 0;
  }

  @NotNull
  public static Dice getDiceFromString(String diceString) {
    List<Integer> integers = Arrays.stream(diceString.split("d"))
        .map(Integer::valueOf)
        .collect(Collectors.toList());
    if (integers.size() != 2) {
      String message = String.format("Wrong input %s", diceString);
      throw new IllegalArgumentException(message);
    }
    return new Dice(integers.get(0), integers.get(1));
  }

  public static Optional<Integer> getRollFromString(String s) {
    if (s.matches("(\\d)+")) {
      return Optional.of(Integer.valueOf(s));
    }
    Pattern pattern = Pattern.compile(Dice.REGEXP);
    Matcher matcher = pattern.matcher(s);
    if (matcher.find()) {
      String diceString = matcher.group(1);
      Dice dice = Dice.getDiceFromString(diceString);
      return Optional.of(dice.rollAndGetScore());
    } else {
      return Optional.empty();
    }
  }
}
