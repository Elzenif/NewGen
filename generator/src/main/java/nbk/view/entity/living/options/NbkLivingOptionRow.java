package nbk.view.entity.living.options;

import commons.model.entity.IAvailableEntity;
import nbk.model.commons.NbkGame;
import nbk.view.entity.options.NbkEntityOptionRow;

/**
 * Created by Germain on 28/08/2016.
 */
public abstract class NbkLivingOptionRow extends NbkEntityOptionRow {

  protected NbkLivingOptionRow(IAvailableEntity<NbkGame> availableEntity) {
    super(availableEntity, NbkGame.getInstance().getAvailableLivings());
  }
}
