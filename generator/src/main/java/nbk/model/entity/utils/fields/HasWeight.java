package nbk.model.entity.utils.fields;

import nbk.model.entity.enums.EWeight;

/**
 * Created by Germain on 26/06/2016.
 */
@FunctionalInterface
public interface HasWeight {

  EWeight getWeight();
}