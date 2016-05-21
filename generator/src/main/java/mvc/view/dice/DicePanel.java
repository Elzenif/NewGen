package mvc.view.dice;

import mvc.controller.dice.RollDiceController;
import mvc.model.dice.EDiceNumber;
import mvc.view.Constants;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * Created by Germain on 07/05/2016.
 */
public class DicePanel extends JPanel {

  private JPanel leftPanel;
  private JPanel rightPanel;

  private final int NB_ROWS = 8;
  private final int NB_COLS = 1;

  public DicePanel() {
    setLayout(new GridLayout(0, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));

    leftPanel = setPanel("Options");
    rightPanel = setPanel("Results");

    for (EDiceNumber eDiceNumber : EDiceNumber.values()) {
      DiceOptionRow diceOptionRow = new DiceOptionRow(eDiceNumber.getDiceNumber());
      DiceResultRow diceResultRow = new DiceResultRow(eDiceNumber.getDiceNumber());
      diceOptionRow.setController(new RollDiceController(eDiceNumber.getDiceNumber(), diceOptionRow, diceResultRow));
      leftPanel.add(diceOptionRow);
      rightPanel.add(diceResultRow);
    }

    add(leftPanel);
    add(rightPanel);
  }

  private JPanel setPanel(String title) {
    JPanel jPanel = new JPanel(new GridLayout(NB_ROWS, NB_COLS, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    jPanel.setBorder(BorderFactory.createTitledBorder(title));
    return jPanel;
  }
}
