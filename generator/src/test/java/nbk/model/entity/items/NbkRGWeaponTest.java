package nbk.model.entity.items;

import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.characteristics.primary.enums.EMagic;
import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.EOperator;
import commons.utils.exception.NoAvailableEntityTypeException;
import nbk.model.entity.items.characteristics.primary.enums.ENbHands;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkQuality;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkWeaponType;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 04/06/2016.
 */
public class NbkRGWeaponTest {

  private GlobalConstraints globalConstraints;
  private NbkRGWeapon weapon;

  @Before
  public void init() {
    globalConstraints = new GlobalConstraints();
  }

  @Test
  public void testWeaponNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    assertThat(weapon).isNotNull();
  }

  @Test
  public void testWeaponTypeNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    assertThat(weapon.getWeaponType()).isNotNull();
  }

  @Test
  public void testWeaponTypeIsValid() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    Set<ENbkWeaponType> weaponTypes = new HashSet<>(Arrays.asList(ENbkWeaponType.values()));
    assertThat(weaponTypes).contains(weapon.getWeaponType());
  }

  @Test
  public void testWeaponQualityIsNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    assertThat(weapon.getQuality()).isNotNull();
  }

  @Test
  public void testWeaponQualityIsValid() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    Set<ENbkQuality> qualities = new HashSet<>(Arrays.asList(ENbkQuality.values()));
    assertThat(qualities).contains(weapon.getQuality());
  }

  @Test
  public void testWeaponMagicIsNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    assertThat(weapon.getMagic()).isNotNull();
  }

  @Test
  public void testWeaponMagicIsValid() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    Set<EMagic> qualities = new HashSet<>(Arrays.asList(EMagic.values()));
    assertThat(qualities).contains(weapon.getMagic());
  }

  @Test
  public void testWeaponToStringIsNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    assertThat(weapon.toString()).isNotNull();
  }

  @Test
  public void testWeaponToStringIsValid() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    assertThat(weapon.toString().contains("@")).isFalse();
  }

  @Test
  public void testCreateWeaponWithRarityConstraint() throws NoAvailableEntityTypeException {
    for (EItemRarity rarity : EItemRarity.values()) {
      globalConstraints.update(ENbkQuality.getConstraints(), EItemRarity.class, rarity);
      weapon = NbkRGWeapon.create(globalConstraints);
      assertThat(weapon).isNotNull();
      assertThat(  EOperator.GTE.apply(weapon.getRarity(), rarity)).isTrue();
      globalConstraints.update(ENbkQuality.getConstraints(), EItemRarity.class, rarity);
    }
  }

  @Test
  public void testCreateWeaponWithHandsConstraint() throws NoAvailableEntityTypeException {
    for (ENbHands nbHands : ENbHands.values()) {
      globalConstraints.update(ENbkWeaponType.getConstraints(), ENbHands.class, nbHands);
      weapon = NbkRGWeapon.create(globalConstraints);
      assertThat(weapon).isNotNull();
      assertThat(weapon.getWeaponType().getNbHands()).isEqualTo(nbHands);
      globalConstraints.update(ENbkWeaponType.getConstraints(), ENbHands.class, nbHands);
    }
  }
}
