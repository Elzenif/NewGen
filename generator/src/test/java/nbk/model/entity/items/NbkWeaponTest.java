package nbk.model.entity.items;

import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.utils.ERarity;
import commons.model.entity.utils.ItemUtils;
import nbk.model.entity.constraints.NbkNbHandsConstraint;
import nbk.model.entity.enums.ENbkQuality;
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
 * Created by Germain on 04/06/2016.
 */
public class NbkWeaponTest {

  private GlobalConstraints globalConstraints;
  private ERarity rarity;
  private NbkWeapon weapon;

  @Before
  public void init() {
    globalConstraints = new GlobalConstraints();
    rarity = ItemUtils.selectRandomItemType(ERarity.values(), r -> true);
  }

  @Test
  public void testWeaponNotNull() {
    weapon = NbkWeapon.create(globalConstraints, rarity);
    assertNotNull("The weapon should not be null", weapon);
  }

  @Test
  public void testWeaponTypeNotNull() {
    weapon = NbkWeapon.create(globalConstraints, rarity);
    assertNotNull("The weapon type should not be null", weapon.getWeaponType());
  }

  @Test
  public void testWeaponTypeIsValid() {
    weapon = NbkWeapon.create(globalConstraints, rarity);
    Set<ENbkWeaponType> weaponTypes = new HashSet<>(Arrays.asList(ENbkWeaponType.values()));
    assertTrue("The weapon type should be a ENbkWeaponType enum : " + weapon.getWeaponType().toString(),
            weaponTypes.contains(weapon.getWeaponType()));
  }

  @Test
  public void testWeaponQualityIsNotNull() {
    weapon = NbkWeapon.create(globalConstraints, rarity);
    assertNotNull("The weapon quality should not be null", weapon.getQuality());
  }

  @Test
  public void testWeaponQualityIsValid() {
    weapon = NbkWeapon.create(globalConstraints, rarity);
    Set<ENbkQuality> qualities = new HashSet<>(Arrays.asList(ENbkQuality.values()));
    assertTrue("The weapon quality sould be a ENbkQuality enum : " + weapon.getQuality().toString(),
            qualities.contains(weapon.getQuality()));
  }

  @Test
  public void testWeaponToStringIsNotNull() {
    weapon = NbkWeapon.create(globalConstraints, rarity);
    assertNotNull("The weapon type should not be null", weapon.toString());
  }

  @Test
  public void testCreateWeaponWithHandsConstraint() {
    int nbHands = 1;
    globalConstraints.put(ENbkWeaponType.class, NbkNbHandsConstraint.class, NbkNbHandsConstraint.ONE_HAND);
    weapon = NbkWeapon.create(globalConstraints, rarity);
    assertNotNull("The weapon should not be null");
    assertEquals("The weapon should be one hand", nbHands, weapon.getWeaponType().getNbHands());

    nbHands = 2;
    globalConstraints.put(ENbkWeaponType.class, NbkNbHandsConstraint.class, NbkNbHandsConstraint.TWO_HANDS);
    weapon = NbkWeapon.create(globalConstraints, rarity);
    assertNotNull("The weapon should not be null");
    assertEquals("The weapon should be one hand", nbHands, weapon.getWeaponType().getNbHands());
  }
}
