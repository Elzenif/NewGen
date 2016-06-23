package commons.model.entity.constraints;

import commons.model.entity.utils.ItemType;

/**
 * Created by Germain on 22/06/2016.
 */
public interface GenericItemConstraint<E extends Enum<E> & ItemType> extends GenericConstraint<E> {

}
