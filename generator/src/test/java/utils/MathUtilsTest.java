package utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.MathUtils.chooseRandom;
import static utils.MathUtils.findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues;

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
    assertTrue("The list should contain the chose element", list.contains(chooseRandom(list)));
  }

  @Test
  public void testFindFirstValid() {
    Map<String, Integer> map = new HashMap<>();
    map.put("a", 5);
    map.put("b", 3);
    map.put("c", 8);
    map.put("d", 4);
    assertEquals("c", findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues(10, map));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFindFirstInvalid() {
    Map<String, Integer> map = new HashMap<>();
    map.put("a", 1);
    map.put("b", 2);
    map.put("c", 3);
    map.put("d", 4);
    findFirstKeySuchAsIntegerIsLowerThanSumOfPrecedentValues(11, map);
  }
}
