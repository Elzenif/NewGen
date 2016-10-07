package commons.view.dice;

import commons.model.dice.EDiceNumber;
import commons.view.dice.results.AbstractDiceResult;
import commons.view.utils.Constants;
import commons.view.utils.StringResultRow;


/**
 * Created by Germain on 21/05/2016.
 */
public class DiceResultRow extends StringResultRow<AbstractDiceResult> {

  public DiceResultRow(EDiceNumber diceNumber) {
    super(diceNumber.getName(), false, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP);
  }

}
