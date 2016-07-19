package commons.view.dice.results;

import commons.model.dice.Dice;

import java.awt.Color;

/**
 * Created by Germain on 28/05/2016.
 */
public class DiceResult implements AbstractDiceResult {

  private final Dice dice;
  private EDiceResultType diceResultType;
  private EDiceTestResult diceTestResult;

  public DiceResult(Dice dice) {
    this.dice = dice;
    setDiceResultType();
    setDiceTestResult();
  }

  @Override
  public String getRawResult() {
    return String.valueOf(dice.getFinalScore());
  }

  @Override
  public int getFontStyle() {
    return diceResultType.getFontStyle();
  }

  @Override
  public Color getColor() {
    return diceTestResult.getColor();
  }

  private void setDiceResultType() {
    if (dice.getScore() == 1) {
      diceResultType = EDiceResultType.CRITIC;
    } else if (dice.getScore() == dice.getDiceMax().getDiceNumber()) {
      diceResultType = EDiceResultType.FUMBLE;
    } else {
      diceResultType = EDiceResultType.NORMAL;
    }
  }

  private void setDiceTestResult() {
    if (dice.isTest()) {
      if (dice.isTestValid()) {
        diceTestResult = EDiceTestResult.VALID;
      } else {
        diceTestResult = EDiceTestResult.INVALID;
      }
    } else {
      diceTestResult = EDiceTestResult.NO_TEST;
    }

  }
}
