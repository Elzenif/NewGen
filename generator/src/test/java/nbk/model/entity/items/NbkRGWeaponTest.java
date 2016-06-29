package nbk.model.entity.items;

import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.enums.EMagic;
import commons.model.entity.enums.ERarity;
import commons.utils.exception.NoAvailableItemTypeException;
import nbk.model.entity.constraints.NbkNbHandsConstraint;
import nbk.model.entity.enums.ENbHands;
import nbk.model.entity.enums.ENbkQuality;
import nbk.model.entity.enums.ENbkWeaponType;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
  private final List<ERarity> rarities = Arrays.asList(ERarity.values());
  private NbkRGWeapon weapon;

  @Before
  public void init() throws NoAvailableItemTypeException {
    globalConstraints = new GlobalConstraints();
  }

  @Test
  public void testWeaponNotNull() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      weapon = NbkRGWeapon.create(globalConstraints, rarity);
      assertNotNull("The weapon should not be null", weapon);
    }
  }

  @Test
  public void testWeaponTypeNotNull() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      weapon = NbkRGWeapon.create(globalConstraints, rarity);
      assertNotNull("The weapon type should not be null", weapon.getWeaponType());
    }
  }

  @Test
  public void testWeaponTypeIsValid() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      weapon = NbkRGWeapon.create(globalConstraints, rarity);
      Set<ENbkWeaponType> weaponTypes = new HashSet<>(Arrays.asList(ENbkWeaponType.values()));
      assertTrue("The weapon type should be a ENbkWeaponType enum : " + weapon.getWeaponType().toString(),
              weaponTypes.contains(weapon.getWeaponType()));
    }
  }

  @Test
  public void testWeaponQualityIsNotNull() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      weapon = NbkRGWeapon.create(globalConstraints, rarity);
      assertNotNull("The weapon quality should not be null", weapon.getQuality());
    }
  }

  @Test
  public void testWeaponQualityIsValid() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      weapon = NbkRGWeapon.create(globalConstraints, rarity);
      Set<ENbkQuality> qualities = new HashSet<>(Arrays.asList(ENbkQuality.values()));
      assertTrue("The weapon quality sould be a ENbkQuality enum : " + weapon.getQuality().toString(),
              qualities.contains(weapon.getQuality()));
    }
  }

  @Test
  public void testWeaponMagicIsNotNull() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      weapon = NbkRGWeapon.create(globalConstraints, rarity);
      assertNotNull("The weapon magic should not be null", weapon.getMagic());
    }
  }

  @Test
  public void testWeaponMagicIsValid() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      weapon = NbkRGWeapon.create(globalConstraints, rarity);
      Set<EMagic> qualities = new HashSet<>(Arrays.asList(EMagic.values()));
      assertTrue("The weapon quality sould be a EMagic enum : " + weapon.getMagic().toString(),
              qualities.contains(weapon.getMagic()));
    }
  }

  @Test
  public void testWeaponToStringIsNotNull() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      weapon = NbkRGWeapon.create(globalConstraints, rarity);
      assertNotNull("The weapon toString should not be null", weapon.toString());
    }
  }

  @Test
  public void testWeaponToStringIsValid() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      weapon = NbkRGWeapon.create(globalConstraints, rarity);
      assertFalse("The weapon toString is not valid", weapon.toString().contains("@"));
    }
  }

  @Test
  public void testCreateWeaponWithHandsConstraint() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      ENbHands nbHands = ENbHands.ONE;
      globalConstraints.put(ENbkWeaponType.class, NbkNbHandsConstraint.class, NbkNbHandsConstraint.ONE_HAND);
      weapon = NbkRGWeapon.create(globalConstraints, rarity);
      assertNotNull("The weapon should not be null");
      assertEquals("The weapon should be one hand", nbHands, weapon.getWeaponType().getNbHands());

      nbHands = ENbHands.TWO;
      globalConstraints.put(ENbkWeaponType.class, NbkNbHandsConstraint.class, NbkNbHandsConstraint.TWO_HANDS);
      weapon = NbkRGWeapon.create(globalConstraints, rarity);
      assertNotNull("The weapon should not be null");
      assertEquals("The weapon should be two hands", nbHands, weapon.getWeaponType().getNbHands());
    }
  }
}
