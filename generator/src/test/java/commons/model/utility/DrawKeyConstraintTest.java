package commons.model.utility;

import commons.model.utility.constraints.DrawKeyConstraint;
import commons.model.utility.constraints.IUtilityDrawKey;
import commons.utils.exception.ForbiddenValueException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 01/10/2016.
 */
public class DrawKeyConstraintTest {

  private DrawKeyConstraint drawKeyConstraint;

  @Before
  public void setUp() throws Exception {
    drawKeyConstraint = new DrawKeyConstraint();
  }

  @Test
  public void constraintShouldBeUpdatedAfterBeingPut() {
    drawKeyConstraint.put(EKeyTest.A, 10);

    assertThat(drawKeyConstraint.get(EKeyTest.A)).isEqualTo(10);
  }

  @Test(expected = ForbiddenValueException.class)
  public void constraintValueShouldBeAtLeast1() {
    drawKeyConstraint.put(EKeyTest.A, 0);
  }

  @Test(expected = ForbiddenValueException.class)
  public void constraintValueShouldBeAtMost20() {
    drawKeyConstraint.put(EKeyTest.A, 21);
  }

  @Test
  public void ifValueIsNotInTheMapShouldReturnRandom() {
    assertThat(drawKeyConstraint).isEmpty();
    assertThat(drawKeyConstraint.get(EKeyTest.A)).isNotNull().isBetween(1, 20);
  }

  private enum EKeyTest implements IUtilityDrawKey {
    A
  }
}
