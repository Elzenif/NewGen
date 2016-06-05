package mvc.view.dice;

import mvc.model.dice.results.DiceResult;
import mvc.view.commons.ResultRow;

import javax.swing.JLabel;
import java.awt.Font;

/**
 * Created by Germain on 21/05/2016.
 */
public class DiceResultRow extends ResultRow<DiceResult> {

  DiceResultRow(int diceNumber) {
    super("D" + diceNumber);
  }

  @Override
  @SuppressWarnings("MagicConstant")
  protected void makePretty(JLabel resultToPrint, DiceResult result) {
    resultToPrint.setFont(new Font(null, result.getEDiceResultType().getFontStyle(), 13));
    resultToPrint.setForeground(result.getEDiceTestResult().getColor());
  }
}
