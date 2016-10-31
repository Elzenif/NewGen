package dd.model.entity.items.treasures.enums;

import org.junit.Test;

/**
 * Created by Germain on 31/10/2016.
 */
public class EDDArtObjectTest extends EDDOneRarityItemTest {

  @Test
  public void allFieldsShouldBeOK() {
    super.allFieldsShouldBeOK(EDDArtObject.values());
  }

}
