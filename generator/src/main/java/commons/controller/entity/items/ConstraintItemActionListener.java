package commons.controller.entity.items;

import commons.model.commons.Game;
import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import commons.model.entity.characteristics.primary.Primary;

import java.awt.event.ActionListener;

/**
 * Created by Germain on 23/07/2016.
 */
public abstract class ConstraintItemActionListener<G extends Game, E extends Primary>
        implements ActionListener {

  protected final ItemController<G> entityController;
  protected final GenericPredicateConstraint<E> constraint;

  protected ConstraintItemActionListener(ItemController<G> entityController, GenericPredicateConstraint<E> constraint) {
    this.entityController = entityController;
    this.constraint = constraint;
  }
}
