package mvc.view.dice;

import mvc.model.dice.DiceResult;
import mvc.view.commons.PanelRow;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 21/05/2016.
 */
public class DiceResultRow extends PanelRow {

  private int diceNumber;

  private JLabel infoLabel;
  private final List<JLabel> resultDices;

  DiceResultRow(int diceNumber) {
    super();
    this.diceNumber = diceNumber;
    resultDices = new LinkedList<>();
    setComponents();
  }

  private void setComponents() {
    infoLabel = new JLabel("D" + diceNumber + " : ");
    infoLabel.setFont(new Font(null, Font.BOLD, 13));
    add(infoLabel);
  }

  public void clearResults() {
    resultDices.forEach(this::remove);
    resultDices.clear();
  }

  @SuppressWarnings("MagicConstant")
  public void setResults(List<DiceResult> results) {
    for (DiceResult result : results) {
      JLabel resultDice = new JLabel(result.getResult());
      resultDice.setFont(new Font(null, result.getEDiceResultType().getFontStyle(), 13));
      resultDice.setForeground(result.getEDiceTestResult().getColor());
      resultDices.add(resultDice);
      add(resultDice);
    }
    repaint();
    revalidate();
  }
}
