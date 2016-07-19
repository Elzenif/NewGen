package commons.model.dice;

import commons.utils.MathUtils;

/**
 * Created by Germain on 25/06/2016.
 */
public class Dice {

  private final EDiceNumber diceMax;
  private final int addScore;
  private final DiceTestInfo diceTestInfo;
  private int score;

  public Dice(EDiceNumber diceMax, int addScore, DiceTestInfo diceTestInfo) {
    this.diceMax = diceMax;
    this.addScore = addScore;
    this.diceTestInfo = diceTestInfo;
  }

  public Dice(Dice copy) {
    this.diceMax = copy.getDiceMax();
    this.addScore = copy.getAddScore();
    this.diceTestInfo = copy.getDiceTestInfo();
    this.score = copy.getScore();
  }

  public EDiceNumber getDiceMax() {
    return diceMax;
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
    score = MathUtils.random(1, diceMax.getDiceNumber());
  }

  public boolean isTest() {
    return diceTestInfo.isTest();
  }

  public boolean isTestValid() {
    return diceTestInfo.getOperator().apply(getFinalScore(), diceTestInfo.getValueToTest());
  }
}
