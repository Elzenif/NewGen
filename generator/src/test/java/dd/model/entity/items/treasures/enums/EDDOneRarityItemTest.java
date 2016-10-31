package dd.model.entity.items.treasures.enums;

import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 31/10/2016.
 */
public abstract class EDDOneRarityItemTest {

  public void allFieldsShouldBeOK(DDOneRarityItemType[] values) {
    Stream.of(values).forEach(o -> {
      assertThat(o.getName()).isNotNull();
      assertThat(o.getRarity()).isNotNull();
      assertThat(o.getValue()).isNotNull();
    });
  }
}
