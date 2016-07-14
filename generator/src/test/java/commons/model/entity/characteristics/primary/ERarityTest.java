package commons.model.entity.characteristics.primary;

import commons.model.entity.characteristics.primary.enums.ERarity;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;


/**
 * Created by Germain on 06/06/2016.
 */
public class ERarityTest {

  @Test
  public void testGetRarity() {
    assertEquals(ERarity.COMMON, ERarity.getRarity(0));
    Stream.of(ERarity.values()).forEach(eRarity -> assertEquals(eRarity, ERarity.getRarity(eRarity.getRarityLevel())));
  }
}
