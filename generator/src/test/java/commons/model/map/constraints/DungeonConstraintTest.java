package commons.model.map.constraints;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 02/10/2016.
 */
public class DungeonConstraintTest {

  private DungeonConstraint<EKeyTest> dungeonConstraint;

  @Before
  public void setUp() throws Exception {
    dungeonConstraint = new DungeonConstraint<>();
  }

  @Test
  public void constraintShouldBeUpdatedAfterBeingPut() {
    assertThat(dungeonConstraint).isEmpty();

    dungeonConstraint.put(EKeyTest.A, 10);

    assertThat(dungeonConstraint.get(EKeyTest.A)).isEqualTo(10);
  }

  private enum EKeyTest implements IDungeonDrawKey {
    A
  }
}
