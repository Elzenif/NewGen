package commons.model.entity.characteristics.primary.fields;

import commons.utils.SPositive;

/**
 * Created by Germain on 28/06/2016.
 */
@FunctionalInterface
public interface HasQuantity {

  SPositive getQuantity();
}
