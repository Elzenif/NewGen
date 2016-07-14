package nbk.model.entity.constraints;

import commons.model.entity.characteristics.primary.fields.ItemType;
import commons.model.entity.constraints.AbstractConstraints;
import commons.model.entity.constraints.GenericItemConstraint;
import nbk.model.entity.characteristics.primary.enums.ESize;
import nbk.model.entity.characteristics.primary.fields.HasSize;

/**
 * Created by Germain on 14/07/2016.
 */
public class SizeConstraint<E extends Enum<E> & ItemType & HasSize> extends AbstractConstraints<E> {

  public final GenericItemConstraint<E> SMALL_SIZE = () -> e -> e.getSize() == ESize.SMALL;

  public final GenericItemConstraint<E> NORMAL_SIZE = () -> e -> e.getSize() == ESize.NORMAL;

  public final GenericItemConstraint<E> LARGE_SIZE = () -> e -> e.getSize() == ESize.LARGE;

  public SizeConstraint(Class<E> clazz) {
    super(clazz);
  }
}
