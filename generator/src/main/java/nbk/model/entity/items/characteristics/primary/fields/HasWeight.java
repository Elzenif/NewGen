package nbk.model.entity.items.characteristics.primary.fields;

import nbk.model.entity.items.characteristics.primary.enums.EWeight;

/**
 * Created by Germain on 26/06/2016.
 */
@FunctionalInterface
public interface HasWeight {

  EWeight getWeight();
}
