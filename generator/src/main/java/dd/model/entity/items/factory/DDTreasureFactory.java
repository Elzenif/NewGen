package dd.model.entity.items.factory;

import commons.model.commons.constraints.DrawKeyConstraint;
import commons.model.commons.constraints.GenerationConstraints;
import dd.model.entity.items.treasure.DDTreasure;
import dd.model.entity.items.treasure.EDDTreasureDraw;

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
    Integer level = drawKeyConstraint.get(EDDTreasureDraw.LEVEL);
    Integer diceResult = drawKeyConstraint.get(EDDTreasureDraw.DICE);
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
}
