package nbk.model.entity.living;

import commons.model.entity.utils.EntityUtils;
import commons.utils.MathUtils;
import commons.utils.exception.NoAvailableEntityTypeException;
import nbk.model.entity.living.characteristics.primary.EStat;
import nbk.model.entity.living.characteristics.primary.Stats;
import nbk.model.entity.living.characteristics.secondary.enums.ENbkOrigin;
import org.jetbrains.annotations.Contract;

import java.util.function.Predicate;

/**
 * Created by Germain on 28/08/2016.
 */
public class NbkHumanoid extends NbkLiving {

  private final ENbkOrigin origin;

  private NbkHumanoid(HumanoidBuilder builder) {
    super(builder);
    origin = builder.origin;
  }

  @Contract(" -> !null")
  public static NbkHumanoid create() throws NoAvailableEntityTypeException {
    return new HumanoidBuilder().build();
  }

  @Contract("_ -> !null")
  public static NbkHumanoid create(Stats stats)
          throws NoAvailableEntityTypeException {
    return new HumanoidBuilder(stats).build();
  }

  @Override
  public String toString() {
    return origin.getName().toString();
  }

  ENbkOrigin getOrigin() {
    return origin;
  }


  private static class HumanoidBuilder extends NbkLivingBuilder {

    ENbkOrigin origin;

    HumanoidBuilder() throws NoAvailableEntityTypeException {
      this(new Stats());
    }

    HumanoidBuilder(Stats stats) {
      super(stats);
    }

    void setOrigin(Predicate<ENbkOrigin> predicate) throws NoAvailableEntityTypeException {
      origin = EntityUtils.selectRandomRarity(ENbkOrigin.values(), predicate);
    }

    @Contract(" -> !null")
    public NbkHumanoid build() throws NoAvailableEntityTypeException {
      for (EStat stat : EStat.values()) {
        if (!stats.containsKey(stat)) {
          stats.put(stat, MathUtils.random(8, 13));
        }
      }
      setOrigin(ENbkOrigin.getPredicate(stats));
      return new NbkHumanoid(this);
    }
  }
}
