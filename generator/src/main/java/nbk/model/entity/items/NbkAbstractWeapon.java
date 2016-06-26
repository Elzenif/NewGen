package nbk.model.entity.items;

import commons.model.entity.enums.ERarity;
import commons.model.entity.items.Item;
import nbk.model.entity.enums.ENbkWeaponType;
import nbk.model.entity.game.NbkGame;

/**
 * Created by Germain on 23/06/2016.
 */
public abstract class NbkAbstractWeapon extends Item<NbkGame> {

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
