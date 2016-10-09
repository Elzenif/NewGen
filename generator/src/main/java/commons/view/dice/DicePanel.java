package commons.view.dice;

import commons.model.dice.EDiceNumber;
import commons.view.commons.DoublePanel;

/**
 * Created by Germain on 07/05/2016.
 */
public class DicePanel extends DoublePanel<DiceOptionRow, DiceResultRow> {

  public DicePanel() {
    super(EDiceNumber.values());
  }
}
