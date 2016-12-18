package dd.model.entity.items.treasures.enums;

import org.junit.Test;

/**
 * Created by Germain on 11/12/2016.
 */
public class EDDWeaponBonusTest extends EDDMultipleRaritiesItemTest {

  @Test
  public void allFieldsShouldBeOK() {
    super.allFieldsShouldBeOK(EDDWeaponBonus.values());
  }

}
