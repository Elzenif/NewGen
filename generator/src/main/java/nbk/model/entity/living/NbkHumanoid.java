package nbk.model.entity.living;

import commons.model.entity.utils.EntityUtils;
import commons.utils.MathUtils;
import commons.utils.exception.NoAvailableEntityTypeException;
import commons.utils.french.FrenchNoun;
import nbk.model.entity.living.characteristics.primary.EStat;
import nbk.model.entity.living.characteristics.primary.Stats;
import nbk.model.entity.living.characteristics.primary.fields.HasEV;
import nbk.model.entity.living.characteristics.primary.fields.HasStatsInRange;
import nbk.model.entity.living.characteristics.secondary.enums.ENbkOrigin;
import nbk.model.entity.living.characteristics.secondary.enums.ENbkProfession;
import org.jetbrains.annotations.Contract;

import java.util.function.Predicate;

/**
 * Created by Germain on 28/08/2016.
 */
public class NbkHumanoid extends NbkLiving implements HasEV {

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

  /**
   * Create an humanoid with the given stats as constraints
   *
   * @param stats Stats imposed for the humanoid
   * @return An humanoid
   */
  @Contract("_ -> !null")
  public static NbkHumanoid create(Stats stats) {
    return new HumanoidBuilder(stats).build();
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

    ENbkOrigin origin;
    ENbkProfession profession;
    int ev;

    HumanoidBuilder() {
      super(new Stats());
      setOrigin(ENbkOrigin.getPredicate(stats));
      initStatsAccordingTo(origin);
      setProfession(ENbkProfession.getPredicate(stats));
      if (profession != null) {
        initStatsAccordingTo(profession);
      }
      initRemainingStats();
    }

    HumanoidBuilder(Stats stats) {
      super(stats);
      initRemainingStats();
      setOrigin(ENbkOrigin.getPredicate(this.stats));
      setProfession(ENbkProfession.getPredicate(this.stats));
    }

    private void initStatsAccordingTo(HasStatsInRange hasStatsInRange) {
      for (EStat stat : EStat.values()) {
        if (hasStatsInRange.getMinStats().containsKey(stat)) {
          stats.put(stat, MathUtils.random(hasStatsInRange.getMinStats().get(stat), 13));
        } else if (hasStatsInRange.getMaxStats().containsKey(stat)) {
          stats.put(stat, MathUtils.random(8, hasStatsInRange.getMaxStats().get(stat)));
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
      try {
        origin = EntityUtils.selectRandomRarity(ENbkOrigin.values(), predicate);
      } catch (NoAvailableEntityTypeException e) {
        origin = ENbkOrigin.HUMAN;
      }
    }

    void setProfession(Predicate<ENbkProfession> predicate) {
      if (origin.getCanHaveProfession()) {
        try {
          profession = EntityUtils.selectRandomRarity(ENbkProfession.values(), predicate);
        } catch (NoAvailableEntityTypeException e) {
          profession = null;
        }
      }
    }

    @Contract(" -> !null")
    public NbkHumanoid build() {
      setEV();
      return new NbkHumanoid(this);
    }

    private void setEV() {
      ev = origin.getEV();
      if (profession != null) {
        ev = profession.getEV(origin);
      }
    }
  }
}
