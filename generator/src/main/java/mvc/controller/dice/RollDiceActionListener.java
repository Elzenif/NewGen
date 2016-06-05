package mvc.controller.dice;

import mvc.model.dice.results.DiceResult;
import mvc.model.dice.results.enums.EDiceResultType;
import mvc.model.dice.results.enums.EDiceTestResult;
import mvc.view.dice.DiceOptionRow;
import mvc.view.dice.DiceResultRow;
import org.jetbrains.annotations.Contract;
import utils.MathUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 07/05/2016.
 */
public class RollDiceActionListener implements ActionListener {

  private final int diceMax;
  private final DiceOptionRow diceOptionRow;
  private final DiceResultRow diceResultRow;

  public RollDiceActionListener(int diceMax, DiceOptionRow diceOptionRow, DiceResultRow diceResultRow) {
    this.diceMax = diceMax;
    this.diceOptionRow = diceOptionRow;
    this.diceResultRow = diceResultRow;
  }

  public void actionPerformed(ActionEvent e) {
    diceResultRow.clearResults();
    List<DiceResult> results = new LinkedList<>();
    int sum = 0;
    for (int i = 0; i < diceOptionRow.getNumberOfDiceSelected(); i++) {
      int rd = rollDice(diceMax);
      rd += diceOptionRow.getAddScore();
      sum += rd;
      results.add(new DiceResult(String.valueOf(rd) + " ", getDiceResultType(rd), getDiceTestResult(rd)));
    }
    if (diceOptionRow.sumCheckBoxIsSelected()) {
      results.add(new DiceResult("sum = " + sum));
    }
    if (diceOptionRow.meanCheckBoxIsSelected()) {
      double mean = (double) sum / diceOptionRow.getNumberOfDiceSelected();
      results.add(new DiceResult("mean = " + mean));
    }
    diceResultRow.setResultsToPrint(results);
  }

  private int rollDice(int max) {
    return MathUtils.random(1, max);
  }

  @Contract(pure = true)
  private EDiceResultType getDiceResultType(int rd) {
    if (rd == 1) {
      return EDiceResultType.CRITIC;
    } else if (rd == diceMax) {
      return EDiceResultType.FUMBLE;
    } else {
      return EDiceResultType.NORMAL;
    }
  }

  private EDiceTestResult getDiceTestResult(int rd) {
    if (diceOptionRow.isTestCheckBoxSelected()) {
      if (diceOptionRow.getTestComboBoxOperator().apply(rd, diceOptionRow.getTestSpinnerValue())) {
        return EDiceTestResult.VALID;
      } else {
        return EDiceTestResult.INVALID;
      }
    } else {
      return EDiceTestResult.NO_TEST;
    }
  }

}
