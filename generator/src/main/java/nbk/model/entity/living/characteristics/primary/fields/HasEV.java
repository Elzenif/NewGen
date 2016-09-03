package nbk.model.entity.living.characteristics.primary.fields;

import commons.model.entity.characteristics.primary.Primary;
import commons.utils.SPositive;

/**
 * Created by Germain on 29/08/2016.
 */
@FunctionalInterface
public interface HasEV extends Primary {
  SPositive getEV();
}
