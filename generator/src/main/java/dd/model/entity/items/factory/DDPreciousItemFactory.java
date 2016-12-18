package dd.model.entity.items.factory;

import commons.model.dice.Dice;
import dd.model.entity.items.factory.subfactory.DDArtObjectFactory;
import dd.model.entity.items.factory.subfactory.DDGemFactory;
import dd.model.entity.items.treasures.DDTreasure;

import java.util.Collections;
import java.util.List;

/**
 * Created by Germain on 29/10/2016.
 */
public class DDPreciousItemFactory extends DDTreasureFactory {

  private static final DDPreciousItemFactory INSTANCE = new DDPreciousItemFactory();

  private DDPreciousItemFactory() {
  }

  public static DDPreciousItemFactory getInstance() {
    return INSTANCE;
  }

  @Override
  protected List<DDTreasure> generate(int level, int diceResult) {
    return generateFromPreciousItemSubFactory(level, diceResult);
  }

  private List<DDTreasure> generateFromPreciousItemSubFactory(int level, int diceResult) {
    switch (level) {
      case 1:
        return generateFromPreciousItemSubFactory(diceResult, 90, 95, Dice.D1, Dice.D1);
      case 2:
        return generateFromPreciousItemSubFactory(diceResult, 81, 95, new Dice(1, 3), new Dice(1, 3));
      default:
        return Collections.emptyList();
    }
  }

  private List<DDTreasure> generateFromPreciousItemSubFactory(int diceResult, int p0Dice, int p1Dice, Dice dice1,
                                                              Dice dice2) {
    if (diceResult <= p0Dice) {
      return Collections.emptyList();
    } else if (diceResult <= p1Dice) {
      return getSubFactory(DDGemFactory.getInstance(), dice1).generate();
    } else {
      return getSubFactory(DDArtObjectFactory.getInstance(), dice2).generate();
    }
  }
}
