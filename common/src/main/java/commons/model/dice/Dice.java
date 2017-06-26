package commons.model.dice;

import commons.utils.MathUtils;
import org.jetbrains.annotations.Contract;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Germain on 25/06/2016.
 */
public class Dice {

  public static final List<Integer> values = Arrays.asList(4, 6, 8, 10, 12, 20, 100);
  public static final String REGEXP = "(\\d+)d(\\d+)(\\+\\d+)*";
  private final int iterations;
  private final int diceNumber;
  private final int addScore;
  private final DiceTestInfo diceTestInfo;
  private int score;

  public Dice(int iterations, int diceNumber, int addScore, DiceTestInfo diceTestInfo) {
    this.iterations = iterations;
    this.diceNumber = diceNumber;
    this.addScore = addScore;
    this.diceTestInfo = diceTestInfo;
  }

  public Dice(int diceNumber, int addScore, DiceTestInfo diceTestInfo) {
    this(1, diceNumber, addScore, diceTestInfo);
  }

  public Dice(int diceNumber) {
    this(1, diceNumber, 0, null);
  }

  public Dice(int iterations, int diceNumber) {
    this(iterations, diceNumber, 0, null);
  }

  public Dice(int iterations, int diceNumber, int addScore) {
    this(iterations, diceNumber, addScore, null);
  }

  public Dice(Dice copy) {
    this.diceNumber = copy.getDiceNumber();
    this.addScore = copy.getAddScore();
    this.diceTestInfo = copy.getDiceTestInfo();
    this.score = copy.getScore();
    this.iterations = copy.getIterations();
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

  public static Optional<Integer> getRollFromString(String s) {
    if (s.matches("(\\d)+")) {
      return Optional.of(Integer.valueOf(s));
    }
    Pattern pattern = Pattern.compile(Dice.REGEXP);
    Matcher matcher = pattern.matcher(s);
    if (matcher.find()) {
      int iterations = Integer.parseInt(matcher.group(1));
      int diceNumber = Integer.parseInt(matcher.group(2));
      int addScore = matcher.group(3) == null ? 0 : Integer.parseInt(matcher.group(3));
      Dice dice = new Dice(iterations, diceNumber, addScore);
      return Optional.of(dice.rollAndGetScore());
    } else {
      return Optional.empty();
    }
  }
}
