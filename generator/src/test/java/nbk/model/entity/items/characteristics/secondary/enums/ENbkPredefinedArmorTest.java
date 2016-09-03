package nbk.model.entity.items.characteristics.secondary.enums;

import org.junit.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 30/06/2016.
 */
public class ENbkPredefinedArmorTest {

  @Test
  public void testAllAreValid() {
    Stream.of(ENbkPredefinedArmor.values()).forEach(
            a -> {
              assertThat(a.getName()).isNotNull();
              assertThat(a.getRarity()).isNotNull();
              assertThat(a.getMagic()).isNotNull();
              assertThat(a.getWeight()).isNotNull();
              assertThat(a.getBodyParts()).isNotNull();
              assertThat(a.getSize()).isNotNull();
            }
    );
  }
}
