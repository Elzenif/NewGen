package commons.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static commons.utils.CollectionUtils.setMaxSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Germain on 13/06/2016.
 */
public class CollectionUtilsTest {

  private List<Integer> list;

  @Test
  public void testAddAllValid() {
    list = setMaxSize(new ArrayList<>(), 3);
    list.addAll(Arrays.asList(1, 2, 3));
    assertEquals(3, list.size());
    assertTrue(list.contains(1));
    assertTrue(list.contains(2));
    assertTrue(list.contains(3));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testAddAllInvalid() {
    list = setMaxSize(new ArrayList<>(), 3);
    list.addAll(Arrays.asList(1, 2, 3, 4));
  }

  @Test
  public void testAddValid() {
    list = setMaxSize(new ArrayList<>(), 3);
    list.add(1);
    list.add(2);
    list.add(3);
    assertEquals(3, list.size());
    assertTrue(list.contains(1));
    assertTrue(list.contains(2));
    assertTrue(list.contains(3));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testAddInvalid() {
    list = setMaxSize(new ArrayList<>(), 3);
    list.add(1);
    list.add(1);
    list.add(1);
    list.add(1);
  }
}

