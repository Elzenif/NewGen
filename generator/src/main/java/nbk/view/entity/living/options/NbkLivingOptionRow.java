package nbk.view.entity.living.options;

import commons.model.entity.living.IAvailableLiving;
import commons.view.entity.living.LivingOptionRow;
import nbk.model.commons.NbkGame;

/**
 * Created by Germain on 28/08/2016.
 */
public abstract class NbkLivingOptionRow extends LivingOptionRow<NbkGame> {

  protected NbkLivingOptionRow(IAvailableLiving<NbkGame> availableLiving) {
    super(availableLiving, NbkGame.getInstance().getAvailableLivings());
  }
}
