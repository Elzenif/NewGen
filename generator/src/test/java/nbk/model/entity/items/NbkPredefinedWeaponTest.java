package nbk.model.entity.items;

import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.enums.ERarity;
import commons.utils.exception.NoAvailableItemTypeException;
import nbk.model.entity.constraints.NbkNbHandsConstraint;
import nbk.model.entity.enums.ENbHands;
import nbk.model.entity.enums.ENbkPredefinedWeapon;
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
      Set<ENbkPredefinedWeapon> weaponTypes = new HashSet<>(Arrays.asList(ENbkPredefinedWeapon.values()));
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
  public void testCreateWeaponWithHandsConstraint() {
    for (ERarity rarity : rarities) {
      ENbHands nbHands = ENbHands.ONE;
      globalConstraints.put(ENbkWeaponType.class, NbkNbHandsConstraint.class, NbkNbHandsConstraint.ONE_HAND);
      try {
        weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
        assertNotNull("The weapon should not be null");
        assertEquals("The weapon should be one hand", nbHands, weapon.getNbHands());
      } catch (NoAvailableItemTypeException e) {

      }
      nbHands = ENbHands.TWO;
      globalConstraints.put(ENbkWeaponType.class, NbkNbHandsConstraint.class, NbkNbHandsConstraint.TWO_HANDS);
      try {
        weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
        assertNotNull("The weapon should not be null");
        assertEquals("The weapon should be two hands", nbHands, weapon.getNbHands());
      } catch (NoAvailableItemTypeException e) {

      }
    }
  }
}