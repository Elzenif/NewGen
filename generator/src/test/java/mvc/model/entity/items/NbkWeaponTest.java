package mvc.model.entity.items;

import mvc.model.entity.enums.ENbkWeaponType;
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
public class NbkWeaponTest {

  private Constraints constraints;
  private NbkWeapon weapon;

  @Before
  public void init() {
    constraints = new Constraints();
  }

  @Test
  public void testWeaponNotNull() {
    weapon = NbkWeapon.create(constraints);
    assertNotNull("The weapon should not be null", weapon);
  }

  @Test
  public void testWeaponTypeNotNull() {
    weapon = NbkWeapon.create(constraints);
    assertNotNull("The weapon type should not be null", weapon.getWeaponType());
  }

  @Test
  public void testWeaponTypeIsValid() {
    weapon = NbkWeapon.create(constraints);
    Set<ENbkWeaponType> weaponTypes = new HashSet<>(Arrays.asList(ENbkWeaponType.values()));
    assertNotNull("The weapon type should be a ENbkWeaponType enum :" + weapon.getWeaponType().toString(),
            weaponTypes.contains(weapon.getWeaponType()));
  }

  @Test
  public void testWeaponToStringIsNotNull() {
    weapon = NbkWeapon.create(constraints);
    assertNotNull("The weapon type should not be null", weapon.toString());
  }

  @Test
  public void testCreateWeaponWithHandsConstraint() {
    for (int i = 1; i <= 2; i ++) {
      final int nbHands = i;
      constraints.put(ENbkWeaponType.class, new GenericConstraint<>(wt -> wt.getNbHands() == nbHands));
      weapon = NbkWeapon.create(constraints);
      assertNotNull("The weapon should not be null");
      assertEquals("The weapon should be one hand", nbHands, weapon.getWeaponType().getNbHands());
    }
  }
}
