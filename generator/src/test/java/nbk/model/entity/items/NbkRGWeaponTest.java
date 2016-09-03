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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
    assertNotNull("The weapon should not be null", weapon);
  }

  @Test
  public void testWeaponTypeNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    assertNotNull("The weapon type should not be null", weapon.getWeaponType());
  }

  @Test
  public void testWeaponTypeIsValid() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    Set<ENbkWeaponType> weaponTypes = new HashSet<>(Arrays.asList(ENbkWeaponType.values()));
    assertTrue("The weapon type should be a ENbkWeaponType enum : " + weapon.getWeaponType().toString(),
            weaponTypes.contains(weapon.getWeaponType()));
  }

  @Test
  public void testWeaponQualityIsNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    assertNotNull("The weapon quality should not be null", weapon.getQuality());
  }

  @Test
  public void testWeaponQualityIsValid() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    Set<ENbkQuality> qualities = new HashSet<>(Arrays.asList(ENbkQuality.values()));
    assertTrue("The weapon quality should be a ENbkQuality enum : " + weapon.getQuality().toString(),
            qualities.contains(weapon.getQuality()));
  }

  @Test
  public void testWeaponMagicIsNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    assertNotNull("The weapon magic should not be null", weapon.getMagic());
  }

  @Test
  public void testWeaponMagicIsValid() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    Set<EMagic> qualities = new HashSet<>(Arrays.asList(EMagic.values()));
    assertTrue("The weapon quality should be a EMagic enum : " + weapon.getMagic().toString(),
            qualities.contains(weapon.getMagic()));
  }

  @Test
  public void testWeaponToStringIsNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    assertNotNull("The weapon toString should not be null", weapon.toString());
  }

  @Test
  public void testWeaponToStringIsValid() throws NoAvailableEntityTypeException {
    weapon = NbkRGWeapon.create(globalConstraints);
    assertFalse("The weapon toString is not valid", weapon.toString().contains("@"));
  }

  @Test
  public void testCreateWeaponWithRarityConstraint() throws NoAvailableEntityTypeException {
    for (EItemRarity rarity : EItemRarity.values()) {
      globalConstraints.update(ENbkQuality.getConstraints(), EItemRarity.class, rarity);
      weapon = NbkRGWeapon.create(globalConstraints);
      assertNotNull("The weapon should not be null", weapon);
      assertTrue(weapon.getRarity() + " (weapon rarity) should be greater than " + rarity,
              EOperator.GTE.apply(weapon.getRarity(), rarity));
      globalConstraints.update(ENbkQuality.getConstraints(), EItemRarity.class, rarity);
    }
  }

  @Test
  public void testCreateWeaponWithHandsConstraint() throws NoAvailableEntityTypeException {
    for (ENbHands nbHands : ENbHands.values()) {
      globalConstraints.update(ENbkWeaponType.getConstraints(), ENbHands.class, nbHands);
      weapon = NbkRGWeapon.create(globalConstraints);
      assertNotNull("The weapon should not be null", weapon);
      assertEquals("The weapon should be one hand", nbHands, weapon.getWeaponType().getNbHands());
      globalConstraints.update(ENbkWeaponType.getConstraints(), ENbHands.class, nbHands);
    }
  }
}
