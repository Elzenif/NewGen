package nbk.model.entity.items.characteristics.secondary.enums;

import org.junit.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 24/06/2016.
 */
public class ENbkQualityTest {

  @Test
  public void testAllAreValid() {
    Stream.of(ENbkQuality.values()).forEach(
            q -> {
              assertThat(q.getName()).isNotNull();
              assertThat(q.getRarity()).isNotNull();
            }
    );
  }
}
