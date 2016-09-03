package nbk.model.entity.living;

import commons.model.entity.constraints.GlobalConstraints;
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

  @Contract("_ -> !null")
  public static NbkHumanoid create(GlobalConstraints globalConstraints) throws NoAvailableEntityTypeException {
    return new HumanoidBuilder(globalConstraints).build();
  }

  @Contract("_, _ -> !null")
  public static NbkHumanoid create(GlobalConstraints globalConstraints, Stats stats)
          throws NoAvailableEntityTypeException {
    return new HumanoidBuilder(globalConstraints, stats).build();
  }

  public ENbkOrigin getOrigin() {
    return origin;
  }

  private static class HumanoidBuilder extends NbkLivingBuilder {

    private final GlobalConstraints globalConstraints;
    ENbkOrigin origin;

    public HumanoidBuilder(GlobalConstraints globalConstraints) throws NoAvailableEntityTypeException {
      this(globalConstraints, new Stats());
    }

    public HumanoidBuilder(GlobalConstraints globalConstraints, Stats stats) throws NoAvailableEntityTypeException {
      super(stats);
      this.globalConstraints = globalConstraints;
    }

    void setOrigin(Predicate<ENbkOrigin> predicate) throws NoAvailableEntityTypeException {
      origin = EntityUtils.selectRandomRarity(NbkLivingUtils.listAvailableOrigins(), predicate);
    }

    @Contract(" -> !null")
    public NbkHumanoid build() throws NoAvailableEntityTypeException {
      for (EStat stat : EStat.values()) {
        if (!stats.containsKey(stat)) {
          stats.put(stat, MathUtils.random(8, 13));
        }
      }
      setOrigin(ENbkOrigin.getPredicate(globalConstraints));
      return new NbkHumanoid(this);
    }
  }
}
