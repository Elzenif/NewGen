package nbk.model.entity.items;

import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.exception.NoAvailableItemTypeException;
import nbk.model.entity.characteristics.primary.enums.EBodyPart;
import nbk.model.entity.characteristics.primary.enums.ESize;
import nbk.model.entity.characteristics.primary.enums.EWeight;
import nbk.model.entity.characteristics.secondary.enums.ENbkPredefinedArmor;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Germain on 28/06/2016.
 */
public class NbkPredefinedArmorTest {

  private GlobalConstraints globalConstraints;
  private NbkPredefinedArmor armor;

  @Before
  public void init() throws NoAvailableItemTypeException {
    globalConstraints = new GlobalConstraints();
  }

  @Test
  public void testArmorIsNotNull() throws NoAvailableItemTypeException {
    armor = NbkPredefinedArmor.create(globalConstraints);
    assertNotNull("The armor should not be null", armor);
  }

  @Test
  public void testPredefinedArmorIsNotNull() throws NoAvailableItemTypeException {
    armor = NbkPredefinedArmor.create(globalConstraints);
    assertNotNull("The predefined armor should not be null", armor.getPredefinedArmor());
  }

  @Test
  public void testPredefinedArmorIsValid() throws NoAvailableItemTypeException {
    armor = NbkPredefinedArmor.create(globalConstraints);
    Set<ENbkPredefinedArmor> armorTypes = EnumSet.allOf(ENbkPredefinedArmor.class);
    assertTrue("The predefined armor should be a ENbkPredefinedArmor enum",
            armorTypes.contains(armor.getPredefinedArmor()));
  }

  @Test
  public void testToStringIsValid() throws NoAvailableItemTypeException {
    armor = NbkPredefinedArmor.create(globalConstraints);
    assertFalse("The armor toString is not valid", armor.toString().contains("@"));
  }

  @Test
  public void testSizeIsValid() throws NoAvailableItemTypeException {
    armor = NbkPredefinedArmor.create(globalConstraints);
    Set<ESize> sizeSet = EnumSet.allOf(ESize.class);
    assertTrue(sizeSet.contains(armor.getSize()));
  }

  @Test
  public void testWeightIsValid() throws NoAvailableItemTypeException {
    armor = NbkPredefinedArmor.create(globalConstraints);
    Set<EWeight> weightSet = EnumSet.allOf(EWeight.class);
    assertTrue(weightSet.contains(armor.getWeight()));
  }

  @Test
  public void testBodyPartIsValid() throws NoAvailableItemTypeException {
    armor = NbkPredefinedArmor.create(globalConstraints);
    Set<EBodyPart> bodyPartSet = EnumSet.allOf(EBodyPart.class);
    for (EBodyPart bodyPart : armor.getBodyParts())
      assertTrue(bodyPartSet.contains(bodyPart));
  }

  @Test
  public void testCreateArmorWithRarityConstraint() throws NoAvailableItemTypeException {
    for (ERarity rarity : EnumSet.allOf(ERarity.class)) {
      armor = NbkPredefinedArmor.create(globalConstraints, rarity);
      assertNotNull("The armor should not be null", armor);
      assertEquals(rarity, armor.getRarity());
    }
  }
}