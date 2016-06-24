package nbk.model.entity.enums;

import org.junit.Test;

import java.util.stream.Stream;

import static commons.model.entity.utils.ItemUtils.streamSortedByRarity;
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
            }
    );
  }

  @Test()
  public void testPrintByRarity() {
    streamSortedByRarity(ENbkPredefinedWeapon.values()).forEach(w -> System.out.println(w.getName()));
  }
}
