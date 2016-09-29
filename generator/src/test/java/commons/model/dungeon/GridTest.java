package commons.model.dungeon;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 29/09/2016.
 */
public class GridTest {

  @Test
  public void getCellShouldBeValid() {
    Grid grid = new Grid(20, 25, 5);
    assertThat(grid.getCell(1, 10)).isEqualTo(grid.getCells()[2][0]);
  }

}
