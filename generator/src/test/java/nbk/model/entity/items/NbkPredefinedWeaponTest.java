package nbk.model.entity.items;

import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.enums.ERarity;
import commons.model.entity.utils.ItemUtils;
import commons.utils.exception.NoAvailableItemTypeException;
import nbk.model.entity.constraints.NbkNbHandsConstraint;
import nbk.model.entity.enums.ENbkWeaponType;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Germain on 23/06/2016.
 */
public class NbkPredefinedWeaponTest {

  private GlobalConstraints globalConstraints;
  private ERarity rarity;
  private NbkPredefinedWeapon weapon;

  @Before
  public void init() throws NoAvailableItemTypeException {
    globalConstraints = new GlobalConstraints();
    rarity = ItemUtils.selectRandomRarity(ERarity.values());
  }

  @Test
  public void testWeaponIsNotNull() throws NoAvailableItemTypeException {
    weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
    assertNotNull("The weapon should not be null", weapon);
  }

  @Test
  public void testWeaponTypeNotNull() throws NoAvailableItemTypeException {
    weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
    assertNotNull("The weapon type should not be null", weapon.getWeaponType());
  }

  @Test
  public void testWeaponTypeIsValid() throws NoAvailableItemTypeException {
    weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
    Set<ENbkWeaponType> weaponTypes = new HashSet<>(Arrays.asList(ENbkWeaponType.values()));
    assertTrue("The weapon type should be a ENbkWeaponType enum : " + weapon.getWeaponType().toString(),
            weaponTypes.contains(weapon.getWeaponType()));
  }


  @Test
  public void testWeaponToStringIsNotNull() throws NoAvailableItemTypeException {
    weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
    assertNotNull("The weapon type should not be null", weapon.toString());
  }

  @Test
  public void testCreateWeaponWithHandsConstraint() {
    int nbHands = 1;
    globalConstraints.put(ENbkWeaponType.class, NbkNbHandsConstraint.class, NbkNbHandsConstraint.ONE_HAND);
    try {
      weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
      assertNotNull("The weapon should not be null");
      assertEquals("The weapon should be one hand", nbHands, weapon.getWeaponType().getNbHands());
    } catch (NoAvailableItemTypeException e) {

    }
    nbHands = 2;
    globalConstraints.put(ENbkWeaponType.class, NbkNbHandsConstraint.class, NbkNbHandsConstraint.TWO_HANDS);
    try {
      weapon = NbkPredefinedWeapon.create(globalConstraints, rarity);
      assertNotNull("The weapon should not be null");
      assertEquals("The weapon should be two hands", nbHands, weapon.getWeaponType().getNbHands());
    } catch (NoAvailableItemTypeException e) {

    }
  }
}
