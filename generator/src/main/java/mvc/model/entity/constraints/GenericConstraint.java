package mvc.model.entity.constraints;

import mvc.model.entity.utils.ItemType;

import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
@FunctionalInterface
public interface GenericConstraint<E extends Enum<E> & ItemType> {

  Predicate<E> getPredicate();

  default Predicate<E> alwaysTruePredicate() {
    return p -> true;
  }
}
