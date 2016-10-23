package commons.controller.entity.living;

import commons.controller.entity.EntityController;
import commons.model.commons.Game;
import commons.model.utility.constraints.DrawKeyConstraint;
import commons.view.entity.EntityOptionRow;

/**
 * Created by Germain on 23/10/2016.
 */
public abstract class LivingController<G extends Game> extends EntityController<G, DrawKeyConstraint> {

  protected LivingController(EntityOptionRow<G, DrawKeyConstraint> entityOptionRow, DrawKeyConstraint generationConstraint) {
    super(entityOptionRow, generationConstraint);
  }
}
