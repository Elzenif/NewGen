package nbk.model.entity.items;

import commons.model.entity.characteristics.primary.enums.EMagic;
import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.utils.ItemUtils;
import commons.utils.SPositive;
import commons.utils.exception.NoAvailableItemTypeException;
import commons.utils.french.FrenchNoun;
import nbk.model.entity.characteristics.primary.enums.ENbHands;
import nbk.model.entity.characteristics.primary.enums.ERange;
import nbk.model.entity.characteristics.primary.enums.ESize;
import nbk.model.entity.characteristics.secondary.enums.ENbkQuality;
import nbk.model.entity.characteristics.secondary.enums.ENbkWeaponType;
import org.jetbrains.annotations.Contract;

import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
public class NbkRGWeapon extends NbkAbstractWeapon {

  private final ENbkWeaponType weaponType;
  private final ENbkQuality quality;

  @Contract("_ -> !null")
  public static NbkRGWeapon create(GlobalConstraints globalConstraints)
          throws NoAvailableItemTypeException {
    return new RGWeaponBuilder(globalConstraints).build();
  }

  @Contract("_, _ -> !null")
  public static NbkRGWeapon create(GlobalConstraints globalConstraints, ERarity rarity)
          throws NoAvailableItemTypeException {
    return new RGWeaponBuilder(globalConstraints, rarity).build();
  }

  public ENbkWeaponType getWeaponType() {
    return weaponType;
  }

  public ENbkQuality getQuality() {
    return quality;
  }

  @Override
  public ERange getRange() {
    return weaponType.getRange();
  }

  @Override
  public ENbHands getNbHands() {
    return weaponType.getNbHands();
  }

  @Override
  public ESize getSize() {
    return weaponType.getSize();
  }

  @Override
  public String toString() {
    FrenchNoun noun = weaponType.getName();
    noun.addAdjective(quality.getName());
    return printRandomQuantity() + noun.toString();
  }

  private NbkRGWeapon(RGWeaponBuilder builder) {
    super(builder);
    this.weaponType = builder.weaponType;
    this.quality = builder.quality;
  }


  private static class RGWeaponBuilder extends ItemBuilder {

    ENbkWeaponType weaponType;
    ENbkQuality quality;

    RGWeaponBuilder(GlobalConstraints globalConstraints) throws NoAvailableItemTypeException {
      setWeaponType(ENbkWeaponType.getPredicate(globalConstraints));
      rarity = ItemUtils.selectRandomRarity(ERarity.values());
      setQuality(rarity);
    }

    RGWeaponBuilder(GlobalConstraints globalConstraints, ERarity rarity) throws NoAvailableItemTypeException {
      super(rarity);
      setWeaponType(ENbkWeaponType.getPredicate(globalConstraints));
      setQuality(rarity);
    }

    void setWeaponType(Predicate<ENbkWeaponType> predicate) throws NoAvailableItemTypeException {
      weaponType = ItemUtils.selectRandomRarity(ENbkWeaponType.values(), predicate);
    }

    void setQuality(ERarity rarity) {
      quality = ENbkQuality.QUALITY_MAP.get(rarity);
    }

    @Override
    public SPositive getQuantity() {
      return weaponType.getQuantity();
    }

    @Override
    public EMagic getMagic() {
      return EMagic.NOPE;
    }

    @Contract(" -> !null")
    protected NbkRGWeapon build() {
      return new NbkRGWeapon(this);
    }
  }
}
