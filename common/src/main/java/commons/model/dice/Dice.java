package commons.model.dice;

import commons.utils.MathUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Germain on 25/06/2016.
 */
public class Dice {

  public static final List<Integer> values = Arrays.asList(4, 6, 8, 10, 12, 20, 100);
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

  private int getAddScore() {
    return addScore;
  }

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

  private int getIterations() {
    return iterations;
  }

  public void resetScore() {
    score = 0;
  }
}
