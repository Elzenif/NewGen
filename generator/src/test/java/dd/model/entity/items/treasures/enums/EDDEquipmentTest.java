package dd.model.entity.items.treasures.enums;

import org.junit.Test;

/**
 * Created by Germain on 11/12/2016.
 */
public class EDDEquipmentTest extends EDDOneRarityItemTest {

  @Test
  public void allFieldsShouldBeOK() {
    super.allFieldsShouldBeOK(EDDEquipment.values());
  }

}
