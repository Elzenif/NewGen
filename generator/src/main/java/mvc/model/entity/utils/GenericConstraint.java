package mvc.model.entity.utils;

import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
public class GenericConstraint<E extends Enum<E> & ItemType> {

  private final Predicate<E> predicate;

  public GenericConstraint() {
    predicate = p -> true;
  }

  public GenericConstraint(Predicate<E> predicate) {
    this.predicate = predicate;
  }

  public Predicate<E> getPredicate() {
    return predicate;
  }
}
