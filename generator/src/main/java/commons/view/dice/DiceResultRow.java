package commons.view.dice;

import commons.model.dice.EDiceNumber;
import commons.view.dice.results.AbstractDiceResult;
import commons.view.utils.ResultRow;


/**
 * Created by Germain on 21/05/2016.
 */
public class DiceResultRow extends ResultRow<AbstractDiceResult> {

  DiceResultRow(EDiceNumber diceNumber) {
    super(diceNumber.getName());
  }

}
