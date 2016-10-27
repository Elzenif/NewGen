package commons.controller.dice;

import commons.model.dice.Dice;
import commons.model.dice.DiceTestInfo;
import commons.utils.StringUtils;
import commons.view.dice.DiceOptionRow;
import commons.view.dice.DiceResultRow;
import commons.view.dice.results.AbstractDiceResult;
import commons.view.dice.results.AdditionalDiceResult;
import commons.view.dice.results.DiceResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 07/05/2016.
 */
public class RollDiceActionListener implements ActionListener {

  private final int diceNumber;
  private final DiceOptionRow diceOptionRow;
  private final DiceResultRow diceResultRow;

  public RollDiceActionListener(int diceNumber, DiceOptionRow diceOptionRow, DiceResultRow diceResultRow) {
    this.diceNumber = diceNumber;
    this.diceOptionRow = diceOptionRow;
    this.diceResultRow = diceResultRow;
  }

  public void actionPerformed(ActionEvent e) {
    diceResultRow.clearResults();
    List<AbstractDiceResult> results = new LinkedList<>();
    int sum = 0;
    DiceTestInfo diceTestInfo = new DiceTestInfo(diceOptionRow.isTestCheckBoxSelected(),
            diceOptionRow.getTestComboBoxOperator(),
            diceOptionRow.getTestSpinnerValue());
    Dice dice = new Dice(diceNumber, diceOptionRow.getAddScore(), diceTestInfo);
    for (int i = 0; i < diceOptionRow.getNumberOfDiceSelected(); i++) {
      dice.roll();
      sum += dice.getFinalScore();
      results.add(new DiceResult(new Dice(dice)));
    }
    if (diceOptionRow.sumCheckBoxIsSelected()) {
      results.add(new AdditionalDiceResult(resourceBundle.getString("row.dice.sum") + " = " + sum));
    }
    if (diceOptionRow.meanCheckBoxIsSelected()) {
      double mean = (double) sum / diceOptionRow.getNumberOfDiceSelected();
      results.add(new AdditionalDiceResult(resourceBundle.getString("row.dice.mean") + " = " + StringUtils.format(mean)));
    }
    diceResultRow.setResultsToPrint(results);
  }

}
