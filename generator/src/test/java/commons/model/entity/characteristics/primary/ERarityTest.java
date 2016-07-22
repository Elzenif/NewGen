package commons.model.entity.characteristics.primary;

import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.utils.EOperator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * Created by Germain on 06/06/2016.
 */
public class ERarityTest {

  @Test
  public void testOrderRarity() {
    assertTrue(EOperator.LT.apply(ERarity.COMMON, ERarity.UNCOMMON));
    assertTrue(EOperator.LT.apply(ERarity.UNCOMMON, ERarity.RARE));
    assertTrue(EOperator.LT.apply(ERarity.RARE, ERarity.EPIC));
    assertTrue(EOperator.LT.apply(ERarity.EPIC, ERarity.LEGENDARY));
  }
}
