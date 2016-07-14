package nbk.model.entity.items;

import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.exception.NoAvailableItemTypeException;
import nbk.model.entity.characteristics.primary.enums.ENbHands;
import nbk.model.entity.characteristics.primary.enums.ERange;
import nbk.model.entity.characteristics.secondary.enums.ENbkPredefinedWeapon;
import nbk.model.entity.characteristics.secondary.enums.ENbkWeaponType;
import nbk.model.entity.constraints.NbHandsConstraints;
import nbk.model.entity.constraints.RangeConstraint;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Germain on 23/06/2016.
 */
public class NbkPredefinedWeaponTest {

  private GlobalConstraints globalConstraints;
  private final List<ERarity> rarities = Arrays.asList(ERarity.values());
  private NbkPredefinedWeapon weapon;

  @Before
  public void init() throws NoAvailableItemTypeException {
    globalConstraints = new GlobalConstraints();
  }

  @Test
  public void testWeaponIsNotNull() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
      assertNotNull("The weapon should not be null", weapon);
    }
  }

  @Test
  public void testPredefinedWeaponNotNull() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
      assertNotNull("The predefined weapon should not be null", weapon.getPredefinedWeapon());
    }
  }

  @Test
  public void testPredefinedWeaponIsValid() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
      Set<ENbkPredefinedWeapon> weaponTypes = EnumSet.allOf(ENbkPredefinedWeapon.class);
      assertTrue("The predefined weapon should be a ENbkPredefinedWeapon enum : " + weapon.getMagic().toString(),
              weaponTypes.contains(weapon.getPredefinedWeapon()));
    }
  }

  @Test
  public void testWeaponToStringIsNotNull() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
      assertNotNull("The weapon toString should not be null", weapon.toString());
    }
  }

  @Test
  public void testWeaponToStringIsValid() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
      assertFalse("The weapon toString is not valid", weapon.toString().contains("@"));
    }
  }

  @Test
  public void testCreateWeaponWithHandsConstraint() throws NoAvailableItemTypeException {
    NbHandsConstraints<ENbkWeaponType> nbHandsConstraints = new NbHandsConstraints<>(ENbkWeaponType.class);
    for (ERarity rarity : rarities) {
      ENbHands nbHands = ENbHands.ONE;
      globalConstraints.update(ENbkWeaponType.class, nbHandsConstraints, nbHandsConstraints.ONE_HAND);
      weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
      globalConstraints.update(ENbkWeaponType.class, nbHandsConstraints, nbHandsConstraints.ONE_HAND);
      assertNotNull("The weapon should not be null", weapon);
      assertEquals("The weapon should be one hand", nbHands, weapon.getNbHands());

      nbHands = ENbHands.TWO;
      globalConstraints.update(ENbkWeaponType.class, nbHandsConstraints, nbHandsConstraints.TWO_HANDS);
      weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
      globalConstraints.update(ENbkWeaponType.class, nbHandsConstraints, nbHandsConstraints.TWO_HANDS);
      assertNotNull("The weapon should not be null", weapon);
      assertEquals("The weapon should be two hands", nbHands, weapon.getNbHands());
    }
  }

  @Test
  public void testCreateWeaponWithRangeConstraint() throws NoAvailableItemTypeException {
    RangeConstraint<ENbkWeaponType> rangeConstraint = new RangeConstraint<>(ENbkWeaponType.class);
    for (ERarity rarity : rarities) {
      ERange range = ERange.CLOSE;
      globalConstraints.update(ENbkWeaponType.class, rangeConstraint, rangeConstraint.CLOSE_RANGE);
      weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
      globalConstraints.update(ENbkWeaponType.class, rangeConstraint, rangeConstraint.CLOSE_RANGE);
      assertNotNull("The weapon should not be null", weapon);
      assertEquals("The weapon should be close range", range, weapon.getRange());

      range = ERange.LONG;
      globalConstraints.update(ENbkWeaponType.class, rangeConstraint, rangeConstraint.LONG_RANGE);
      weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
      globalConstraints.update(ENbkWeaponType.class, rangeConstraint, rangeConstraint.LONG_RANGE);
      assertNotNull("The weapon should not be null", weapon);
      assertEquals("The weapon should be close range", range, weapon.getRange());
    }
  }
}
