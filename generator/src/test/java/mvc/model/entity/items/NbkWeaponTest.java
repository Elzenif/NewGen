package mvc.model.entity.items;

import mvc.model.entity.constraints.GlobalConstraints;
import mvc.model.entity.constraints.GenericConstraint;
import mvc.model.entity.constraints.NbHandsConstraint;
import mvc.model.entity.enums.ENbkWeaponType;
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
public class NbkWeaponTest {

  private GlobalConstraints globalConstraints;
  private NbkWeapon weapon;

  @Before
  public void init() {
    globalConstraints = new GlobalConstraints();
  }

  @Test
  public void testWeaponNotNull() {
    weapon = NbkWeapon.create(globalConstraints);
    assertNotNull("The weapon should not be null", weapon);
  }

  @Test
  public void testWeaponTypeNotNull() {
    weapon = NbkWeapon.create(globalConstraints);
    assertNotNull("The weapon type should not be null", weapon.getWeaponType());
  }

  @Test
  public void testWeaponTypeIsValid() {
    weapon = NbkWeapon.create(globalConstraints);
    Set<ENbkWeaponType> weaponTypes = new HashSet<>(Arrays.asList(ENbkWeaponType.values()));
    assertNotNull("The weapon type should be a ENbkWeaponType enum :" + weapon.getWeaponType().toString(),
            weaponTypes.contains(weapon.getWeaponType()));
  }

  @Test
  public void testWeaponToStringIsNotNull() {
    weapon = NbkWeapon.create(globalConstraints);
    assertNotNull("The weapon type should not be null", weapon.toString());
  }

  @Test
  public void testCreateWeaponWithHandsConstraint() {
    int nbHands = 1;
    globalConstraints.put(ENbkWeaponType.class, NbHandsConstraint.class, NbHandsConstraint.ONE_HAND);
    weapon = NbkWeapon.create(globalConstraints);
    assertNotNull("The weapon should not be null");
    assertEquals("The weapon should be one hand", nbHands, weapon.getWeaponType().getNbHands());

    nbHands = 2;
    globalConstraints.put(ENbkWeaponType.class, NbHandsConstraint.class, NbHandsConstraint.TWO_HANDS);
    weapon = NbkWeapon.create(globalConstraints);
    assertNotNull("The weapon should not be null");
    assertEquals("The weapon should be one hand", nbHands, weapon.getWeaponType().getNbHands());
  }
}
