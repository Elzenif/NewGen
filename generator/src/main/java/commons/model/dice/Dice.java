package commons.model.dice;

import commons.utils.MathUtils;
import commons.view.dice.results.EDiceResultType;
import commons.view.dice.results.EDiceTestResult;

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

  private EDiceNumber getDiceMax() {
    return diceMax;
  }

  private int getAddScore() {
    return addScore;
  }

  private DiceTestInfo getDiceTestInfo() {
    return diceTestInfo;
  }

  private int getScore() {
    return score;
  }

  public int getFinalScore() {
    return score + addScore;
  }

  public void roll() {
    score = MathUtils.random(1, diceMax.getDiceNumber());
  }

  public EDiceResultType getDiceResultType() {
    if (score == 1) {
      return EDiceResultType.CRITIC;
    } else if (score == diceMax.getDiceNumber()) {
      return EDiceResultType.FUMBLE;
    } else {
      return EDiceResultType.NORMAL;
    }
  }

  public EDiceTestResult getDiceTestResult() {
    if (diceTestInfo.isTest()) {
      if (diceTestInfo.getOperator().apply(getFinalScore(), diceTestInfo.getValueToTest())) {
        return EDiceTestResult.VALID;
      } else {
        return EDiceTestResult.INVALID;
      }
    } else {
      return EDiceTestResult.NO_TEST;
    }
  }
}
