package commons.model.entity.utils.builders;

import commons.model.entity.utils.fields.HasQuantity;

/**
 * Created by Germain on 28/06/2016.
 */
public interface QuantityBuilder extends HasQuantity {

  QuantityBuilder setQuantity(int quantity);
}
