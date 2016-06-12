package mvc.model.entity.items;

import mvc.model.entity.enums.ENbkWeaponType;
import mvc.model.entity.utils.Constraints;
import org.jetbrains.annotations.Contract;

import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
public class NbkWeapon extends Item {
  
  private final ENbkWeaponType weaponType;

  @Contract("_ -> !null")
  public static NbkWeapon create(Constraints constraints) {
    return new NbkWeapon.WeaponBuilder(constraints).build();
  }

  ENbkWeaponType getWeaponType() {
    return weaponType;
  }

  @Override
  public String toString() {
    return weaponType.toString();
  }

  private NbkWeapon(NbkWeapon.WeaponBuilder builder) {
    this.weaponType = builder.weaponType;
    rarity = builder.computeRarity();
  }

  private static class WeaponBuilder extends ItemBuilder {

    private ENbkWeaponType weaponType;

    private WeaponBuilder(Constraints constraints) {
      setWeaponType(constraints.get(ENbkWeaponType.class).getPredicate());
    }

    private void setWeaponType(Predicate<ENbkWeaponType> predicate) {
      weaponType = selectRandomItemType(ENbkWeaponType.values(), predicate);
      rarities.add(weaponType);
    }

    @Contract(" -> !null")
    private NbkWeapon build() {
      return new NbkWeapon(this);
    }
  }
}
