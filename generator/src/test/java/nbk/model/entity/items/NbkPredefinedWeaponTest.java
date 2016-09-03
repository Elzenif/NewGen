package nbk.model.entity.items;

import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.EOperator;
import commons.utils.exception.NoAvailableEntityTypeException;
import nbk.model.entity.items.characteristics.primary.enums.ENbHands;
import nbk.model.entity.items.characteristics.primary.enums.ERange;
import nbk.model.entity.items.characteristics.primary.enums.ESize;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkPredefinedWeapon;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkWeaponType;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumSet;
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
  private NbkPredefinedWeapon weapon;

  @Before
  public void init() {
    globalConstraints = new GlobalConstraints();
  }

  @Test
  public void testWeaponIsNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkPredefinedWeapon.create(globalConstraints);
    assertNotNull("The weapon should not be null", weapon);
  }

  @Test
  public void testPredefinedWeaponNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkPredefinedWeapon.create(globalConstraints);
    assertNotNull("The predefined weapon should not be null", weapon.getPredefinedWeapon());
  }

  @Test
  public void testPredefinedWeaponIsValid() throws NoAvailableEntityTypeException {
    weapon = NbkPredefinedWeapon.create(globalConstraints);
    Set<ENbkPredefinedWeapon> weaponTypes = EnumSet.allOf(ENbkPredefinedWeapon.class);
    assertTrue("The predefined weapon should be a ENbkPredefinedWeapon enum : " + weapon.getMagic().toString(),
            weaponTypes.contains(weapon.getPredefinedWeapon()));
  }

  @Test
  public void testWeaponToStringIsNotNull() throws NoAvailableEntityTypeException {
    weapon = NbkPredefinedWeapon.create(globalConstraints);
    assertNotNull("The weapon toString should not be null", weapon.toString());
  }

  @Test
  public void testWeaponToStringIsValid() throws NoAvailableEntityTypeException {
    weapon = NbkPredefinedWeapon.create(globalConstraints);
    assertFalse("The weapon toString is not valid", weapon.toString().contains("@"));
  }

  @Test
  public void testCreateWeaponWithRarityConstraint() throws NoAvailableEntityTypeException {
    for (EItemRarity rarity : EItemRarity.values()) {
      globalConstraints.update(ENbkPredefinedWeapon.getConstraints(), EItemRarity.class, rarity);
      weapon = NbkPredefinedWeapon.create(globalConstraints);
      assertNotNull("The weapon should not be null", weapon);
      assertTrue(weapon.getRarity() + " (weapon rarity) should be greater than " + rarity,
              EOperator.GTE.apply(weapon.getRarity(), rarity));
      globalConstraints.update(ENbkPredefinedWeapon.getConstraints(), EItemRarity.class, rarity);
    }
  }

  @Test
  public void testCreateWeaponWithHandsConstraint() throws NoAvailableEntityTypeException {
    for (ENbHands nbHands : ENbHands.values()) {
      globalConstraints.update(ENbkWeaponType.getConstraints(), ENbHands.class, nbHands);
      weapon = NbkPredefinedWeapon.create(globalConstraints);
      assertNotNull("The weapon should not be null", weapon);
      assertEquals(nbHands, weapon.getNbHands());
      globalConstraints.update(ENbkWeaponType.getConstraints(), ENbHands.class, nbHands);
    }
  }

  @Test
  public void testCreateWeaponWithRangeConstraint() throws NoAvailableEntityTypeException {
    for (ERange range : ERange.values()) {
      globalConstraints.update(ENbkWeaponType.getConstraints(), ERange.class, range);
      weapon = NbkPredefinedWeapon.create(globalConstraints);
      assertNotNull("The weapon should not be null", weapon);
      assertEquals(range, weapon.getRange());
      globalConstraints.update(ENbkWeaponType.getConstraints(), ERange.class, range);
    }
  }

  @Test
  public void testCreateWeaponWithSizeConstraint() throws NoAvailableEntityTypeException {
    for (ESize size : ESize.values()) {
      globalConstraints.update(ENbkWeaponType.getConstraints(), ESize.class, size);
      weapon = NbkPredefinedWeapon.create(globalConstraints);
      assertNotNull("The weapon should not be null", weapon);
      assertEquals(size, weapon.getSize());
      globalConstraints.update(ENbkWeaponType.getConstraints(), ESize.class, size);
    }
  }
}
