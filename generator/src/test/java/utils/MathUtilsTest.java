package utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Germain on 04/06/2016.
 */
public class MathUtilsTest {

  @Test
  public void testRandom() {
    for (int i = 0; i < 100; i++) {
      int r = MathUtils.random(i, 2*i+1);
      assertTrue(i <= r && r <= 2*i+1);
    }
  }

  @Test
  public void testChooseRandom() {
    List<String> list = new LinkedList<>(Arrays.asList("1a", "2b", "3c"));
    assertTrue("The list should contain the chose element", list.contains(MathUtils.chooseRandom(list)));
  }
}
