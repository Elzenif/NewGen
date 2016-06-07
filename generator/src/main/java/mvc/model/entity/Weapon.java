package mvc.model.entity;

import mvc.model.entity.enums.EWeaponType;
import mvc.model.entity.utils.ERarity;

import java.util.function.Predicate;

/**
 * Created by Germain on 04/06/2016.
 */
public class Weapon extends Item {

  private final EWeaponType weaponType;

  public static Weapon createWeaponWithoutConstraints() {
    return new WeaponBuilder().build();
  }

  public static Weapon createWeapon(int nbHands) {
    return new WeaponBuilder().setWeaponType(p -> p.getNbHands() == nbHands).build();
  }

  EWeaponType getWeaponType() {
    return weaponType;
  }

  @Override
  public String toString() {
    return weaponType.toString();
  }

  private Weapon(WeaponBuilder builder) {
    this.weaponType = builder.weaponType;
    rarities.add(weaponType);
    rarity = ERarity.computeRarity(rarities);
  }

  private static class WeaponBuilder extends ItemBuilder {

    private EWeaponType weaponType = null;

    private WeaponBuilder() {
    }

    private WeaponBuilder setWeaponType(Predicate<EWeaponType> predicate) {
      this.weaponType = selectRandomItemType(EWeaponType.values(), predicate);
      return this;
    }

    private Weapon build() {
      if (weaponType == null)
        setWeaponType(p -> true);
      return new Weapon(this);
    }
  }
}
