package nbk.model.entity.living.characteristics.primary;

import com.google.common.collect.ForwardingMap;
import commons.utils.exception.StatNotInRangeException;
import nbk.model.entity.living.characteristics.primary.builders.StatsBuilder;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by Germain on 29/08/2016.
 */
public class Stats extends ForwardingMap<EStat, Integer> implements StatsBuilder {

  private EnumMap<EStat, Integer> statsMap = new EnumMap<>(EStat.class);

  @Override
  protected Map<EStat, Integer> delegate() {
    return statsMap;
  }
  
  @Override
  public Stats setCourage(int courage) throws StatNotInRangeException {
    StatUtils.setStat(statsMap, EStat.COURAGE, courage);
    return this;
  }

  @Override
  public Stats setIntelligence(int intelligence) throws StatNotInRangeException {
    StatUtils.setStat(statsMap, EStat.INTELLIGENCE, intelligence);
    return this;
  }

  @Override
  public Stats setCharisma(int charisma) throws StatNotInRangeException {
    StatUtils.setStat(statsMap, EStat.CHARISMA, charisma);
    return this;
  }

  @Override
  public Stats setAgility(int agility) throws StatNotInRangeException {
    StatUtils.setStat(statsMap, EStat.AGILITY, agility);
    return this;
  }

  @Override
  public Stats setStrength(int strength) throws StatNotInRangeException {
    StatUtils.setStat(statsMap, EStat.STRENGTH, strength);
    return this;
  }

  @Override
  public Stats getStats() {
    return this;
  }

  public EnumMap<EStat, Integer> getStatsMap() {
    return statsMap;
  }
}
