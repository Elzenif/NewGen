package dd.model.entity.items.factory.subfactory;

import dd.model.entity.items.treasure.DDTreasure;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 29/10/2016.
 */
public abstract class DDTreasureSubFactoryTest {

  protected DDTreasureSubFactory factory;

  public void shouldGenerateXGems() {
    for (int i = 1; i < 10; i++) {
      factory.setNumberToGenerate(i);
      List<DDTreasure> generate = factory.generate();
      assertThat(generate).hasSize(i);
      assertThat(generate).doesNotContainNull();
    }
  }

}
