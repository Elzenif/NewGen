package dd.model.entity.items.factory.subfactory;

import org.junit.Test;

/**
 * Created by Germain on 29/10/2016.
 */
public class DDArtObjectFactoryTest extends DDOneRarityTreasureSubFactoryTest {

  @Test
  public void shouldGenerateXItems() {
    super.shouldGenerateXItems(DDArtObjectFactory.getInstance());
  }
}
