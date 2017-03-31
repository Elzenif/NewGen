package commons.view.dice;

import commons.Constants;
import commons.model.dice.EDiceNumber;
import commons.view.commons.results.StringResultRow;
import commons.view.dice.results.AbstractDiceResult;


/**
 * Created by Germain on 21/05/2016.
 */
public class DiceResultRow extends StringResultRow<AbstractDiceResult> {

  public DiceResultRow(EDiceNumber diceNumber) {
    super(diceNumber.getName(), false, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP);
  }

}
