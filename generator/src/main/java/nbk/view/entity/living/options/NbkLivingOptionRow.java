package nbk.view.entity.living.options;

import commons.model.commons.IDrawKey;
import commons.model.entity.living.IAvailableLiving;
import commons.view.entity.living.LivingOptionRow;
import nbk.model.commons.NbkGame;

/**
 * Created by Germain on 28/08/2016.
 */
public abstract class NbkLivingOptionRow<K extends IDrawKey> extends LivingOptionRow<NbkGame, K> {

  protected NbkLivingOptionRow(IAvailableLiving<NbkGame> availableLiving) {
    super(availableLiving, NbkGame.getInstance().getAvailableLivings());
  }
}
