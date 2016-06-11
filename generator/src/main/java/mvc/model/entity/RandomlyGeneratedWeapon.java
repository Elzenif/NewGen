package mvc.model.entity;

import mvc.model.entity.enums.EWeaponType;
import mvc.model.entity.utils.Constraints;
import org.jetbrains.annotations.Contract;

import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
public class RandomlyGeneratedWeapon extends Weapon {

  private final EWeaponType weaponType;

  @Contract("_ -> !null")
  public static RandomlyGeneratedWeapon createWeapon(Constraints constraints) {
    return new WeaponBuilder(constraints).build();
  }

  EWeaponType getWeaponType() {
    return weaponType;
  }

  @Override
  public String toString() {
    return weaponType.toString();
  }

  private RandomlyGeneratedWeapon(WeaponBuilder builder) {
    this.weaponType = builder.weaponType;
    rarity = builder.computeRarity();
  }

  private static class WeaponBuilder extends ItemBuilder {

    private EWeaponType weaponType;

    private WeaponBuilder(Constraints constraints) {
      setWeaponType(constraints.get(EWeaponType.class).getPredicate());
    }

    private void setWeaponType(Predicate<EWeaponType> predicate) {
      weaponType = selectRandomItemType(EWeaponType.values(), predicate);
      rarities.add(weaponType);
    }

    @Contract(" -> !null")
    private RandomlyGeneratedWeapon build() {
      return new RandomlyGeneratedWeapon(this);
    }
  }
}
