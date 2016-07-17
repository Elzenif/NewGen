package nbk.model.entity.items;

import commons.model.entity.characteristics.primary.enums.EMagic;
import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.utils.ItemUtils;
import commons.utils.SPositive;
import commons.utils.exception.NoAvailableItemTypeException;
import nbk.model.entity.characteristics.primary.enums.ENbHands;
import nbk.model.entity.characteristics.primary.enums.ERange;
import nbk.model.entity.characteristics.primary.enums.ESize;
import nbk.model.entity.characteristics.secondary.enums.ENbkPredefinedWeapon;

import java.util.function.Predicate;

/**
 * Created by Germain on 23/06/2016.
 */
public class NbkPredefinedWeapon extends NbkAbstractWeapon {

  private final ENbkPredefinedWeapon predefinedWeapon;

  public static NbkPredefinedWeapon create(GlobalConstraints globalConstraints)
          throws NoAvailableItemTypeException {
    return new PredefinedWeaponBuilder(globalConstraints).build();
  }

  public static NbkPredefinedWeapon create(GlobalConstraints globalConstraints, ERarity rarity)
          throws NoAvailableItemTypeException {
    return new PredefinedWeaponBuilder(globalConstraints, rarity).build();
  }

  private NbkPredefinedWeapon(PredefinedWeaponBuilder builder) {
    super(builder);
    predefinedWeapon = builder.predefinedWeapon;
  }

  ENbkPredefinedWeapon getPredefinedWeapon() {
    return predefinedWeapon;
  }

  @Override
  public ERange getRange() {
    return predefinedWeapon.getWeaponType().getRange();
  }

  @Override
  public ENbHands getNbHands() {
    return predefinedWeapon.getWeaponType().getNbHands();
  }

  @Override
  public ESize getSize() {
    return predefinedWeapon.getWeaponType().getSize();
  }

  @Override
  public String toString() {
    return printRandomQuantity() + predefinedWeapon.getName();
  }


  private static class PredefinedWeaponBuilder extends ItemBuilder {

    ENbkPredefinedWeapon predefinedWeapon;

    PredefinedWeaponBuilder(GlobalConstraints globalConstraints) throws NoAvailableItemTypeException {
      setPredefinedWeapon(getPredicate(globalConstraints));
      rarity = predefinedWeapon.getRarity();
    }

    PredefinedWeaponBuilder(GlobalConstraints globalConstraints, ERarity rarity) throws NoAvailableItemTypeException {
      super(rarity);
      setPredefinedWeapon(getPredicate(globalConstraints), rarity);
    }

    Predicate<ENbkPredefinedWeapon> getPredicate(GlobalConstraints globalConstraints) {
      return ENbkPredefinedWeapon.getPredicate(globalConstraints);
    }

    void setPredefinedWeapon(Predicate<ENbkPredefinedWeapon> weaponPredicate) throws NoAvailableItemTypeException {
      predefinedWeapon = ItemUtils.selectRandomRarity(ENbkPredefinedWeapon.values(), weaponPredicate);
    }

    void setPredefinedWeapon(Predicate<ENbkPredefinedWeapon> weaponPredicate, ERarity rarity)
            throws NoAvailableItemTypeException {
      predefinedWeapon = ItemUtils.selectRandomRarity(ENbkPredefinedWeapon.values(), weaponPredicate, rarity);
    }

    @Override
    public SPositive getQuantity() {
      return predefinedWeapon.getWeaponType().getQuantity();
    }

    @Override
    public EMagic getMagic() {
      return predefinedWeapon.getMagic();
    }

    @Override
    protected NbkPredefinedWeapon build() {
      return new NbkPredefinedWeapon(this);
    }
  }

}
