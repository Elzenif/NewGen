package commons.model.commons.constraints;

import commons.model.entity.characteristics.primary.Primary;
import commons.model.entity.characteristics.secondary.Secondary;
import org.jetbrains.annotations.Contract;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Germain on 02/07/2016.
 */
public class PrimarySecondaryConstraints<E extends Secondary> {

  private final Class<E> secondaryClass;
  private final Set<Class<? extends Primary>> primaryClasses;

  @SuppressWarnings("unchecked")
  private PrimarySecondaryConstraints(ConstraintsBuilder builder) {
    this.secondaryClass = (Class<E>) builder.secondaryClass;
    this.primaryClasses = builder.primaryClasses;
  }

  public Class<E> getSecondaryClass() {
    return secondaryClass;
  }

  public Set<Class<? extends Primary>> getPrimaryClasses() {
    return primaryClasses;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PrimarySecondaryConstraints<?> that = (PrimarySecondaryConstraints<?>) o;
    return Objects.equals(secondaryClass, that.secondaryClass);
  }

  @Override
  public int hashCode() {
    return Objects.hash(secondaryClass);
  }

  public static class ConstraintsBuilder<E extends Secondary> {

    private final Set<Class> primaryClasses = new HashSet<>();
    private Class<? extends Secondary> secondaryClass;

    @Contract(" -> !null")
    public static <F extends Secondary> ConstraintsBuilder<F> start() {
      return new ConstraintsBuilder<>();
    }

    public ConstraintsBuilder<E> setSecondaryClass(Class<E> secondaryClass) {
      this.secondaryClass = secondaryClass;
      return this;
    }

    public ConstraintsBuilder<E> setPrimaryClasses(Class... primaryClasses) {
      Collections.addAll(this.primaryClasses, primaryClasses);
      return this;
    }

    public PrimarySecondaryConstraints<E> build() {
      if (secondaryClass == null || primaryClasses.size() == 0)
        throw new IllegalArgumentException("Missing class when building constraints");
      return new PrimarySecondaryConstraints<>(this);
    }
  }
}
