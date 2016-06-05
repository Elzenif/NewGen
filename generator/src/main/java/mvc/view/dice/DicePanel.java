package mvc.view.dice;

import mvc.model.dice.EDiceNumber;
import mvc.view.commons.DoublePanel;

/**
 * Created by Germain on 07/05/2016.
 */
public class DicePanel extends DoublePanel {

  public DicePanel() {
    super(setPanel("Options", EDiceNumber.values().length),
            setPanel("Results", EDiceNumber.values().length));
  }

  @Override
  protected void setPanelsComponents() {
    for (EDiceNumber eDiceNumber : EDiceNumber.values()) {
      DiceOptionRow diceOptionRow = new DiceOptionRow(eDiceNumber);
      DiceResultRow diceResultRow = new DiceResultRow(eDiceNumber);
      diceOptionRow.setControllers(diceResultRow);
      leftPanel.add(diceOptionRow);
      rightPanel.add(diceResultRow);
    }
  }
}
