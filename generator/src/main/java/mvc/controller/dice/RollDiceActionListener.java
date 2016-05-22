package mvc.controller.dice;

import mvc.view.dice.DiceOptionRow;
import mvc.view.dice.DiceResultRow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    String result = "";
    int sum = 0;
    for (int i = 0; i < diceOptionRow.getNumberOfDiceSelected(); i++) {
      int rd = rollDice(1, diceMax) + diceOptionRow.getAddScore();
      sum += rd;
      result += String.valueOf(rd) + " ";
    }
    if (diceOptionRow.sumCheckBoxIsSelected()) {
      result += "sum = " + sum;
    }
    diceResultRow.setResult(result);
  }

  private int rollDice(int min, int max) {
    return (int) (Math.random() * (max - min + 1) + min);
  }

}
