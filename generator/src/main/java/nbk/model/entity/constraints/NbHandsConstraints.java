package nbk.model.entity.constraints;

import commons.model.entity.characteristics.primary.fields.ItemType;
import commons.model.entity.constraints.AbstractConstraints;
import commons.model.entity.constraints.GenericItemConstraint;
import nbk.model.entity.characteristics.primary.enums.ENbHands;
import nbk.model.entity.characteristics.primary.fields.HasNbHands;

/**
 * Created by Germain on 15/06/2016.
 */
public class NbHandsConstraints<E extends Enum<E> & ItemType & HasNbHands> extends AbstractConstraints<E> {

  public final GenericItemConstraint<E> ONE_HAND = () -> e -> e.getNbHands() == ENbHands.ONE;

  public final GenericItemConstraint<E> TWO_HANDS = () -> e -> e.getNbHands() == ENbHands.TWO;

  public NbHandsConstraints(Class<E> clazz) {
    super(clazz);
  }

}
