package mvc.controller.dice;

import mvc.view.dice.DiceOptionRow;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Germain on 28/05/2016.
 */
public class TestCheckBoxListener implements ItemListener {

  private final DiceOptionRow diceOptionRow;

  public TestCheckBoxListener(DiceOptionRow diceOptionRow) {
    this.diceOptionRow = diceOptionRow;
  }

  public void itemStateChanged(ItemEvent e) {
    diceOptionRow.updateTestSpinnerAndComboBoxAbility();
  }
}
