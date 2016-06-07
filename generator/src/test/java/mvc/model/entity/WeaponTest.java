package mvc.model.entity;

import mvc.model.entity.enums.EWeaponType;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Germain on 04/06/2016.
 */
public class WeaponTest {

  private Weapon weapon;

  @Test
  public void testWeaponNotNull() {
    weapon = Weapon.createWeaponWithoutConstraints();
    assertNotNull("The weapon should not be null", weapon);
  }

  @Test
  public void testWeaponTypeNotNull() {
    weapon = Weapon.createWeaponWithoutConstraints();
    assertNotNull("The weapon type should not be null", weapon.getWeaponType());
  }

  @Test
  public void testWeaponTypeIsValid() {
    weapon = Weapon.createWeaponWithoutConstraints();
    Set<EWeaponType> weaponTypes = new HashSet<>(Arrays.asList(EWeaponType.values()));
    assertNotNull("The weapon type should be a EWeaponType enum :" + weapon.getWeaponType().toString(),
            weaponTypes.contains(weapon.getWeaponType()));
  }

  @Test
  public void testWeaponToStringIsNotNull() {
    weapon = Weapon.createWeaponWithoutConstraints();
    assertNotNull("The weapon type should not be null", weapon.toString());
  }

  @Test
  public void testCreateWeaponWithHandsConstraint() {
    for (int i = 1; i <= 2; i ++) {
      weapon = Weapon.createWeapon(i);
      assertNotNull("The weapon should not be null");
      assertEquals("The weapon should be one hand", i, weapon.getWeaponType().getNbHands());
    }
  }
}
