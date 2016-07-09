package nbk.model.entity.items;

import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.enums.EMagic;
import commons.model.entity.enums.ERarity;
import commons.model.entity.utils.ItemUtils;
import commons.utils.SPositive;
import commons.utils.exception.NoAvailableItemTypeException;
import commons.utils.french.FrenchNoun;
import nbk.model.entity.enums.ENbHands;
import nbk.model.entity.enums.ENbkQuality;
import nbk.model.entity.enums.ENbkWeaponType;
import nbk.model.entity.enums.ESize;
import nbk.model.entity.utils.fields.HasQuality;
import nbk.model.entity.utils.fields.HasWeaponType;
import org.jetbrains.annotations.Contract;

import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
public class NbkRGWeapon extends NbkAbstractWeapon implements HasWeaponType, HasQuality {

  private final ENbkWeaponType weaponType;
  private final ENbkQuality quality;

  @Contract("_, _ -> !null")
  public static NbkRGWeapon create(GlobalConstraints globalConstraints, ERarity rarity)
          throws NoAvailableItemTypeException {
    return new RGWeaponBuilder(globalConstraints, rarity).build();
  }

  @Override
  public ENbkWeaponType getWeaponType() {
    return weaponType;
  }

  @Override
  public ENbkQuality getQuality() {
    return quality;
  }

  @Override
  public boolean isLongRange() {
    return weaponType.isLongRange();
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

    RGWeaponBuilder(GlobalConstraints globalConstraints, ERarity rarity) throws NoAvailableItemTypeException {
      super(rarity);
      setWeaponType(globalConstraints.getPredicate(ENbkWeaponType.class));
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
