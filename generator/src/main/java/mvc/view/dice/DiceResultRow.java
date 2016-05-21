package mvc.view.dice;

import mvc.view.Constants;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

/**
 * Created by Germain on 21/05/2016.
 */
public class DiceResultRow extends JPanel {

  private int diceNumber;

  private JLabel infoLabel;
  private JLabel resultDice;

  DiceResultRow(int diceNumber) {
    this.diceNumber = diceNumber;
    setComponents();
  }

  private void setComponents() {
    setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));

    infoLabel = new JLabel("D" + diceNumber + " results: ");
    add(infoLabel);

    resultDice = new JLabel();
    add(resultDice);
  }

  public void setResult(String result) {
    resultDice.setText(result);
  }
}
