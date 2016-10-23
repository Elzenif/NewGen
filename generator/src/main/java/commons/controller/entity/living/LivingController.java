package commons.controller.entity.living;

import commons.controller.entity.EntityController;
import commons.model.commons.Game;
import commons.model.commons.IDrawKey;
import commons.model.utility.constraints.DrawKeyConstraint;
import commons.view.entity.living.LivingOptionRow;

/**
 * Created by Germain on 23/10/2016.
 */
public abstract class LivingController<G extends Game, K extends IDrawKey> extends EntityController<G, DrawKeyConstraint> {

  protected final LivingOptionRow<G, K> livingOptionRow;

  protected LivingController(LivingOptionRow<G, K> livingOptionRow, DrawKeyConstraint generationConstraint) {
    super(livingOptionRow, generationConstraint);
    this.livingOptionRow = livingOptionRow;
  }
}
