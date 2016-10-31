package dd.model.entity.items.factory.subfactory;

import org.junit.Test;

/**
 * Created by Germain on 30/10/2016.
 */
public class DDNonMagicItemFactoryTest extends DDOneRarityTreasureSubFactoryTest {

  @Test
  public void shouldGenerateXItems() {
    super.shouldGenerateXItems(DDNonMagicItemFactory.getInstance());
  }
}
