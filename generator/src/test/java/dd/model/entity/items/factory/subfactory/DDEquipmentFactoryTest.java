package dd.model.entity.items.factory.subfactory;

import org.junit.Test;

/**
 * Created by Germain on 11/12/2016.
 */
public class DDEquipmentFactoryTest extends DDOneRarityTreasureSubFactoryTest {

  @Test
  public void shouldGenerateXItems() {
    super.shouldGenerateXItems(DDEquipmentFactory.getInstance());
  }

}
