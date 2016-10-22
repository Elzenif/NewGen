package nbk.model.entity.items;

import commons.model.entity.items.Item;
import nbk.model.commons.NbkGame;
import nbk.model.commons.characteristics.primary.fields.HasSize;
import nbk.model.entity.items.characteristics.primary.fields.HasNbHands;
import nbk.model.entity.items.characteristics.primary.fields.HasRange;

/**
 * Created by Germain on 23/06/2016.
 */
public abstract class NbkAbstractWeapon extends Item<NbkGame> implements HasNbHands, HasRange, HasSize {

  NbkAbstractWeapon(ItemBuilder builder) {
    super(builder);
  }

}
