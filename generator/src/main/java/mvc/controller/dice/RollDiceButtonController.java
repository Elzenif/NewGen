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
public class RollDiceButtonController implements ActionListener, ChangeListener {

  private DiceOptionRow diceOptionRow;
  private DiceResultRow diceResultRow;

  public RollDiceButtonController(DiceOptionRow diceOptionRow, DiceResultRow diceResultRow) {
    this.diceOptionRow = diceOptionRow;
    this.diceResultRow = diceResultRow;
  }

  public void actionPerformed(ActionEvent e) {
    String result = "";
    for (int i = 0; i < diceOptionRow.getNumberOfDiceSelected(); i++) {
      result += String.valueOf(rollDice6()) + " ";
    }
    diceResultRow.setResult(result);
  }

  public void stateChanged(ChangeEvent e) {
    diceOptionRow.updateNumberOfDiceOnButton();
  }

  private int rollDice6() {
    return rollDice(1, 6);
  }

  private int rollDice(int min, int max) {
    return (int) (Math.random() * (max - min + 1) + min);
  }

}
