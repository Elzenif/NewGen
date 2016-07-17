package nbk.model.entity.characteristics.primary.enums;

import commons.model.entity.characteristics.primary.Primary;
import commons.model.entity.constraints.GenericConstraint;
import nbk.model.entity.characteristics.primary.fields.HasRange;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

/**
 * Created by Germain on 14/07/2016.
 */
public enum ERange implements Primary, HasRange, GenericConstraint<ERange> {

  CLOSE,
  LONG;

  @Contract(pure = true)
  @Override
  public ERange getRange() {
    return this;
  }

  @NotNull
  @Contract(pure = true)
  @Override
  public Predicate<ERange> getPredicate() {
    return e -> e.getRange() == this;
  }
}
