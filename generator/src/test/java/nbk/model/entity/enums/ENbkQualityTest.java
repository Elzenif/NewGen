package nbk.model.entity.enums;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Germain on 24/06/2016.
 */
public class ENbkQualityTest {

  @Test
  public void testAllAreValid() {
    Stream.of(ENbkQuality.values()).forEach(
            q -> {
              assertNotNull(q.getName());
              assertNotNull(q.getRarity());
              assertNotNull(q.getQuality());
            }
    );
  }
}
