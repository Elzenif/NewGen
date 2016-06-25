package commons.model.dice.results;

import commons.model.dice.Dice;

import java.awt.Color;

/**
 * Created by Germain on 28/05/2016.
 */
public class DiceResult implements AbstractDiceResult {

  private final Dice dice;

  public DiceResult(Dice dice) {
    this.dice = dice;
  }

  @Override
  public String getRawResult() {
    return String.valueOf(dice.getFinalScore());
  }

  @Override
  public int getFontStyle() {
    return dice.getDiceResultType().getFontStyle();
  }

  @Override
  public Color getColor() {
    return dice.getDiceTestResult().getColor();
  }

}
