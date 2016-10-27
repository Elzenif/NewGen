package commons.view.entity.living;

import commons.model.commons.Game;
import commons.model.commons.IDrawKey;
import commons.model.entity.living.IAvailableLiving;
import commons.view.commons.options.HasDrawKeysOptionRow;
import commons.view.entity.EntityOptionRow;

import java.util.EnumSet;

/**
 * Created by Germain on 23/10/2016.
 */
public abstract class LivingOptionRow<G extends Game> extends EntityOptionRow<G>
    implements HasDrawKeysOptionRow<IDrawKey> {

  protected LivingOptionRow(IAvailableLiving<G> availableLiving, EnumSet<? extends IAvailableLiving<G>> availableLivings) {
    super(availableLiving, availableLivings);
  }
}
