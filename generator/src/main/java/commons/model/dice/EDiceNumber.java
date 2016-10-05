package commons.model.dice;

import commons.view.dice.DiceOptionRow;
import commons.view.dice.DiceResultRow;
import commons.view.dice.IAvailableDiceRow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;

/**
 * Created by Germain on 21/05/2016.
 */
public enum EDiceNumber implements IAvailableDiceRow {

  D4(4),
  D6(6),
  D8(8),
  D10(10),
  D12(12),
  D20(20),
  D100(100);

  private final int diceNumber;
  @NonNls
  private final String name;

  EDiceNumber(int diceNumber) {
    this.diceNumber = diceNumber;
    this.name = "D" + diceNumber;
  }

  public int getDiceNumber() {
    return diceNumber;
  }

  @Override
  public String getName() {
    return name;
  }


  @Contract(" -> !null")
  @Override
  public DiceOptionRow getOptionRow() {
    return new DiceOptionRow(this);
  }

  @Contract(" -> !null")
  @Override
  public DiceResultRow getResultRow() {
    return new DiceResultRow(this);
  }
}
