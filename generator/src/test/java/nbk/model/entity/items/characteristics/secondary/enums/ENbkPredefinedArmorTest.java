package nbk.model.entity.items.characteristics.secondary.enums;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Germain on 30/06/2016.
 */
public class ENbkPredefinedArmorTest {

  @Test
  public void testAllAreValid() {
    Stream.of(ENbkPredefinedArmor.values()).forEach(
            a -> {
              assertNotNull(a.getName());
              assertNotNull(a.getRarity());
              assertNotNull(a.getMagic());
              assertNotNull(a.getWeight());
              assertNotNull(a.getBodyParts());
              assertNotNull(a.getSize());
            }
    );
  }
}
