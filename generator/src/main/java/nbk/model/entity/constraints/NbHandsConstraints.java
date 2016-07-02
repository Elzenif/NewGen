package nbk.model.entity.constraints;

import commons.model.entity.constraints.AbstractConstraints;
import commons.model.entity.constraints.GenericItemConstraint;
import commons.model.entity.utils.fields.ItemType;
import nbk.model.entity.enums.ENbHands;
import nbk.model.entity.utils.fields.HasNbHands;

/**
 * Created by Germain on 15/06/2016.
 */
public class NbHandsConstraints<E extends Enum<E> & ItemType & HasNbHands> extends AbstractConstraints<E> {

  private final GenericItemConstraint<E> oneHand = () -> e -> e.getNbHands() == ENbHands.ONE;

  private final GenericItemConstraint<E> twoHands = () -> e -> e.getNbHands() == ENbHands.TWO;

  public NbHandsConstraints(Class<E> clazz) {
    super(clazz);
  }

  public GenericItemConstraint<E> getOneHand() {
    return oneHand;
  }

  public GenericItemConstraint<E> getTwoHands() {
    return twoHands;
  }
}
