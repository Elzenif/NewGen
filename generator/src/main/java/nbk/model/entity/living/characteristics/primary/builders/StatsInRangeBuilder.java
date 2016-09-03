package nbk.model.entity.living.characteristics.primary.builders;

import commons.utils.exception.StatNotInRangeException;
import nbk.model.entity.living.characteristics.primary.fields.HasStatsInRange;

/**
 * Created by Germain on 03/09/2016.
 */
public interface StatsInRangeBuilder extends HasStatsInRange {

  StatsInRangeBuilder setMinCourage(int minCourage) throws StatNotInRangeException;

  StatsInRangeBuilder setMinIntelligence(int minIntelligence) throws StatNotInRangeException;

  StatsInRangeBuilder setMinCharisma(int minCharisma) throws StatNotInRangeException;

  StatsInRangeBuilder setMinAgility(int minAgility) throws StatNotInRangeException;

  StatsInRangeBuilder setMinStrength(int minStrength) throws StatNotInRangeException;

  StatsInRangeBuilder setMaxCourage(int maxCourage) throws StatNotInRangeException;

  StatsInRangeBuilder setMaxIntelligence(int maxIntelligence) throws StatNotInRangeException;

  StatsInRangeBuilder setMaxCharisma(int maxCharisma) throws StatNotInRangeException;

  StatsInRangeBuilder setMaxAgility(int maxAgility) throws StatNotInRangeException;

  StatsInRangeBuilder setMaxStrength(int maxStrength) throws StatNotInRangeException;
}
