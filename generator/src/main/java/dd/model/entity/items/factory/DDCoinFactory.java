package dd.model.entity.items.factory;

import commons.model.dice.Dice;
import dd.model.entity.items.treasures.DDTreasure;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

/**
 * Created by Germain on 26/10/2016.
 */
public class DDCoinFactory extends DDTreasureFactory {

  private static final DDCoinFactory INSTANCE = new DDCoinFactory();

  private DDCoinFactory() {
  }

  public static DDCoinFactory getInstance() {
    return INSTANCE;
  }

  @Override
  protected List<DDTreasure> generate(int level, int diceResult) {
    return Collections.singletonList(getCoin(level, diceResult));
  }

  @SuppressWarnings("HardCodedStringLiteral")
  @Nullable
  private DDTreasure getCoin(int level, int diceResult) {
    switch (level) {
      case 1:
        return getCoin(diceResult, 14, 29, 52, 95, new Dice(6), new Dice(8), new Dice(2, 8), new Dice(3),
            "000 pc", "00 pa", "0 po", "0 pp");
      case 2:
        return getCoin(diceResult, 13, 23, 43, 95, new Dice(10), new Dice(2, 10), new Dice(4, 10), new Dice(4),
            "000 pc", "00 pa", "0 po", "0 pp");
      case 3:
        return getCoin(diceResult, 11, 21, 41, 95, new Dice(2, 10), new Dice(4, 8), new Dice(4), new Dice(6),
            "000 pc", "00 pa", "00 po", "0 pp");
      case 4:
        return getCoin(diceResult, 11, 21, 41, 95, new Dice(3, 10), new Dice(4, 12), new Dice(6), new Dice(8),
            "000 pc", "00 pa", "00 po", "0 pp");
      case 5:
        return getCoin(diceResult, 10, 19, 38, 95, new Dice(4), new Dice(6), new Dice(8), new Dice(10),
            "0000 pc", "000 pa", "00 po", "0 pp");
      case 6:
        return getCoin(diceResult, 10, 18, 37, 95, new Dice(6), new Dice(8), new Dice(10), new Dice(12),
            "0000 pc", "000 pa", "00 po", "0 pp");
      default:
        return null;
    }
  }

  @Nullable
  private DDTreasure getCoin(int diceResult, int p0Dice, int p1Dice, int p2Dice, int p3Dice, Dice dice1, Dice dice2,
                             Dice dice3, Dice dice4, String value1, String value2, String value3, String value4) {
    String value;
    Dice dice;
    if (diceResult <= p0Dice) {
      return null;
    } else if (diceResult <= p1Dice) {
      dice = dice1;
      value = value1;
    } else if (diceResult <= p2Dice) {
      dice = dice2;
      value = value2;
    } else if (diceResult <= p3Dice) {
      dice = dice3;
      value = value3;
    } else {
      dice = dice4;
      value = value4;
    }
    dice.roll();
    return new DDTreasure(dice.getScore() + value);
  }
}
