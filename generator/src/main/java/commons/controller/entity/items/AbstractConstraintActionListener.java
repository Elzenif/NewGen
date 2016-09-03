package commons.controller.entity.items;

import commons.controller.entity.EntityController;
import commons.model.commons.Game;
import commons.model.entity.characteristics.primary.Primary;
import commons.model.entity.constraints.GenericConstraint;

import java.awt.event.ActionListener;

/**
 * Created by Germain on 23/07/2016.
 */
public abstract class AbstractConstraintActionListener<T extends Game, E extends Primary>
        implements ActionListener {

  protected final EntityController<T> entityController;
  protected final GenericConstraint<E> constraint;

  protected AbstractConstraintActionListener(EntityController<T> entityController, GenericConstraint<E> constraint) {
    this.entityController = entityController;
    this.constraint = constraint;
  }
}
