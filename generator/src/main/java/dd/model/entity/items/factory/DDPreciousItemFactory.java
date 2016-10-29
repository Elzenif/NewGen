package dd.model.entity.items.factory;

import commons.model.dice.Dice;
import dd.model.entity.items.factory.subfactory.DDArtObjectFactory;
import dd.model.entity.items.factory.subfactory.DDEmptyFactory;
import dd.model.entity.items.factory.subfactory.DDGemFactory;
import dd.model.entity.items.factory.subfactory.DDTreasureSubFactory;
import dd.model.entity.items.treasure.DDTreasure;

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
    return getPreciousItemSubFactory(level, diceResult).generate();
  }

  private DDTreasureSubFactory getPreciousItemSubFactory(int level, int diceResult) {
    switch (level) {
      case 1:
        return getPreciousItemSubFactory(diceResult, 90, 95, new Dice(1, 1), new Dice(1, 1));
      case 2:
        return getPreciousItemSubFactory(diceResult, 81, 95, new Dice(1, 3), new Dice(1, 3)); // TODO check value
      default:
        return DDEmptyFactory.getInstance();
    }
  }

  private DDTreasureSubFactory getPreciousItemSubFactory(int diceResult, int p0Dice, int p1Dice, Dice dice1,
                                                         Dice dice2) {
    if (diceResult <= p0Dice) {
      return DDEmptyFactory.getInstance();
    } else if (diceResult <= p1Dice) {
      DDGemFactory gemFactory = DDGemFactory.getInstance();
      dice1.roll();
      gemFactory.setNumberToGenerate(dice1.getScore());
      return gemFactory;
    } else {
      DDArtObjectFactory artObjectFactory = DDArtObjectFactory.getInstance();
      dice2.roll();
      artObjectFactory.setNumberToGenerate(dice2.getScore());
      return artObjectFactory;
    }
  }
}
