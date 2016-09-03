package nbk.model.entity.living.characteristics.primary.fields;

import commons.model.entity.characteristics.primary.Primary;
import nbk.model.entity.living.characteristics.primary.Stats;

/**
 * Created by Germain on 29/08/2016.
 */
public interface HasStats extends Primary {

  Stats getStats();
}
