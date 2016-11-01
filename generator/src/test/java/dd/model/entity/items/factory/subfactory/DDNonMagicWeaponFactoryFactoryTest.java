package dd.model.entity.items.factory.subfactory;

import org.junit.Test;

/**
 * Created by Germain on 01/11/2016.
 */
public class DDNonMagicWeaponFactoryFactoryTest extends DDOneRarityTreasureSubFactoryTest {

  @Test
  public void shouldGenerateXItems() {
    super.shouldGenerateXItems(DDNonMagicWeaponFactoryFactory.getInstance());
  }
}
