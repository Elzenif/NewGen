package nbk.model.entity.characteristics.primary.fields;

import nbk.model.entity.characteristics.primary.enums.EWeight;

/**
 * Created by Germain on 26/06/2016.
 */
@FunctionalInterface
public interface HasWeight {

  EWeight getWeight();
}
