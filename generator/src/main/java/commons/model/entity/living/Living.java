package commons.model.entity.living;

import commons.model.commons.Game;
import commons.model.entity.Entity;
import commons.model.entity.characteristics.primary.enums.IRarity;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 28/08/2016.
 */
public abstract class Living<T extends Game> extends Entity {

  protected Living(EntityBuilder builder) {
    super(builder);
  }

  private Living() {}

  @Contract(" -> !null")
  public static Living stubbedLiving() {
    return new StubbedLiving();
  }

  @Override
  public IRarity getRarity() {
    return rarity;
  }

  protected abstract static class LivingBuilder extends EntityBuilder {
  }

  private static class StubbedLiving extends Living {
    @Override
    public String toString() {
      return "#####";
    }
  }
}
