package commons.controller.entity.living;

import commons.controller.entity.EntityController;
import commons.model.commons.Game;
import commons.view.entity.living.LivingOptionRow;

/**
 * Created by Germain on 23/10/2016.
 */
public abstract class LivingController<G extends Game> extends EntityController<G> {

  protected final LivingOptionRow<G> livingOptionRow;

  protected LivingController(LivingOptionRow<G> livingOptionRow) {
    super(livingOptionRow);
    this.livingOptionRow = livingOptionRow;
  }
}
