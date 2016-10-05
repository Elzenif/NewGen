package nbk.model.entity.living.characteristics.primary.builders;

import nbk.model.entity.living.characteristics.primary.fields.HasStatsInRange;

/**
 * Created by Germain on 03/09/2016.
 */
public interface StatsInRangeBuilder extends HasStatsInRange {

  StatsInRangeBuilder setMinCourage(int minCourage);

  StatsInRangeBuilder setMinIntelligence(int minIntelligence);

  StatsInRangeBuilder setMinCharisma(int minCharisma);

  StatsInRangeBuilder setMinAgility(int minAgility);

  StatsInRangeBuilder setMinStrength(int minStrength);

  StatsInRangeBuilder setMaxCourage(int maxCourage);

  StatsInRangeBuilder setMaxIntelligence(int maxIntelligence);

  StatsInRangeBuilder setMaxCharisma(int maxCharisma);

  StatsInRangeBuilder setMaxAgility(int maxAgility);

  StatsInRangeBuilder setMaxStrength(int maxStrength);
}
