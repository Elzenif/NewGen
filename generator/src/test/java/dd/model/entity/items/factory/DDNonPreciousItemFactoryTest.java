package dd.model.entity.items.factory;

import commons.utils.MathUtils;
import dd.model.entity.items.treasures.DDTreasure;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 30/10/2016.
 */
@SuppressWarnings("HardCodedStringLiteral")
public class DDNonPreciousItemFactoryTest {

  private DDNonPreciousItemFactory factory;

  @Before
  public void setUp() throws Exception {
    factory = DDNonPreciousItemFactory.getInstance();
  }

  @Test
  public void shouldReturnEmptyListWhenLowScore() {
    for (int level = 1; level < DDTreasure.LEVEL_MAX; level++) {
      List<DDTreasure> treasures = factory.generate(level, 4);
      assertThat(treasures).as("Item at level " + level).isEmpty();
    }
  }

  @Test
  public void shouldNotReturnNullWhenHighScore() {
    for (int level = 1; level < DDTreasure.LEVEL_MAX; level++) {
      int diceResult = MathUtils.random(72, 100);
      List<DDTreasure> treasures = factory.generate(level, diceResult);
      assertThat(treasures).as("Items at level " + level + " and dice " + diceResult).isNotEmpty();
      assertThat(treasures).as("Items at level " + level + " and dice " + diceResult).doesNotContainNull();
    }
  }
}
