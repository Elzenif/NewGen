package commons.view.dice;

import commons.model.dice.EDiceNumber;
import commons.model.dice.results.DiceResult;
import commons.view.utils.ResultRow;

import javax.swing.JLabel;
import java.awt.Font;

/**
 * Created by Germain on 21/05/2016.
 */
public class DiceResultRow extends ResultRow<DiceResult> {

  DiceResultRow(EDiceNumber diceNumber) {
    super(diceNumber.getName());
  }

  @Override
  @SuppressWarnings("MagicConstant")
  protected void makePretty(JLabel resultToPrint, DiceResult result) {
    resultToPrint.setFont(new Font(null, result.getEDiceResultType().getFontStyle(), 12));
    resultToPrint.setForeground(result.getEDiceTestResult().getColor());
  }
}
