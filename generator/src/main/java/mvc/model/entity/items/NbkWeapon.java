package mvc.model.entity.items;

import mvc.model.entity.constraints.GlobalConstraints;
import mvc.model.entity.enums.ENbkWeaponType;
import mvc.model.entity.game.NbkGame;
import org.jetbrains.annotations.Contract;

import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
public class NbkWeapon extends Item<NbkGame> {
  
  private final ENbkWeaponType weaponType;

  @Contract("_ -> !null")
  public static NbkWeapon create(GlobalConstraints globalConstraints) {
    return new NbkWeapon.WeaponBuilder(globalConstraints).build();
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

    private WeaponBuilder(GlobalConstraints globalConstraints) {
      setWeaponType(globalConstraints.getConstraint(ENbkWeaponType.class));
    }

    private void setWeaponType(Predicate predicate) {
      weaponType = selectRandomItemType(ENbkWeaponType.values(), predicate);
      rarities.add(weaponType);
    }

    @Contract(" -> !null")
    private NbkWeapon build() {
      return new NbkWeapon(this);
    }
  }
}
