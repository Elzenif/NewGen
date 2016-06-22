package mvc.model.entity.constraints;

import mvc.model.entity.enums.ENbkWeaponType;

import java.util.function.Predicate;

/**
 * Created by Germain on 15/06/2016.
 */
public enum NbkNbHandsConstraint implements GenericItemConstraint<ENbkWeaponType> {

  NO_CONSTRAINT {
    @Override
    public Predicate<ENbkWeaponType> getPredicate() {
      return alwaysTruePredicate();
    }
  },
  ONE_HAND,
  TWO_HANDS;

  @Override
  public Predicate<ENbkWeaponType> getPredicate() {
    return wt -> wt.getNbHands() == ordinal();
  }
}
