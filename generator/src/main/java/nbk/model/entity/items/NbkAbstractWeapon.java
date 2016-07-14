package nbk.model.entity.items;

import commons.model.entity.items.Item;
import nbk.model.entity.characteristics.primary.fields.HasNbHands;
import nbk.model.entity.characteristics.primary.fields.HasRange;
import nbk.model.entity.characteristics.primary.fields.HasSize;
import nbk.model.entity.game.NbkGame;

/**
 * Created by Germain on 23/06/2016.
 */
public abstract class NbkAbstractWeapon extends Item<NbkGame> implements HasNbHands, HasRange, HasSize {

  NbkAbstractWeapon(ItemBuilder builder) {
    super(builder);
  }

}
