package nbk.model.entity.items;

import commons.model.commons.constraints.GenerationConstraints;
import commons.model.commons.constraints.PredicateConstraints;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.utils.EOperator;
import commons.utils.exception.NoAvailableEntityTypeException;
import nbk.model.commons.characteristics.primary.enums.ESize;
import nbk.model.entity.items.characteristics.primary.enums.ENbHands;
import nbk.model.entity.items.characteristics.primary.enums.ERange;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkPredefinedWeapon;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkWeaponType;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 23/06/2016.
 */
public class NbkPredefinedWeaponTest {

  private PredicateConstraints predicateConstraints;
  private NbkPredefinedWeapon weapon;

  @Before
  public void init() {
    predicateConstraints = new GenerationConstraints().getPredicateConstraints();
  }

  @Test
  public void testWeaponIsNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkPredefinedWeapon.create(predicateConstraints);
    assertThat(weapon).isNotNull();
  }

  @Test
  public void testPredefinedWeaponNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkPredefinedWeapon.create(predicateConstraints);
    assertThat(weapon.getPredefinedWeapon()).isNotNull();
  }

  @Test
  public void testPredefinedWeaponIsValid() throws NoAvailableEntityTypeException {
    weapon = NbkPredefinedWeapon.create(predicateConstraints);
    Set<ENbkPredefinedWeapon> weaponTypes = EnumSet.allOf(ENbkPredefinedWeapon.class);
    assertThat(weaponTypes).contains(weapon.getPredefinedWeapon());
  }

  @Test
  public void testWeaponToStringIsNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkPredefinedWeapon.create(predicateConstraints);
    assertThat(weapon.toString()).isNotNull();
  }

  @Test
  public void testWeaponToStringIsValid() throws NoAvailableEntityTypeException {
    weapon = NbkPredefinedWeapon.create(predicateConstraints);
    assertThat(weapon.toString().contains("@")).isFalse();
  }

  @Test
  public void testCreateWeaponWithRarityConstraint() throws NoAvailableEntityTypeException {
    for (EItemRarity rarity : EItemRarity.values()) {
      predicateConstraints.update(ENbkPredefinedWeapon.getConstraints(), EItemRarity.class, rarity);
      weapon = NbkPredefinedWeapon.create(predicateConstraints);
      assertThat(weapon).isNotNull();
      assertThat(EOperator.GTE.apply(weapon.getRarity(), rarity)).isTrue();
      predicateConstraints.update(ENbkPredefinedWeapon.getConstraints(), EItemRarity.class, rarity);
    }
  }

  @Test
  public void testCreateWeaponWithHandsConstraint() throws NoAvailableEntityTypeException {
    for (ENbHands nbHands : ENbHands.values()) {
      predicateConstraints.update(ENbkWeaponType.getConstraints(), ENbHands.class, nbHands);
      weapon = NbkPredefinedWeapon.create(predicateConstraints);
      assertThat(weapon).isNotNull();
      assertThat(weapon.getNbHands()).isEqualTo(nbHands);
      predicateConstraints.update(ENbkWeaponType.getConstraints(), ENbHands.class, nbHands);
    }
  }

  @Test
  public void testCreateWeaponWithRangeConstraint() throws NoAvailableEntityTypeException {
    for (ERange range : ERange.values()) {
      predicateConstraints.update(ENbkWeaponType.getConstraints(), ERange.class, range);
      weapon = NbkPredefinedWeapon.create(predicateConstraints);
      assertThat(weapon).isNotNull();
      assertThat(weapon.getRange()).isEqualTo(range);
      predicateConstraints.update(ENbkWeaponType.getConstraints(), ERange.class, range);
    }
  }

  @Test
  public void testCreateWeaponWithSizeConstraint() throws NoAvailableEntityTypeException {
    for (ESize size : ESize.values()) {
      predicateConstraints.update(ENbkWeaponType.getConstraints(), ESize.class, size);
      weapon = NbkPredefinedWeapon.create(predicateConstraints);
      assertThat(weapon).isNotNull();
      assertThat(weapon.getSize()).isEqualTo(size);
      predicateConstraints.update(ENbkWeaponType.getConstraints(), ESize.class, size);
    }
  }
}
