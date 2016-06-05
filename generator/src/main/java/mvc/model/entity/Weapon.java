package mvc.model.entity;

import mvc.model.entity.enums.WeaponType;

import java.util.function.Predicate;

/**
 * Created by Germain on 04/06/2016.
 */
public class Weapon extends Item {

  private final WeaponType weaponType;

  public static Weapon createWeaponWithoutConstraints() {
    return new WeaponBuilder().build();
  }

  public static Weapon createWeapon(int nbHands) {
    return new WeaponBuilder().setWeaponType(p -> p.getNbHands() == nbHands).build();
  }

  WeaponType getWeaponType() {
    return weaponType;
  }

  @Override
  public String toString() {
    return "Weapon : " + weaponType;
  }

  private Weapon(WeaponBuilder builder) {
    this.weaponType = builder.weaponType;
  }

  private static class WeaponBuilder extends ItemBuilder {

    private WeaponType weaponType = null;

    private WeaponBuilder() {
    }

    private WeaponBuilder setWeaponType(Predicate<WeaponType> predicate) {
      this.weaponType = selectRandomItemType(WeaponType.values(), predicate);
      return this;
    }

    private Weapon build() {
      if (weaponType == null)
        setWeaponType(p -> true);
      return new Weapon(this);
    }
  }
}
