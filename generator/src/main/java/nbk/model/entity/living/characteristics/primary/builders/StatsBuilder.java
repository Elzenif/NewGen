package nbk.model.entity.living.characteristics.primary.builders;

import commons.utils.exception.StatNotInRangeException;
import nbk.model.entity.living.characteristics.primary.fields.HasStats;

/**
 * Created by Germain on 29/08/2016.
 */
public interface StatsBuilder extends HasStats {

  StatsBuilder setCourage(int courage) throws StatNotInRangeException;
  StatsBuilder setIntelligence(int intelligence) throws StatNotInRangeException;
  StatsBuilder setCharisma(int charisma) throws StatNotInRangeException;
  StatsBuilder setAgility(int agility) throws StatNotInRangeException;
  StatsBuilder setStrength(int strength) throws StatNotInRangeException;
}
