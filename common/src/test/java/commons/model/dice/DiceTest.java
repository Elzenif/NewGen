package commons.model.dice;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 23/07/2016.
 */
public class DiceTest {

  private Dice dice;

  @Test
  public void testFinalScoreEqualsScoreIfAddScoreIs0() {
    for (Integer diceNumber : Dice.values) {
      dice = new Dice(diceNumber);
      dice.roll();
      int finalScore = dice.getFinalScore();
      int score = dice.getScore();

      assertThat(finalScore).isEqualTo(score);
    }
  }

  @Test
  public void testDiceRollIsInRange() {
    for (Integer diceNumber : Dice.values) {
      dice = new Dice(diceNumber);
      dice.roll();
      int result = dice.getFinalScore();

      assertThat(result).isBetween(1, diceNumber);
    }
  }

  @Test
  public void testDiceRollIsInRangeWithIterations() {
    int iterations = 5;
    for (Integer diceNumber : Dice.values) {
      dice = new Dice(iterations, diceNumber);
      dice.roll();
      int result = dice.getFinalScore();

      assertThat(result).isBetween(iterations, iterations * diceNumber);
    }
  }

  @Test
  public void getRollFromString1() {
    Integer result = Dice.getRollFromString("2d1").orElse(1);
    assertThat(result).isEqualTo(2);
  }

  @Test
  public void getRollFromString2() {
    Integer result = Dice.getRollFromString("2d1+3").orElse(1);
    assertThat(result).isEqualTo(5);
  }
}
