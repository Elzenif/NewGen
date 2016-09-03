package commons.model.dice;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 23/07/2016.
 */
public class DiceTest {

  private Dice dice;
  private DiceTestInfo diceTestInfo;

  @Test
  public void testFinalScoreEqualsScoreIfAddScoreIs0() {
    diceTestInfo = new DiceTestInfo(false, null, 0);
    for (EDiceNumber diceNumber : EDiceNumber.values()) {
      dice = new Dice(diceNumber, 0, diceTestInfo);
      dice.roll();
      int finalScore = dice.getFinalScore();
      int score = dice.getScore();

      assertThat(finalScore).isEqualTo(score);
    }
  }

  @Test
  public void testDiceRollIsInRange() {
    diceTestInfo = new DiceTestInfo(false, null, 0);
    for (EDiceNumber diceNumber : EDiceNumber.values()) {
      dice = new Dice(diceNumber, 0, diceTestInfo);
      dice.roll();
      int result = dice.getFinalScore();

      assertThat(1 <= result && result <= diceNumber.getDiceNumber()).isTrue();
    }
  }
}
