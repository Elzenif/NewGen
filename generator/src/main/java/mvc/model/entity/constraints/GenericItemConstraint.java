package mvc.model.entity.constraints;

import mvc.model.entity.utils.ItemType;

/**
 * Created by Germain on 22/06/2016.
 */
public interface GenericItemConstraint<E extends Enum<E> & ItemType> extends GenericConstraint<E> {

}
