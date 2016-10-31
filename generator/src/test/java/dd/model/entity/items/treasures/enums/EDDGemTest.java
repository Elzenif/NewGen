package dd.model.entity.items.treasures.enums;

import org.junit.Test;

/**
 * Created by Germain on 31/10/2016.
 */
public class EDDGemTest extends EDDOneRarityItemTest {

  @Test
  public void allFieldsShouldBeOK() {
    super.allFieldsShouldBeOK(EDDGem.values());
  }
}
