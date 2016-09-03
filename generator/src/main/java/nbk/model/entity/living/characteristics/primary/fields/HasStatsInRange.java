package nbk.model.entity.living.characteristics.primary.fields;

import nbk.model.entity.living.characteristics.primary.Stats;

/**
 * Created by Germain on 03/09/2016.
 */
public interface HasStatsInRange {

  Stats getMinStats();

  Stats getMaxStats();

}
