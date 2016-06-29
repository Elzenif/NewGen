package commons.model.entity.constraints;

import commons.model.entity.utils.fields.HasRarity;

import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
@FunctionalInterface
public interface GenericConstraint<E extends Enum<E> & HasRarity> {

  Predicate<E> getPredicate();

  default Predicate<E> alwaysTruePredicate() {
    return p -> true;
  }
}
