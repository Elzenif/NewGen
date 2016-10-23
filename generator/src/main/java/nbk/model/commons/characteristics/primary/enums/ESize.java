package nbk.model.commons.characteristics.primary.enums;

import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import commons.model.entity.characteristics.primary.Primary;
import nbk.model.commons.characteristics.primary.fields.HasSize;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

/**
 * Created by Germain on 26/06/2016.
 */
public enum ESize implements Primary, HasSize, GenericPredicateConstraint<ESize> {
  SMALL,
  MEDIUM,
  LARGE;

  @Contract(pure = true)
  @Override
  public ESize getSize() {
    return this;
  }

  @NotNull
  @Contract(pure = true)
  @Override
  public Predicate<ESize> getPredicate() {
    return e -> e.getSize() == this;
  }
}
