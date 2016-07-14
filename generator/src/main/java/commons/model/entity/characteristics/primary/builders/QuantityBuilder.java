package commons.model.entity.characteristics.primary.builders;

import commons.model.entity.characteristics.primary.fields.HasQuantity;

/**
 * Created by Germain on 28/06/2016.
 */
public interface QuantityBuilder extends HasQuantity {

  QuantityBuilder setQuantity(int quantity);
}
