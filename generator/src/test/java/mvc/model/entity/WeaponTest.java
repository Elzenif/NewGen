package mvc.model.entity;

import mvc.model.entity.enums.EWeaponType;
import mvc.model.entity.utils.Constraints;
import mvc.model.entity.utils.GenericConstraint;
import org.junit.Before;
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

  private Constraints constraints;
  private RandomlyGeneratedWeapon weapon;

  @Before
  public void init() {
    constraints = new Constraints();
  }

  @Test
  public void testRandomlyGeneratedWeaponNotNull() {
    weapon = RandomlyGeneratedWeapon.createWeapon(constraints);
    assertNotNull("The weapon should not be null", weapon);
  }

  @Test
  public void testWeaponTypeNotNull() {
    weapon = RandomlyGeneratedWeapon.createWeapon(constraints);
    assertNotNull("The weapon type should not be null", weapon.getWeaponType());
  }

  @Test
  public void testWeaponTypeIsValid() {
    weapon = RandomlyGeneratedWeapon.createWeapon(constraints);
    Set<EWeaponType> weaponTypes = new HashSet<>(Arrays.asList(EWeaponType.values()));
    assertNotNull("The weapon type should be a EWeaponType enum :" + weapon.getWeaponType().toString(),
            weaponTypes.contains(weapon.getWeaponType()));
  }

  @Test
  public void testWeaponToStringIsNotNull() {
    weapon = RandomlyGeneratedWeapon.createWeapon(constraints);
    assertNotNull("The weapon type should not be null", weapon.toString());
  }

  @Test
  public void testCreateWeaponWithHandsConstraint() {
    for (int i = 1; i <= 2; i ++) {
      final int nbHands = i;
      constraints.put(EWeaponType.class, new GenericConstraint<>(wt -> wt.getNbHands() == nbHands));
      weapon = RandomlyGeneratedWeapon.createWeapon(constraints);
      assertNotNull("The weapon should not be null");
      assertEquals("The weapon should be one hand", nbHands, weapon.getWeaponType().getNbHands());
    }
  }
}
