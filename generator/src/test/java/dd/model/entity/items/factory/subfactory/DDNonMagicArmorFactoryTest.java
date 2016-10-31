package dd.model.entity.items.factory.subfactory;

import org.junit.Test;

/**
 * Created by Germain on 31/10/2016.
 */
public class DDNonMagicArmorFactoryTest extends DDOneRarityTreasureSubFactoryTest {

  @Test
  public void shouldGenerateXItems() {
    super.shouldGenerateXItems(DDNonMagicArmorFactory.getInstance());
  }
}
