package nbk.model.entity.items.characteristics.primary.enums;

import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import commons.model.entity.characteristics.primary.Primary;
import nbk.model.entity.items.characteristics.primary.fields.HasRange;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

/**
 * Created by Germain on 14/07/2016.
 */
public enum ERange implements Primary, HasRange, GenericPredicateConstraint<ERange> {

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
