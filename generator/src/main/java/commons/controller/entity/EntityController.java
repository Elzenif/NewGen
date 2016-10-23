package commons.controller.entity;

import commons.controller.commons.AbstractOptionRowController;
import commons.controller.entity.items.ConstraintsItemListener;
import commons.model.commons.Game;
import commons.view.entity.EntityOptionRow;

/**
 * Created by Germain on 23/07/2016.
 */
public abstract class EntityController<G extends Game>
    extends AbstractOptionRowController {

  protected EntityController(EntityOptionRow<G> entityOptionRow) {
    super(new ConstraintsItemListener(entityOptionRow));
  }
}
