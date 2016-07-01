package nbk.model.entity.enums;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Germain on 24/06/2016.
 */
public class ENbkWeaponTypeTest {

  @Test
  public void testAllAreValid() {
    Stream.of(ENbkWeaponType.values()).forEach(
            w -> {
              assertNotNull(w.getName());
              assertNotNull(w.getRarity());
              assertNotNull(w.getWeaponType());
              assertNotNull(w.getQuantity());
              assertNotNull(w.getNbHands());
              assertNotNull(w.isLongDistance());
            }
    );
  }
}
