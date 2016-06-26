package nbk.model.entity.items;

import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.enums.EMagic;
import commons.model.entity.enums.ERarity;
import commons.model.entity.utils.ItemUtils;
import commons.utils.exception.NoAvailableItemTypeException;
import nbk.model.entity.enums.ENbkPredefinedWeapon;
import nbk.model.entity.enums.ENbkWeaponType;

import java.util.function.Predicate;

/**
 * Created by Germain on 23/06/2016.
 */
public class NbkPredefinedWeapon extends NbkAbstractWeapon {

  private final ENbkPredefinedWeapon predefinedWeapon;

  public static NbkPredefinedWeapon create(GlobalConstraints globalConstraints, ERarity rarity)
          throws NoAvailableItemTypeException {
    return new PredefinedWeaponBuilder(globalConstraints, rarity).build();
  }

  private NbkPredefinedWeapon(PredefinedWeaponBuilder builder) {
    super(builder);
    predefinedWeapon = builder.predefinedWeapon;
  }

  @Override
  public String toString() {
    return printRandomQuantity() + predefinedWeapon.getName();
  }

  private static class PredefinedWeaponBuilder extends AbstractWeaponBuilder {

    ENbkPredefinedWeapon predefinedWeapon;

    PredefinedWeaponBuilder(GlobalConstraints globalConstraints, ERarity rarity) throws NoAvailableItemTypeException {
      super(rarity);
      setPredefinedWeapon(globalConstraints.getPredicate(ENbkWeaponType.class), rarity);
      weaponType = predefinedWeapon.getWeaponType();
    }

    void setPredefinedWeapon(Predicate<ENbkWeaponType> wtPredicate, ERarity rarity)
            throws NoAvailableItemTypeException {
      predefinedWeapon = ItemUtils.selectRandomRarity(ENbkPredefinedWeapon.values(),
              weapon -> wtPredicate.test(weapon.getWeaponType()), rarity);
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
