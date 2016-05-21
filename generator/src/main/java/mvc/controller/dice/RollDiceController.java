package mvc.controller.dice;

import mvc.view.dice.DiceOptionRow;
import mvc.view.dice.DiceResultRow;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 07/05/2016.
 */
public class RollDiceController implements ActionListener, ChangeListener {

  private int diceMax;
  private DiceOptionRow diceOptionRow;
  private DiceResultRow diceResultRow;

  public RollDiceController(int diceMax, DiceOptionRow diceOptionRow, DiceResultRow diceResultRow) {
    this.diceMax = diceMax;
    this.diceOptionRow = diceOptionRow;
    this.diceResultRow = diceResultRow;
  }

  public void actionPerformed(ActionEvent e) {
    String result = "";
    for (int i = 0; i < diceOptionRow.getNumberOfDiceSelected(); i++) {
      result += String.valueOf(rollDice(1, diceMax)) + " ";
    }
    diceResultRow.setResult(result);
  }

  public void stateChanged(ChangeEvent e) {
    diceOptionRow.updateNumberOfDiceOnButton();
  }

  private int rollDice(int min, int max) {
    return (int) (Math.random() * (max - min + 1) + min);
  }

}
