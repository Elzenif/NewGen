package nbk.model.entity.items.characteristics.primary.enums;

import commons.model.entity.characteristics.primary.Primary;
import commons.model.entity.constraints.GenericConstraint;
import nbk.model.entity.items.characteristics.primary.fields.HasWeight;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

/**
 * Created by Germain on 26/06/2016.
 */
public enum EWeight implements Primary, HasWeight, GenericConstraint<EWeight> {

  LIGHT,
  NORMAL,
  HEAVY;


  @Contract(pure = true)
  @Override
  public EWeight getWeight() {
    return this;
  }


  @NotNull
  @Contract(pure = true)
  @Override
  public Predicate<EWeight> getPredicate() {
    return e -> e.getWeight() == this;
  }
}
