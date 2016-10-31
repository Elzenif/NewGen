package dd.model.entity.items.factory;

import dd.model.entity.items.treasures.DDTreasure;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 26/10/2016.
 */
@SuppressWarnings("HardCodedStringLiteral")
public class DDCoinFactoryTest {

  private DDCoinFactory factory;

  @Before
  public void setUp() throws Exception {
    factory = DDCoinFactory.getInstance();
  }

  @Test
  public void shouldReturnNullWhenLowScore() {
    for (int level = 1; level <= DDTreasure.LEVEL_MAX; level++) {
      List<DDTreasure> treasures = factory.generate(level, 2);
      assertThat(treasures).hasSize(1);
      assertThat(treasures.get(0)).as("Coins at level " + level).isNull();
    }
  }

  @Test
  public void shouldNotReturnNullWhenScoreIsHigh() {
    for (int level = 1; level <= DDTreasure.LEVEL_MAX; level++) {
      List<DDTreasure> treasures = factory.generate(level, 50);
      assertThat(treasures).hasSize(1);
      assertThat(treasures.get(0)).as("Coins at level " + level).isNotNull();
    }
  }
}
