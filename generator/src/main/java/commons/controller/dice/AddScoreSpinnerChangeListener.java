package commons.controller.dice;

import commons.view.dice.DiceOptionRow;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Germain on 22/05/2016.
 */
public class AddScoreSpinnerChangeListener implements ChangeListener {

  private final DiceOptionRow diceOptionRow;

  public AddScoreSpinnerChangeListener(DiceOptionRow diceOptionRow) {
    this.diceOptionRow = diceOptionRow;
  }

  public void stateChanged(ChangeEvent e) {
    diceOptionRow.updateTextButton();
  }
}
