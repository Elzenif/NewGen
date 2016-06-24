package nbk.model.entity.items;

import commons.model.entity.game.Game;
import commons.model.entity.items.Item;
import commons.model.entity.utils.ERarity;
import nbk.model.entity.enums.ENbkWeaponType;

/**
 * Created by Germain on 23/06/2016.
 */
abstract class NbkAbstractWeapon extends Item<Game> {

  final ENbkWeaponType weaponType;

  NbkAbstractWeapon(AbstractWeaponBuilder builder) {
    super(builder);
    this.weaponType = builder.weaponType;
  }

  ENbkWeaponType getWeaponType() {
    return weaponType;
  }


  static abstract class AbstractWeaponBuilder extends ItemBuilder {

    ENbkWeaponType weaponType;

    AbstractWeaponBuilder(ERarity rarity) {
      super(rarity);
    }

    @Override
    public int getQuantity() {
      return weaponType.getQuantity();
    }
  }
}
