package dd.model.entity.items.factory.subfactory;

import org.junit.Test;

/**
 * Created by Germain on 10/12/2016.
 */
public class DDMasterworkUncommonWeaponFactoryTest extends DDOneRarityTreasureSubFactoryTest {

  @Test
  public void shouldGenerateXItems() {
    super.shouldGenerateXItems(DDMasterworkUncommonWeaponFactory.getInstance());
  }

}
