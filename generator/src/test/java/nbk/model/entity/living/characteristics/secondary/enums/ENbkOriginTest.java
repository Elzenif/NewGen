package nbk.model.entity.living.characteristics.secondary.enums;

import org.junit.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 29/08/2016.
 */
public class ENbkOriginTest {

  @Test
  public void testAllAreValid() {
    Stream.of(ENbkOrigin.values()).forEach(
            o -> {
              assertThat(o.getName()).isNotNull();
              assertThat(o.getRarity()).isNotNull();
              assertThat(o.getEV()).isNotNull();
              assertThat(o.getMinStats()).isNotNull();
              assertThat(o.getMaxStats()).isNotNull();
            }
    );
  }
}
