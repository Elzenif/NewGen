package commons.model.utility;

import commons.utils.exception.ForbiddenValueException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 01/10/2016.
 */
public class UtilityConstraintTest {

  private UtilityConstraint utilityConstraint;

  @Before
  public void setUp() throws Exception {
    utilityConstraint = new UtilityConstraint();
  }

  @Test
  public void constraintShouldBeUpdatedAfterBeingPut() {
    utilityConstraint.put(EKeyTest.A, 10);

    assertThat(utilityConstraint.get(EKeyTest.A)).isEqualTo(10);
  }

  @Test(expected = ForbiddenValueException.class)
  public void constraintValueShouldBeAtLeast1() {
    utilityConstraint.put(EKeyTest.A, 0);
  }

  @Test(expected = ForbiddenValueException.class)
  public void constraintValueShouldBeAtMost20() {
    utilityConstraint.put(EKeyTest.A, 21);
  }

  @Test
  public void ifValueIsNotInTheMapShouldReturnRandom() {
    assertThat(utilityConstraint).isEmpty();
    assertThat(utilityConstraint.get(EKeyTest.A)).isNotNull().isBetween(1, 20);
  }

  private enum EKeyTest implements IUtilityDrawKey {
    A
  }
}
