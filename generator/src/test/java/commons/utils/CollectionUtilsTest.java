package commons.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static commons.utils.CollectionUtils.setMaxSizeSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Germain on 13/06/2016.
 */
public class CollectionUtilsTest {

  private Set<Integer> set;

  @Test
  public void testAddAllValid() {
    set = setMaxSizeSet(new HashSet<>(), 3);
    set.addAll(Arrays.asList(1, 2, 3));
    assertEquals(3, set.size());
    assertTrue(set.contains(1));
    assertTrue(set.contains(2));
    assertTrue(set.contains(3));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testAddAllInvalid() {
    set = setMaxSizeSet(new HashSet<>(), 3);
    set.addAll(Arrays.asList(1, 2, 3, 4));
  }

  @Test
  public void testAddValid() {
    set = setMaxSizeSet(new HashSet<>(), 3);
    set.add(1);
    set.add(2);
    set.add(3);
    assertEquals(3, set.size());
    assertTrue(set.contains(1));
    assertTrue(set.contains(2));
    assertTrue(set.contains(3));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testAddInvalid() {
    set = setMaxSizeSet(new HashSet<>(), 3);
    set.add(1);
    set.add(2);
    set.add(3);
    set.add(4);
  }
}

