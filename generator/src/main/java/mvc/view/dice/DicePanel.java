package mvc.view.dice;

import mvc.model.dice.results.enums.EDiceNumber;
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
      DiceOptionRow diceOptionRow = new DiceOptionRow(eDiceNumber.getDiceNumber());
      DiceResultRow diceResultRow = new DiceResultRow(eDiceNumber.getDiceNumber());
      diceOptionRow.setControllers(diceResultRow);
      leftPanel.add(diceOptionRow);
      rightPanel.add(diceResultRow);
    }
  }
}
