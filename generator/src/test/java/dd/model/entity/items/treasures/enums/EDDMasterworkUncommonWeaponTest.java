package dd.model.entity.items.treasures.enums;

import org.junit.Test;

/**
 * Created by Germain on 10/12/2016.
 */
public class EDDMasterworkUncommonWeaponTest extends EDDOneRarityItemTest {

  @Test
  public void allFieldsShouldBeOK() {
    super.allFieldsShouldBeOK(EDDMasterworkUncommonWeapon.values());
  }

}
