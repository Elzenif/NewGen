package commons.view.dice;

import commons.model.dice.EDiceNumber;
import commons.utils.Pair;
import commons.view.MainFrame;
import commons.view.utils.DoublePanel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Germain on 07/05/2016.
 */
public class DicePanel extends DoublePanel<DiceOptionRow, DiceResultRow> {

  private final List<Pair<DiceOptionRow, DiceResultRow>> rowPairs = new ArrayList<>(EDiceNumber.values().length);

  public DicePanel() {
    super(setPanel("Options", EDiceNumber.values().length),
            setPanel("Results", EDiceNumber.values().length));

    for (EDiceNumber eDiceNumber : EDiceNumber.values()) {
      DiceOptionRow diceOptionRow = new DiceOptionRow(eDiceNumber);
      DiceResultRow diceResultRow = new DiceResultRow(eDiceNumber);
      rowPairs.add(new Pair<>(diceOptionRow, diceResultRow));
      leftPanel.add(diceOptionRow);
      rightPanel.add(diceResultRow);
    }
    add(leftPanel);
    add(rightPanel);
  }

  @Override
  public void setControllers(MainFrame view) {
    super.setControllers(rowPairs);
  }
}
