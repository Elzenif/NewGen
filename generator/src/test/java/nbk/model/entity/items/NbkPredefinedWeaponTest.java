package nbk.model.entity.items;

import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.constraints.GlobalConstraints;
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

  private GlobalConstraints globalConstraints;
  private NbkPredefinedWeapon weapon;

  @Before
  public void init() {
    globalConstraints = new GlobalConstraints();
  }

  @Test
  public void testWeaponIsNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkPredefinedWeapon.create(globalConstraints);
    assertThat(weapon).isNotNull();
  }

  @Test
  public void testPredefinedWeaponNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkPredefinedWeapon.create(globalConstraints);
    assertThat(weapon.getPredefinedWeapon()).isNotNull();
  }

  @Test
  public void testPredefinedWeaponIsValid() throws NoAvailableEntityTypeException {
    weapon = NbkPredefinedWeapon.create(globalConstraints);
    Set<ENbkPredefinedWeapon> weaponTypes = EnumSet.allOf(ENbkPredefinedWeapon.class);
    assertThat(weaponTypes).contains(weapon.getPredefinedWeapon());
  }

  @Test
  public void testWeaponToStringIsNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkPredefinedWeapon.create(globalConstraints);
    assertThat(weapon.toString()).isNotNull();
  }

  @Test
  public void testWeaponToStringIsValid() throws NoAvailableEntityTypeException {
    weapon = NbkPredefinedWeapon.create(globalConstraints);
    assertThat(weapon.toString().contains("@")).isFalse();
  }

  @Test
  public void testCreateWeaponWithRarityConstraint() throws NoAvailableEntityTypeException {
    for (EItemRarity rarity : EItemRarity.values()) {
      globalConstraints.update(ENbkPredefinedWeapon.getConstraints(), EItemRarity.class, rarity);
      weapon = NbkPredefinedWeapon.create(globalConstraints);
      assertThat(weapon).isNotNull();
      assertThat(EOperator.GTE.apply(weapon.getRarity(), rarity)).isTrue();
      globalConstraints.update(ENbkPredefinedWeapon.getConstraints(), EItemRarity.class, rarity);
    }
  }

  @Test
  public void testCreateWeaponWithHandsConstraint() throws NoAvailableEntityTypeException {
    for (ENbHands nbHands : ENbHands.values()) {
      globalConstraints.update(ENbkWeaponType.getConstraints(), ENbHands.class, nbHands);
      weapon = NbkPredefinedWeapon.create(globalConstraints);
      assertThat(weapon).isNotNull();
      assertThat(weapon.getNbHands()).isEqualTo(nbHands);
      globalConstraints.update(ENbkWeaponType.getConstraints(), ENbHands.class, nbHands);
    }
  }

  @Test
  public void testCreateWeaponWithRangeConstraint() throws NoAvailableEntityTypeException {
    for (ERange range : ERange.values()) {
      globalConstraints.update(ENbkWeaponType.getConstraints(), ERange.class, range);
      weapon = NbkPredefinedWeapon.create(globalConstraints);
      assertThat(weapon).isNotNull();
      assertThat(weapon.getRange()).isEqualTo(range);
      globalConstraints.update(ENbkWeaponType.getConstraints(), ERange.class, range);
    }
  }

  @Test
  public void testCreateWeaponWithSizeConstraint() throws NoAvailableEntityTypeException {
    for (ESize size : ESize.values()) {
      globalConstraints.update(ENbkWeaponType.getConstraints(), ESize.class, size);
      weapon = NbkPredefinedWeapon.create(globalConstraints);
      assertThat(weapon).isNotNull();
      assertThat(weapon.getSize()).isEqualTo(size);
      globalConstraints.update(ENbkWeaponType.getConstraints(), ESize.class, size);
    }
  }
}
