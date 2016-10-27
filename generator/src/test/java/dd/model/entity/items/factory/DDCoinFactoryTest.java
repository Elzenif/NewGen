package dd.model.entity.items.factory;

import dd.model.entity.items.treasure.DDTreasure;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 26/10/2016.
 */
public class DDCoinFactoryTest {

  private DDCoinFactory factory;

  @Before
  public void setUp() throws Exception {
    factory = new DDCoinFactory();
  }

  @Test
  public void shouldReturnNullWhenLowScore() {
    List<DDTreasure> treasures = factory.generate(1, 10);
    assertThat(treasures).hasSize(1);
    assertThat(treasures.get(0)).isNull();
  }

  @Test
  public void shouldNotReturnNullWhenScoreIsHigh() {
    List<DDTreasure> treasures = factory.generate(1, 50);
    assertThat(treasures).hasSize(1);
    assertThat(treasures.get(0)).isNotNull();
  }
}
