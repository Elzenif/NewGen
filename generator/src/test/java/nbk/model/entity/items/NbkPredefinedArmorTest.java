package nbk.model.entity.items;

import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.enums.ERarity;
import commons.utils.exception.NoAvailableItemTypeException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;

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
}
