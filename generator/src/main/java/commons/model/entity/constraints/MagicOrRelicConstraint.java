package commons.model.entity.constraints;

import commons.model.entity.utils.fields.HasMagic;
import commons.model.entity.utils.fields.ItemType;

import java.util.function.Predicate;

/**
 * Created by Germain on 25/06/2016.
 */
public class MagicOrRelicConstraint<E extends Enum<E> & ItemType & HasMagic> implements GenericItemConstraint<E> {

  private final Predicate<E> predicate;

  public MagicOrRelicConstraint(Predicate<E> predicate) {
    this.predicate = predicate;
  }

  @Override
  public Predicate<E> getPredicate() {
    return predicate;
  }
}
