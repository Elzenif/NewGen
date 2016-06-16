package mvc.model.entity.items;

import mvc.model.entity.constraints.GlobalConstraints;
import mvc.model.entity.enums.ENbkQuality;
import mvc.model.entity.enums.ENbkWeaponType;
import mvc.model.entity.game.NbkGame;
import org.jetbrains.annotations.Contract;
import utils.french.FrenchNoun;

import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
public class NbkWeapon extends Item<NbkGame> {
  
  private final ENbkWeaponType weaponType;
  private final ENbkQuality quality;

  @Contract("_ -> !null")
  public static NbkWeapon create(GlobalConstraints globalConstraints) {
    return new NbkWeapon.WeaponBuilder(globalConstraints).build();
  }

  ENbkWeaponType getWeaponType() {
    return weaponType;
  }

  ENbkQuality getQuality() {
    return quality;
  }

  @Override
  public String toString() {
    FrenchNoun noun = weaponType.getName();
    noun.addString(quality.getName().getCorrectForm(noun.getGender()));
    return noun.toString();
  }

  private NbkWeapon(NbkWeapon.WeaponBuilder builder) {
    this.weaponType = builder.weaponType;
    this.quality = builder.quality;
    rarity = builder.computeRarity();
  }

  private static class WeaponBuilder extends ItemBuilder {

    private ENbkWeaponType weaponType;
    private ENbkQuality quality;

    private WeaponBuilder(GlobalConstraints globalConstraints) {
      setWeaponType(globalConstraints.getPredicate(ENbkWeaponType.class));
      setQuality(globalConstraints.getPredicate(ENbkQuality.class));
    }

    private void setQuality(Predicate<ENbkQuality> predicate) {
      quality = selectRandomItemType(ENbkQuality.values(), predicate);
      rarities.add(quality);
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
