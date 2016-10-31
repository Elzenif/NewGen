package dd.model.entity.items.treasures.enums;

import org.junit.Test;

/**
 * Created by Germain on 31/10/2016.
 */
public class EDDRingTest extends EDDMultipleRaritiesItemTest {

  @Test
  public void allFieldsShouldBeOK() {
    super.allFieldsShouldBeOK(EDDRing.values());
  }
}
