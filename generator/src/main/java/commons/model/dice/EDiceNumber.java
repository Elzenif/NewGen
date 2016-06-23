package commons.model.dice;

import commons.model.commons.HasName;

/**
 * Created by Germain on 21/05/2016.
 */
public enum EDiceNumber implements HasName<String> {

  D4(4),
  D6(6),
  D8(8),
  D10(10),
  D12(12),
  D20(20),
  D100(100);

  private final int diceNumber;
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
}
