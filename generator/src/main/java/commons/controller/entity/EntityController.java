package commons.controller.entity;

import commons.controller.commons.AbstractOptionRowController;
import commons.controller.entity.items.ConstraintsItemListener;
import commons.model.commons.Game;
import commons.model.commons.GenerationConstraint;
import commons.view.entity.EntityOptionRow;

/**
 * Created by Germain on 23/07/2016.
 */
public abstract class EntityController<G extends Game, GC extends GenerationConstraint>
    extends AbstractOptionRowController<GC> {

  protected EntityController(EntityOptionRow<G, GC> entityOptionRow, GC generationConstraint) {
    super(new ConstraintsItemListener(entityOptionRow), generationConstraint);
  }
}
