package nbk.view.entity.living.options;

import commons.model.entity.IAvailableEntity;
import commons.model.utility.constraints.DrawKeyConstraint;
import commons.utils.MathUtils;
import commons.view.entity.EntityOptionRow;
import nbk.model.commons.NbkGame;

/**
 * Created by Germain on 28/08/2016.
 */
public abstract class NbkLivingOptionRow extends EntityOptionRow<NbkGame, DrawKeyConstraint> {

  protected NbkLivingOptionRow(IAvailableEntity<NbkGame> availableEntity) {
    super(availableEntity, MathUtils.maxLength(NbkGame.getInstance().getAvailableLivings()));
  }
}
