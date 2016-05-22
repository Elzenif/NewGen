package mvc.controller.dice;

import mvc.model.dice.EDiceResultType;
import mvc.view.dice.DiceOptionRow;
import mvc.view.dice.DiceResultRow;
import utils.Pair;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 07/05/2016.
 */
public class RollDiceActionListener implements ActionListener {

  private int diceMax;
  private DiceOptionRow diceOptionRow;
  private DiceResultRow diceResultRow;

  public RollDiceActionListener(int diceMax, DiceOptionRow diceOptionRow, DiceResultRow diceResultRow) {
    this.diceMax = diceMax;
    this.diceOptionRow = diceOptionRow;
    this.diceResultRow = diceResultRow;
  }

  public void actionPerformed(ActionEvent e) {
    diceResultRow.clearResults();
    List<Pair<String, EDiceResultType>> results = new LinkedList<Pair<String, EDiceResultType>>();
    int sum = 0;
    for (int i = 0; i < diceOptionRow.getNumberOfDiceSelected(); i++) {
      int rd = rollDice(1, diceMax);
      EDiceResultType drt;
      if (rd == 1) {
        drt = EDiceResultType.CRITIC;
      } else if (rd == diceMax) {
        drt = EDiceResultType.FUMBLE;
      } else {
        drt = EDiceResultType.NORMAL;
      }
      rd += diceOptionRow.getAddScore();
      sum += rd;
      results.add(new Pair<String, EDiceResultType>(String.valueOf(rd) + " ", drt));
    }
    if (diceOptionRow.sumCheckBoxIsSelected()) {
      results.add(new Pair<String, EDiceResultType>("sum = " + sum, EDiceResultType.NORMAL));
    }
    diceResultRow.setResults(results);
  }

  private int rollDice(int min, int max) {
    return (int) (Math.random() * (max - min + 1) + min);
  }

}
