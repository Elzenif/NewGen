package dd.model.entity.items.factory.subfactory;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Germain on 31/10/2016.
 */
public class DDRingFactoryTest extends DDMultipleRaritiesTreasureSubFactoryTest {

  @Before
  public void setUp() throws Exception {
    factory = DDRingFactory.getInstance();
  }

  @Test
  public void shouldGenerateXItems() {
    super.shouldGenerateXItems();
  }
}
