package nbk.model.entity.constraints;

import commons.model.entity.characteristics.primary.fields.ItemType;
import commons.model.entity.constraints.AbstractConstraints;
import commons.model.entity.constraints.GenericItemConstraint;
import nbk.model.entity.characteristics.primary.enums.ERange;
import nbk.model.entity.characteristics.primary.fields.HasRange;

/**
 * Created by Germain on 14/07/2016.
 */
public class RangeConstraint<E extends Enum<E> & ItemType & HasRange> extends AbstractConstraints<E> {


  public final GenericItemConstraint<E> CLOSE_RANGE = () -> e -> e.getRange() == ERange.CLOSE;

  public final GenericItemConstraint<E> LONG_RANGE = () -> e -> e.getRange() == ERange.LONG;

  public RangeConstraint(Class<E> clazz) {
    super(clazz);
  }
}
