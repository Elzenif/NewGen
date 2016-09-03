package commons.model.entity.characteristics.primary;

import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.utils.EOperator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * Created by Germain on 06/06/2016.
 */
public class EItemRarityTest {

  @Test
  public void testOrderRarity() {
    assertTrue(EOperator.LT.apply(EItemRarity.COMMON, EItemRarity.UNCOMMON));
    assertTrue(EOperator.LT.apply(EItemRarity.UNCOMMON, EItemRarity.RARE));
    assertTrue(EOperator.LT.apply(EItemRarity.RARE, EItemRarity.EPIC));
    assertTrue(EOperator.LT.apply(EItemRarity.EPIC, EItemRarity.LEGENDARY));
  }
}
