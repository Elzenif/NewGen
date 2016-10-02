package commons.model.map.constraints;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 02/10/2016.
 */
public class MapConstraintTest {

  private MapConstraint<EKeyTest> mapConstraint;

  @Before
  public void setUp() throws Exception {
    mapConstraint = new MapConstraint<>();
  }

  @Test
  public void constraintShouldBeUpdatedAfterBeingPut() {
    assertThat(mapConstraint).isEmpty();

    mapConstraint.put(EKeyTest.A, 10);

    assertThat(mapConstraint.get(EKeyTest.A)).isEqualTo(10);
  }

  private enum EKeyTest implements IMapDrawKey {
    A
  }
}
