package commons.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 22/07/2016.
 */
public class EOperatorTest {

  @Test
  public void oneLessThanTwo() {
    assertThat(EOperator.LT.apply(1, 2)).isTrue();
  }
  
  @Test
  public void twoNotLessThanOne() {
    assertThat(EOperator.LT.apply(2, 1)).isFalse();
  }

  @Test
  public void oneNotLessThanOne() {
    assertThat(EOperator.LT.apply(1, 1)).isFalse();
  }

  @Test
  public void twoGreaterThanOne() {
    assertThat(EOperator.GT.apply(2, 1)).isTrue();
  }

  @Test
  public void oneNotGreaterThanTwo() {
    assertThat(EOperator.GT.apply(1, 2)).isFalse();
  }

  @Test
  public void oneNotGreaterThanOne() {
    assertThat(EOperator.GT.apply(1, 1)).isFalse();
  }

  @Test
  public void oneLessOrEqualsThanTwo() {
    assertThat(EOperator.LTE.apply(1, 2)).isTrue();
  }

  @Test
  public void twoNotLessOrEqualsThanOne() {
    assertThat(EOperator.LTE.apply(2, 1)).isFalse();
  }

  @Test
  public void oneLessOrEqualsThanOne() {
    assertThat(EOperator.LTE.apply(1, 1)).isTrue();
  }

  @Test
  public void twoGreaterOrEqualsThanOne() {
    assertThat(EOperator.GTE.apply(2, 1)).isTrue();
  }

  @Test
  public void oneNotGreaterOrEqualsThanTwo() {
    assertThat(EOperator.GTE.apply(1, 2)).isFalse();
  }

  @Test
  public void oneGreaterOrEqualsThanOne() {
    assertThat(EOperator.GTE.apply(1, 1)).isTrue();
  }


}
