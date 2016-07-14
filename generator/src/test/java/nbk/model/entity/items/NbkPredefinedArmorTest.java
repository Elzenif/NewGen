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

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Germain on 28/06/2016.
 */
public class NbkPredefinedArmorTest {

  private GlobalConstraints globalConstraints;
  private final List<ERarity> rarities = Arrays.asList(ERarity.values());
  private NbkPredefinedArmor armor;

  @Before
  public void init() throws NoAvailableItemTypeException {
    globalConstraints = new GlobalConstraints();
  }

  @Test
  public void testArmorIsNotNull() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      armor = NbkPredefinedArmor.create(globalConstraints, rarity);
      assertNotNull("The armor should not be null", armor);
    }
  }

  @Test
  public void testPredefinedArmorIsNotNull() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      armor = NbkPredefinedArmor.create(globalConstraints, rarity);
      assertNotNull("The predefined armor should not be null", armor.getPredefinedArmor());
    }
  }

  @Test
  public void testPredefinedArmorIsValid() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      armor = NbkPredefinedArmor.create(globalConstraints, rarity);
      Set<ENbkPredefinedArmor> armorTypes = EnumSet.allOf(ENbkPredefinedArmor.class);
      assertTrue("The predefined armor should be a ENbkPredefinedArmor enum",
              armorTypes.contains(armor.getPredefinedArmor()));
    }
  }

  @Test
  public void testToStringIsValid() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      armor = NbkPredefinedArmor.create(globalConstraints, rarity);
      assertFalse("The armor toString is not valid", armor.toString().contains("@"));
    }
  }

  @Test
  public void testSizeIsValid() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      armor = NbkPredefinedArmor.create(globalConstraints, rarity);
      Set<ESize> sizeSet = EnumSet.allOf(ESize.class);
      assertTrue(sizeSet.contains(armor.getSize()));
    }
  }

  @Test
  public void testWeightIsValid() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      armor = NbkPredefinedArmor.create(globalConstraints, rarity);
      Set<EWeight> weightSet = EnumSet.allOf(EWeight.class);
      assertTrue(weightSet.contains(armor.getWeight()));
    }
  }

  @Test
  public void testBodyPartIsValid() throws NoAvailableItemTypeException {
    for (ERarity rarity : rarities) {
      armor = NbkPredefinedArmor.create(globalConstraints, rarity);
      Set<EBodyPart> bodyPartSet = EnumSet.allOf(EBodyPart.class);
      for (EBodyPart bodyPart : armor.getBodyParts())
      assertTrue(bodyPartSet.contains(bodyPart));
    }
  }
}
