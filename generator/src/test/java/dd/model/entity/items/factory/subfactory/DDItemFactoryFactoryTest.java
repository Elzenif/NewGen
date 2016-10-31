package dd.model.entity.items.factory.subfactory;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Germain on 31/10/2016.
 */
public class DDItemFactoryFactoryTest extends DDMultipleRaritiesTreasureSubFactoryTest {

  @Before
  public void setUp() throws Exception {
    factory = DDItemFactoryFactory.getInstance();
  }

  @Test
  @Override
  public void shouldGenerateXItems() {
    super.shouldGenerateXItems();
  }
}
