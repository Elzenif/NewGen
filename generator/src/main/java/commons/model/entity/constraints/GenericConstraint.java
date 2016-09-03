package commons.model.entity.constraints;

import commons.model.entity.characteristics.primary.Primary;

import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
@FunctionalInterface
public interface GenericConstraint<E extends Primary> {

  Predicate<E> getPredicate();
}
