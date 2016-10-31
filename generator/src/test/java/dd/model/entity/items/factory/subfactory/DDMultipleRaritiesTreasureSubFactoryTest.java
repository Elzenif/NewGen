package dd.model.entity.items.factory.subfactory;

import dd.model.entity.items.characteristics.EDDItemPowerRarityKey;
import dd.model.entity.items.treasures.DDTreasure;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 31/10/2016.
 */
public abstract class DDMultipleRaritiesTreasureSubFactoryTest {

  protected DDMultipleRaritiesTreasureSubFactory factory;

  public void shouldGenerateXItems() {
    List<DDTreasure> generate;
    for (int i = 1; i < 10; i++) {
      factory.setNumberToGenerate(i);
      for (EDDItemPowerRarityKey rarityKey : EDDItemPowerRarityKey.values()) {
        generate = factory.generate(rarityKey);
        assertThat(generate).hasSize(i);
        assertThat(generate).doesNotContainNull();
      }

    }
  }

}
