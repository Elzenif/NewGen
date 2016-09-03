package nbk.model.entity.living.characteristics.secondary.enums;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Germain on 29/08/2016.
 */
public class ENbkOriginTest {

  @Test
  public void testAllAreValid() {
    Stream.of(ENbkOrigin.values()).forEach(
            o -> {
              assertNotNull(o.getName());
              assertNotNull(o.getRarity());
              assertNotNull(o.getEV());
            }
    );
  }
}
