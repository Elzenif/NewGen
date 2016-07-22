package commons.utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Germain on 22/07/2016.
 */
public class EOperatorTest {

  @Test
  public void oneLessThanTwo() {
    assertTrue(EOperator.LT.apply(1, 2));
  }
  
  @Test
  public void twoNotLessThanOne() {
    assertFalse(EOperator.LT.apply(2, 1));
  }

  @Test
  public void oneNotLessThanOne() {
    assertFalse(EOperator.LT.apply(1, 1));
  }

  @Test
  public void twoGreaterThanOne() {
    assertTrue(EOperator.GT.apply(2, 1));
  }

  @Test
  public void oneNotGreaterThanTwo() {
    assertFalse(EOperator.GT.apply(1, 2));
  }

  @Test
  public void oneNotGreaterThanOne() {
    assertFalse(EOperator.GT.apply(1, 1));
  }

  @Test
  public void oneLessOrEqualsThanTwo() {
    assertTrue(EOperator.LTE.apply(1, 2));
  }

  @Test
  public void twoNotLessOrEqualsThanOne() {
    assertFalse(EOperator.LTE.apply(2, 1));
  }

  @Test
  public void oneLessOrEqualsThanOne() {
    assertTrue(EOperator.LTE.apply(1, 1));
  }

  @Test
  public void twoGreaterOrEqualsThanOne() {
    assertTrue(EOperator.GTE.apply(2, 1));
  }

  @Test
  public void oneNotGreaterOrEqualsThanTwo() {
    assertFalse(EOperator.GTE.apply(1, 2));
  }

  @Test
  public void oneGreaterOrEqualsThanOne() {
    assertTrue(EOperator.GTE.apply(1, 1));
  }


}
