package mvc.model.entity.items;

import mvc.model.entity.constraints.GlobalConstraints;
import mvc.model.entity.enums.ENbkQuality;
import mvc.model.entity.enums.ENbkWeaponType;
import mvc.model.entity.game.NbkGame;
import mvc.model.entity.utils.ERarity;
import mvc.model.entity.utils.ItemUtils;
import org.jetbrains.annotations.Contract;
import utils.french.FrenchNoun;

import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
public class NbkWeapon extends Item<NbkGame> {

  private final ENbkWeaponType weaponType;
  private final ENbkQuality quality;

  @Contract("_, _ -> !null")
  public static NbkWeapon create(GlobalConstraints globalConstraints, ERarity rarity) {
    return new NbkWeapon.WeaponBuilder(globalConstraints, rarity).build();
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
    noun.addAdjective(quality.getName());
    return noun.toString();
  }

  private NbkWeapon(NbkWeapon.WeaponBuilder builder) {
    super(builder.rarity);
    this.weaponType = builder.weaponType;
    this.quality = builder.quality;
  }

  private static class WeaponBuilder extends ItemBuilder {

    private ENbkWeaponType weaponType;
    private ENbkQuality quality;

    private WeaponBuilder(GlobalConstraints globalConstraints, ERarity rarity) {
      super(rarity);
      setWeaponType(globalConstraints.getPredicate(ENbkWeaponType.class));
      setQuality(rarity);
    }

    private void setQuality(ERarity rarity) {
      quality = ENbkQuality.qualityMap.get(rarity);
    }

    private void setWeaponType(Predicate<ENbkWeaponType> predicate) {
      weaponType = ItemUtils.selectRandomItemType(ENbkWeaponType.values(), predicate);
    }

    @Contract(" -> !null")
    private NbkWeapon build() {
      return new NbkWeapon(this);
    }
  }
}
