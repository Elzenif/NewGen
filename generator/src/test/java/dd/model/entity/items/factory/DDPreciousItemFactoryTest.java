package dd.model.entity.items.factory;

import commons.utils.MathUtils;
import dd.model.entity.items.treasures.DDTreasure;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 29/10/2016.
 */
@SuppressWarnings("HardCodedStringLiteral")
public class DDPreciousItemFactoryTest {

  private DDPreciousItemFactory factory;

  @Before
  public void setUp() throws Exception {
    factory = DDPreciousItemFactory.getInstance();
  }

  @Test
  public void shouldReturnEmptyListWhenLowScore() {
    for (int level = 1; level <= DDTreasure.LEVEL_MAX; level++) {
      List<DDTreasure> treasures = factory.generate(level, 2);
      assertThat(treasures).as("Precious item at level " + level).isEmpty();
    }
  }

  @Test
  public void shouldNotReturnNullWhenHighScore() {
    int minimum = 91;
    for (int level = 1; level < DDTreasure.LEVEL_MAX; level++) {
      int diceResult = MathUtils.random(minimum, 100);
      List<DDTreasure> treasures = factory.generate(level, diceResult);
      assertThat(treasures).as("Precious items at level " + level + " and dice " + diceResult).isNotEmpty();
      assertThat(treasures).as("Precious items at level " + level + " and dice " + diceResult).doesNotContainNull();
      minimum -= 3;
    }
  }
}
