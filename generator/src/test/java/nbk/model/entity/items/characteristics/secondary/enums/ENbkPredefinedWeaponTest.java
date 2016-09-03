package nbk.model.entity.items.characteristics.secondary.enums;

import org.junit.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 24/06/2016.
 */
public class ENbkPredefinedWeaponTest {

  @Test
  public void testAllAreValid() {
    Stream.of(ENbkPredefinedWeapon.values()).forEach(
            w -> {
              assertThat(w.getName()).isNotNull();
              assertThat(w.getRarity()).isNotNull();
              assertThat(w.getWeaponType()).isNotNull();
              assertThat(w.getMagic()).isNotNull();
              assertThat(w.getRange()).isNotNull();
              assertThat(w.getNbHands()).isNotNull();
              assertThat(w.getSize()).isNotNull();
            }
    );
  }
}
