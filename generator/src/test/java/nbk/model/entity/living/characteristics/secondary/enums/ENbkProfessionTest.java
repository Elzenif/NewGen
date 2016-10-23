package nbk.model.entity.living.characteristics.secondary.enums;

import commons.utils.french.FrenchNoun;
import commons.utils.french.Gender;
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
          assertThat(p.getEA()).isNotNull();
        }
    );
  }

  @Test
  public void namesGendersShouldBeValid() {
    Stream.of(ENbkProfession.values()).forEach(
        p -> {
          assertThat(p.names).isNotEmpty();
          if (p.names.size() == 1) {
            assertThat(p.names).extracting("gender")
                .as("if " + p.name() + " has only one name, it should be neutral")
                .containsOnly(Gender.NEUTRAL);
          } else {
            boolean masculine = false;
            boolean feminine = false;
            for (FrenchNoun name : p.names) {
              if (name.getGender() == Gender.MASCULINE) {
                masculine = true;
              } else if (name.getGender() == Gender.FEMININE) {
                feminine = true;
              }
            }
            if (masculine) {
              assertThat(feminine).isTrue();
            } else {
              assertThat(feminine).isFalse();
            }
          }
        }
    );
  }
}
