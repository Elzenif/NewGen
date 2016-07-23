package commons.controller.entity.items;

import commons.model.commons.Game;
import commons.model.entity.characteristics.primary.Primary;
import commons.model.entity.constraints.GenericConstraint;

import java.awt.event.ActionListener;

/**
 * Created by Germain on 23/07/2016.
 */
public abstract class AbstractConstraintActionListener<T extends Game, E extends Enum<E> & Primary>
        implements ActionListener {

  protected final ItemController<T> itemController;
  protected final GenericConstraint<E> constraint;

  protected AbstractConstraintActionListener(ItemController<T> itemController, GenericConstraint<E> constraint) {
    this.itemController = itemController;
    this.constraint = constraint;
  }
}
