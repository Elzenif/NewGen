package commons.model.entity.characteristics.primary.enums;

import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import commons.model.entity.characteristics.primary.Primary;
import commons.model.entity.characteristics.primary.fields.HasRarity;

/**
 * Created by Germain on 29/08/2016.
 */
public interface IRarity<E extends IRarity<E>>
    extends Primary, HasRarity, GenericPredicateConstraint<E>, Comparable<E> {

  int getProba();
}
