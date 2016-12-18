package dd.model.entity.items.factory.subfactory;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Germain on 11/12/2016.
 */
public class DDWeaponFactoryTest extends DDMultipleRaritiesTreasureSubFactoryTest {

  @Before
  public void setUp() throws Exception {
    factory = DDWeaponFactory.getInstance();
  }

  @Test
  public void shouldGenerateXItems() {
    super.shouldGenerateXItems();
  }

}
