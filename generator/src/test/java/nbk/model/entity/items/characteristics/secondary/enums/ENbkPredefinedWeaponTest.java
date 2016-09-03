package nbk.model.entity.items.characteristics.secondary.enums;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Germain on 24/06/2016.
 */
public class ENbkPredefinedWeaponTest {

  @Test
  public void testAllAreValid() {
    Stream.of(ENbkPredefinedWeapon.values()).forEach(
            w -> {
              assertNotNull(w.getName());
              assertNotNull(w.getRarity());
              assertNotNull(w.getWeaponType());
              assertNotNull(w.getMagic());
              assertNotNull(w.getRange());
              assertNotNull(w.getNbHands());
              assertNotNull(w.getSize());
            }
    );
  }
}
