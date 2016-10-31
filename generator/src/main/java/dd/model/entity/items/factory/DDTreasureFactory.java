package dd.model.entity.items.factory;

import commons.model.commons.constraints.DrawKeyConstraint;
import commons.model.commons.constraints.GenerationConstraints;
import commons.model.dice.Dice;
import commons.utils.MathUtils;
import dd.model.entity.items.factory.subfactory.DDTreasureSubFactory;
import dd.model.entity.items.treasures.DDTreasure;
import dd.model.entity.items.treasures.EDDTreasureDraw;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 26/10/2016.
 */
public abstract class DDTreasureFactory {

  private DDTreasureFactory nextFactory;

  public void setNextFactory(DDTreasureFactory nextFactory) {
    this.nextFactory = nextFactory;
  }

  public List<DDTreasure> generateTreasures(GenerationConstraints generationConstraints) {
    DrawKeyConstraint drawKeyConstraint = generationConstraints.getDrawKeyConstraint();
    int level = (drawKeyConstraint.containsKey(EDDTreasureDraw.LEVEL))
        ? drawKeyConstraint.get(EDDTreasureDraw.LEVEL)
        : 1;
    int diceResult = (drawKeyConstraint.containsKey(EDDTreasureDraw.DICE))
        ? drawKeyConstraint.get(EDDTreasureDraw.DICE)
        : MathUtils.random(1, 100);
    return generateTreasures(level, diceResult);
  }

  private List<DDTreasure> generateTreasures(int level, int diceResult) {
    List<DDTreasure> treasures = new LinkedList<>(generate(level, diceResult));
    if (nextFactory != null) {
      treasures.addAll(nextFactory.generateTreasures(level, diceResult));
    }
    return treasures;
  }

  protected abstract List<DDTreasure> generate(int level, int diceResult);

  protected <F extends DDTreasureSubFactory> F getSubFactory(F factory, Dice dice) {
    dice.roll();
    factory.setNumberToGenerate(dice.getScore());
    return factory;
  }
}
