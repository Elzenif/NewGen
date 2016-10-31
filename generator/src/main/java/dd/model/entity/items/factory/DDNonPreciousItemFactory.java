package dd.model.entity.items.factory;

import commons.model.dice.Dice;
import dd.model.entity.items.characteristics.EDDItemPowerRarityKey;
import dd.model.entity.items.factory.subfactory.DDItemFactoryFactory;
import dd.model.entity.items.factory.subfactory.DDNonMagicItemFactory;
import dd.model.entity.items.treasures.DDTreasure;

import java.util.Collections;
import java.util.List;

/**
 * Created by Germain on 30/10/2016.
 */
public class DDNonPreciousItemFactory extends DDTreasureFactory {

  private static final DDNonPreciousItemFactory INSTANCE = new DDNonPreciousItemFactory();

  private DDNonPreciousItemFactory() {
  }

  public static DDNonPreciousItemFactory getInstance() {
    return INSTANCE;
  }

  @Override
  protected List<DDTreasure> generate(int level, int diceResult) {
    return generateFromItemSubFactory(level, diceResult);
  }

  private List<DDTreasure> generateFromItemSubFactory(int level, int diceResult) {
    switch (level) {
      case 1:
        return generateFromItemSubFactory(diceResult, 71, 95, new Dice(1, 1), new Dice(1, 1));
      case 2:
        return generateFromItemSubFactory(diceResult, 49, 85, new Dice(1, 1), new Dice(1, 1));
      default:
        return Collections.emptyList();
    }
  }

  private List<DDTreasure> generateFromItemSubFactory(int diceResult, int p0, int p1, Dice dice1, Dice dice2) {
    if (diceResult <= p0) {
      return Collections.emptyList();
    } else if (diceResult <= p1) {
      return getSubFactory(DDNonMagicItemFactory.getInstance(), dice1).generate();
    } else {
      return getSubFactory(DDItemFactoryFactory.getInstance(), dice2).generate(EDDItemPowerRarityKey.WEAK);
    }
  }
}
