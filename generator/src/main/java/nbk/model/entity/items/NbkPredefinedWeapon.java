package nbk.model.entity.items;

import commons.model.commons.constraints.PredicateConstraints;
import commons.model.entity.characteristics.primary.enums.EMagic;
import commons.model.entity.utils.EntityUtils;
import commons.utils.SPositive;
import commons.utils.exception.NoAvailableEntityTypeException;
import nbk.model.commons.characteristics.primary.enums.ESize;
import nbk.model.entity.items.characteristics.primary.enums.ENbHands;
import nbk.model.entity.items.characteristics.primary.enums.ERange;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkPredefinedWeapon;

import java.util.function.Predicate;

/**
 * Created by Germain on 23/06/2016.
 */
public class NbkPredefinedWeapon extends NbkAbstractWeapon {

  private final ENbkPredefinedWeapon predefinedWeapon;

  private NbkPredefinedWeapon(PredefinedWeaponBuilder builder) {
    super(builder);
    predefinedWeapon = builder.predefinedWeapon;
  }

  public static NbkPredefinedWeapon create(PredicateConstraints predicateConstraints)
      throws NoAvailableEntityTypeException {
    return new PredefinedWeaponBuilder(predicateConstraints).build();
  }

  ENbkPredefinedWeapon getPredefinedWeapon() {
    return predefinedWeapon;
  }

  @Override
  public ERange getRange() {
    return predefinedWeapon.getRange();
  }

  @Override
  public ENbHands getNbHands() {
    return predefinedWeapon.getNbHands();
  }

  @Override
  public ESize getSize() {
    return predefinedWeapon.getSize();
  }

  @Override
  public String toString() {
    return printRandomQuantity() + predefinedWeapon.getName();
  }


  private static class PredefinedWeaponBuilder extends ItemBuilder {

    ENbkPredefinedWeapon predefinedWeapon;

    PredefinedWeaponBuilder(PredicateConstraints predicateConstraints) throws NoAvailableEntityTypeException {
      setPredefinedWeapon(getPredicate(predicateConstraints));
      rarity = predefinedWeapon.getRarity();
    }

    Predicate<ENbkPredefinedWeapon> getPredicate(PredicateConstraints predicateConstraints) {
      return ENbkPredefinedWeapon.getPredicate(predicateConstraints);
    }

    void setPredefinedWeapon(Predicate<ENbkPredefinedWeapon> weaponPredicate) throws NoAvailableEntityTypeException {
      predefinedWeapon = EntityUtils.selectRandomRarity(ENbkPredefinedWeapon.values(), weaponPredicate);
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
