package nbk.model.entity.living;

import commons.model.commons.constraints.GenerationConstraints;
import commons.model.commons.constraints.MapConstraint;
import commons.model.entity.utils.EntityUtils;
import commons.utils.MathUtils;
import commons.utils.exception.NoAvailableEntityTypeException;
import commons.utils.exception.StatNotInRangeException;
import commons.utils.french.FrenchNoun;
import nbk.model.entity.living.characteristics.primary.EStat;
import nbk.model.entity.living.characteristics.primary.Stats;
import nbk.model.entity.living.characteristics.primary.fields.HasEV;
import nbk.model.entity.living.characteristics.primary.fields.HasStatsInRange;
import nbk.model.entity.living.characteristics.secondary.enums.ENbkOrigin;
import nbk.model.entity.living.characteristics.secondary.enums.ENbkProfession;
import nbk.model.entity.living.constraints.EHumanoidDraw;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Predicate;

/**
 * Created by Germain on 28/08/2016.
 */
public class NbkHumanoid extends NbkLiving implements HasEV {

  private static final Logger LOGGER = LoggerFactory.getLogger(NbkHumanoid.class);

  private final ENbkOrigin origin;
  private final ENbkProfession profession;
  private final int ev;

  private NbkHumanoid(HumanoidBuilder builder) {
    super(builder);
    origin = builder.origin;
    profession = builder.profession;
    ev = builder.ev;
  }

  /**
   * Create an humanoid without any constraint
   *
   * @return An humanoid
   */
  @Contract(" -> !null")
  public static NbkHumanoid create() {
    return new HumanoidBuilder().build();
  }

  @SuppressWarnings("HardCodedStringLiteral")
  @Contract("_ -> !null")
  public static NbkHumanoid create(GenerationConstraints generationConstraints) {
    try {
      Stats stats = new Stats(generationConstraints.getDrawKeyConstraint());
      MapConstraint mapConstraint = generationConstraints.getMapConstraint();
      if (!mapConstraint.isEmpty()) {
        return new HumanoidBuilder(stats)
            .setOrigin((ENbkOrigin) mapConstraint.get(EHumanoidDraw.ORIGIN))
            .setProfession((ENbkProfession) mapConstraint.get(EHumanoidDraw.PROFESSION))
            .build();
      } else {
        return new HumanoidBuilder(stats).build();
      }
    } catch (StatNotInRangeException e) {
      LOGGER.error("Constraints are not suitable for stats construction");
      e.printStackTrace();
      return new HumanoidBuilder().build();
    }
  }

  @Override
  public String toString() {
    FrenchNoun originName = origin.getName();
    String professionString = (profession == null) ? "" : profession.getName(originName.getGender()).toString();
    return originName.toString() + " " + professionString;
  }

  ENbkOrigin getOrigin() {
    return origin;
  }

  ENbkProfession getProfession() {
    return profession;
  }

  @Override
  public int getEV() {
    return ev;
  }


  private static class HumanoidBuilder extends NbkLivingBuilder {

    final boolean statsBefore;
    ENbkOrigin origin;
    ENbkProfession profession;
    int ev;

    HumanoidBuilder() {
      super(new Stats());
      statsBefore = false;
    }

    HumanoidBuilder(Stats stats) {
      super(stats);
      statsBefore = true;
    }

    private void initStatsAccordingTo(HasStatsInRange hasStatsInRange) {
      int min, max;
      for (EStat stat : EStat.values()) {
        if (hasStatsInRange.getMinStats().containsKey(stat)) {
          min = hasStatsInRange.getMinStats().get(stat);
          max = 13;
          stats.put(stat, MathUtils.random(min, max));
        } else if (hasStatsInRange.getMaxStats().containsKey(stat)) {
          min = 8;
          max = hasStatsInRange.getMaxStats().get(stat);
          stats.put(stat, MathUtils.random(min, max));
        }
      }
    }

    private void initRemainingStats() {
      for (EStat stat : EStat.values()) {
        if (!this.stats.containsKey(stat)) {
          this.stats.put(stat, MathUtils.random(8, 13));
        }
      }
    }

    void setOrigin(Predicate<ENbkOrigin> predicate) {
      if (origin == null) {
        try {
          origin = EntityUtils.selectRandomRarity(ENbkOrigin.values(), predicate);
        } catch (NoAvailableEntityTypeException e) {
          origin = ENbkOrigin.HUMAN;
        }
      }
    }

    void setProfession(Predicate<ENbkProfession> predicate) {
      if (origin.getCanHaveProfession() && profession == null) {
        try {
          profession = EntityUtils.selectRandomRarity(ENbkProfession.values(), predicate);
        } catch (NoAvailableEntityTypeException e) {
          profession = null;
        }
      }
    }

    @Contract(" -> !null")
    public NbkHumanoid build() {
      if (statsBefore) {
        initRemainingStats();
        setOrigin(ENbkOrigin.getPredicate(this.stats));
        setProfession(ENbkProfession.getPredicate(this.stats));
      } else {
        setOrigin(ENbkOrigin.getPredicate(stats));
        initStatsAccordingTo(origin);
        setProfession(ENbkProfession.getPredicate(stats));
        if (profession != null) {
          initStatsAccordingTo(profession);
        }
        initRemainingStats();
      }
      setEV();
      return new NbkHumanoid(this);
    }

    private void setEV() {
      ev = origin.getEV();
      if (profession != null) {
        ev = profession.getEV(origin);
      }
    }

    public HumanoidBuilder setOrigin(@Nullable ENbkOrigin origin) {
      if (origin != null && statsAreCompatible(origin)) {
        this.origin = origin;
        initStatsAccordingTo(origin);
      }
      return this;
    }

    public HumanoidBuilder setProfession(@Nullable ENbkProfession profession) {
      if (profession != null && statsAreCompatible(profession)) {
        this.profession = profession;
        initStatsAccordingTo(profession);
      }
      return this;
    }

    @SuppressWarnings("HardCodedStringLiteral")
    private boolean statsAreCompatible(HasStatsInRange hasStatsInRange) {
      for (EStat stat : EStat.values()) {
        if (hasStatsInRange.getMinStats().containsKey(stat)) {
          if (stats.containsKey(stat) && stats.get(stat) < (int) hasStatsInRange.getMinStats().get(stat)) {
            LOGGER.error("Stat " + stat + " = " + stats.get(stat) + " is not compatible with " + hasStatsInRange);
            return false;
          }
        } else if (hasStatsInRange.getMaxStats().containsKey(stat)) {
          if (stats.containsKey(stat) && stats.get(stat) > (int) hasStatsInRange.getMaxStats().get(stat)) {
            LOGGER.error("Stat " + stat + " = " + stats.get(stat) + " is not compatible with " + hasStatsInRange);
            return false;
          }
        }
      }
      return true;
    }
  }
}
