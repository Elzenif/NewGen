package nbk.model.entity.living.characteristics.primary;

import commons.model.commons.IDrawKey;
import commons.model.commons.constraints.DrawKeyConstraint;
import commons.utils.exception.StatNotInRangeException;
import nbk.model.entity.living.characteristics.primary.builders.StatsBuilder;

import java.util.Map;

/**
 * Created by Germain on 29/08/2016.
 */
public class Stats extends DrawKeyConstraint implements StatsBuilder {

  public Stats() {
  }

  public Stats(DrawKeyConstraint drawKeyConstraint) throws StatNotInRangeException {
    for (Entry<IDrawKey, Integer> entry : drawKeyConstraint.entrySet()) {
      StatUtils.setStat(map, (EStat) entry.getKey(), entry.getValue());
    }
  }

  @Override
  public Stats setCourage(int courage) throws StatNotInRangeException {
    StatUtils.setStat(map, EStat.COURAGE, courage);
    return this;
  }

  @Override
  public Stats setIntelligence(int intelligence) throws StatNotInRangeException {
    StatUtils.setStat(map, EStat.INTELLIGENCE, intelligence);
    return this;
  }

  @Override
  public Stats setCharisma(int charisma) throws StatNotInRangeException {
    StatUtils.setStat(map, EStat.CHARISMA, charisma);
    return this;
  }

  @Override
  public Stats setAgility(int agility) throws StatNotInRangeException {
    StatUtils.setStat(map, EStat.AGILITY, agility);
    return this;
  }

  @Override
  public Stats setStrength(int strength) throws StatNotInRangeException {
    StatUtils.setStat(map, EStat.STRENGTH, strength);
    return this;
  }

  @Override
  public Stats getStats() {
    return this;
  }

  public Map<IDrawKey, Integer> getStatsMap() {
    return map;
  }
}
