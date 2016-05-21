package mvc.model.dice;

/**
 * Created by Germain on 21/05/2016.
 */
public enum EDiceNumber {

  D4(4),
  D6(6),
  D8(8),
  D10(10),
  D12(12),
  D20(20),
  D100(100);

  private int diceNumber;

  EDiceNumber(int diceNumber) {
    this.diceNumber = diceNumber;
  }

  public int getDiceNumber() {
    return diceNumber;
  }
}
