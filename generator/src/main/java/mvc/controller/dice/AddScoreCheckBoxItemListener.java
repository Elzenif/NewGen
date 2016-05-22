package mvc.controller.dice;

import mvc.view.dice.DiceOptionRow;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Germain on 22/05/2016.
 */
public class AddScoreCheckBoxItemListener implements ItemListener {

  private DiceOptionRow diceOptionRow;

  public AddScoreCheckBoxItemListener(DiceOptionRow diceOptionRow) {
    this.diceOptionRow = diceOptionRow;
  }

  public void itemStateChanged(ItemEvent e) {
    diceOptionRow.updateAddScoreSpinnerAbility();
    diceOptionRow.updateTextButton();
  }
}
