package dd.model.entity.items.factory.subfactory;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Germain on 29/10/2016.
 */
public class DDGemFactoryTest extends DDTreasureSubFactoryTest {

  @Before
  public void setUp() throws Exception {
    factory = DDGemFactory.getInstance();
  }

  @Test
  public void shouldGenerateXGems() {
    super.shouldGenerateXGems();
  }
}
