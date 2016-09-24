package commons.model.dungeon;

import commons.utils.exception.ForbiddenValueException;
import org.junit.Test;

/**
 * Created by Germain on 24/09/2016.
 */
public class RoomTest {

  @Test(expected = ForbiddenValueException.class)
  public void roomWidthShouldBeStrictlyPositive() {
    Room room = new Room("", false, -1, 10);
  }

  @Test(expected = ForbiddenValueException.class)
  public void roomHeightShouldBeStrictlyPositive() {
    Room room = new Room("", false, 12, -1);
  }
}
