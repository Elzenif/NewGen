package generator.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 28/05/2017.
 */
public class GeneratorUtilsTest {

  @Test(expected = IllegalArgumentException.class)
  public void getMultiplierError1() {
    GeneratorUtils.getMultiplier("1d3a20");
  }

  @Test(expected = IllegalArgumentException.class)
  public void getMultiplierError2() {
    GeneratorUtils.getMultiplier("2d3d3xas");
  }

  @Test(expected = IllegalArgumentException.class)
  public void getMultiplierError3() {
    GeneratorUtils.getMultiplier("2dxas");
  }

  @Test
  public void getMultiplierFromInt() {
    int multiplier = GeneratorUtils.getMultiplier("3xaaa").getLeft();
    assertThat(multiplier).isEqualTo(3);
  }

  @Test
  public void getMultiplierFromDice() {
    int multiplier = GeneratorUtils.getMultiplier("4d4xgrxa s").getLeft();
    assertThat(multiplier).isBetween(4, 16);
  }

}