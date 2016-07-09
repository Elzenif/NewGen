package commons.model.entity.constraints;

import commons.model.entity.utils.fields.HasRarity;

import java.util.Objects;

/**
 * Created by Germain on 02/07/2016.
 */
public abstract class AbstractConstraints<E extends Enum<E> & HasRarity> {

  public final GenericConstraint<E> NO_CONSTRAINT = () -> e -> true;

  private final Class<E> clazz;

  protected AbstractConstraints(Class<E> clazz) {
    this.clazz = clazz;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractConstraints<?> that = (AbstractConstraints<?>) o;
    return Objects.equals(clazz, that.clazz);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clazz);
  }
}
