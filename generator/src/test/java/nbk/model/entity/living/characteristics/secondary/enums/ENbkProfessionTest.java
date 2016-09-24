package nbk.model.entity.living.characteristics.secondary.enums;

import org.junit.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 08/09/2016.
 */
public class ENbkProfessionTest {

  @Test
  public void testAllAreValid() {
    Stream.of(ENbkProfession.values()).forEach(
            p -> {
              assertThat(p.getName()).isNotNull();
              assertThat(p.getRarity()).isNotNull();
              assertThat(p.getMinStats()).isNotNull();
              assertThat(p.getMaxStats()).isNotNull();
              assertThat(p.getEV()).isNotNull();
            }
    );
  }
}
