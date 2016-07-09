package nbk.model.entity.items;

import commons.model.entity.items.Item;
import nbk.model.entity.game.NbkGame;
import nbk.model.entity.utils.fields.HasNbHands;
import nbk.model.entity.utils.fields.HasRange;
import nbk.model.entity.utils.fields.HasSize;

/**
 * Created by Germain on 23/06/2016.
 */
public abstract class NbkAbstractWeapon extends Item<NbkGame> implements HasNbHands, HasRange, HasSize {

  NbkAbstractWeapon(ItemBuilder builder) {
    super(builder);
  }

}
