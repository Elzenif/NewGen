package commons.model.entity.characteristics.primary.enums;

import commons.model.entity.characteristics.primary.Primary;
import commons.model.entity.characteristics.primary.fields.HasRarity;
import commons.model.entity.constraints.GenericConstraint;

/**
 * Created by Germain on 29/08/2016.
 */
public interface IRarity<E extends IRarity<E>>
        extends Primary, HasRarity, GenericConstraint<E>, Comparable<E> {

  int getProba();
}
