package commons.view.entity.living;

import commons.model.commons.Game;
import commons.model.commons.IDrawKey;
import commons.model.entity.living.IAvailableLiving;
import commons.model.utility.constraints.DrawKeyConstraint;
import commons.view.commons.options.HasDrawKeysOptionRow;
import commons.view.entity.EntityOptionRow;

import java.util.EnumSet;

/**
 * Created by Germain on 23/10/2016.
 */
public abstract class LivingOptionRow<G extends Game, K extends IDrawKey> extends EntityOptionRow<G, DrawKeyConstraint>
    implements HasDrawKeysOptionRow<K> {

  protected LivingOptionRow(IAvailableLiving<G> availableLiving, EnumSet<? extends IAvailableLiving<G>> availableLivings) {
    super(availableLiving, availableLivings);
  }
}
