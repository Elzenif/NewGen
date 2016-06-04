package mvc.view.dice;

import mvc.model.dice.DiceResult;
import mvc.view.commons.Constants;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 21/05/2016.
 */
public class DiceResultRow extends JPanel {

  private int diceNumber;

  private JLabel infoLabel;
  private final List<JLabel> resultDices;

  DiceResultRow(int diceNumber) {
    this.diceNumber = diceNumber;
    resultDices = new LinkedList<JLabel>();
    setComponents();
  }

  private void setComponents() {
    setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));

    infoLabel = new JLabel("D" + diceNumber + " : ");
    infoLabel.setFont(new Font(null, Font.BOLD, 13));
    add(infoLabel);
  }

  public void clearResults() {
    for (JLabel resultDice : resultDices) {
      remove(resultDice);
    }
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
