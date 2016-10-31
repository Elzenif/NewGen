package dd.model.entity.items.treasures.enums;

import dd.model.entity.items.characteristics.EDDItemPowerRarityKey;
import dd.model.entity.items.characteristics.fields.DDMultipleRaritiesItemType;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 31/10/2016.
 */
public abstract class EDDMultipleRaritiesItemTest {

  public void allFieldsShouldBeOK(DDMultipleRaritiesItemType[] values) {
    Stream.of(values).forEach(o -> {
      assertThat(o.getName()).isNotNull();
      assertThat(o.getRarities().keySet()).containsOnly(EDDItemPowerRarityKey.values());
      assertThat(o.getRarities().values()).doesNotContainNull();
      assertThat(o.getValue()).isNotNull();
    });
  }
}
