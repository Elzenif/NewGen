package nbk.model.entity.living;

import commons.model.entity.living.Living;
import commons.utils.exception.StatNotInRangeException;
import nbk.model.commons.NbkGame;
import nbk.model.entity.living.characteristics.primary.EStat;
import nbk.model.entity.living.characteristics.primary.StatUtils;
import nbk.model.entity.living.characteristics.primary.Stats;
import nbk.model.entity.living.characteristics.primary.builders.StatsBuilder;
import nbk.model.entity.living.characteristics.primary.fields.HasStats;

/**
 * Created by Germain on 29/08/2016.
 */
public abstract class NbkLiving extends Living<NbkGame> implements HasStats {

  private final Stats stats;

  protected NbkLiving(NbkLivingBuilder builder) {
    super(builder);
    stats = builder.stats;
  }

  @Override
  public Stats getStats() {
    return stats;
  }

  public int getCourage() {
    return stats.get(EStat.COURAGE);
  }

  public int getIntelligence() {
    return stats.get(EStat.INTELLIGENCE);
  }

  public int getCharisma() {
    return stats.get(EStat.CHARISMA);
  }

  public int getAgility() {
    return stats.get(EStat.AGILITY);
  }

  public int getStrength() {
    return stats.get(EStat.STRENGTH);
  }

  protected static abstract class NbkLivingBuilder extends LivingBuilder implements StatsBuilder {

    protected final Stats stats;

    public NbkLivingBuilder(Stats stats) {
      this.stats = stats;
    }

    // Setters
    @Override
    public NbkLivingBuilder setCourage(int courage) throws StatNotInRangeException {
      StatUtils.setStat(stats.getStatsMap(), EStat.COURAGE, courage);
      return this;
    }

    @Override
    public NbkLivingBuilder setIntelligence(int intelligence) throws StatNotInRangeException {
      StatUtils.setStat(stats.getStatsMap(), EStat.INTELLIGENCE, intelligence);
      return this;
    }

    @Override
    public NbkLivingBuilder setCharisma(int charisma) throws StatNotInRangeException {
      StatUtils.setStat(stats.getStatsMap(), EStat.CHARISMA, charisma);
      return this;
    }

    @Override
    public NbkLivingBuilder setAgility(int agility) throws StatNotInRangeException {
      StatUtils.setStat(stats.getStatsMap(), EStat.AGILITY, agility);
      return this;
    }

    @Override
    public NbkLivingBuilder setStrength(int strength) throws StatNotInRangeException {
      StatUtils.setStat(stats.getStatsMap(), EStat.STRENGTH, strength);
      return this;
    }

    // Getters
    @Override
    public Stats getStats() {
      return stats;
    }
  }
}
