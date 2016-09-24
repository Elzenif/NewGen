package commons.model.dungeon;

import commons.utils.exception.ForbiddenValueException;
import org.junit.Test;

/**
 * Created by Germain on 24/09/2016.
 */
public class RoomTest {

  @Test(expected = ForbiddenValueException.class)
  public void roomWidthShouldBeStrictlyPositive() {
    new Room("", false, 0, 0, -1, 10);
  }

  @Test(expected = ForbiddenValueException.class)
  public void roomHeightShouldBeStrictlyPositive() {
    new Room("", false, 0, 0, 12, -1);
  }

  @Test(expected = ForbiddenValueException.class)
  public void roomAbscissaShouldBePositive() {
    new Room("", false, -1, 0, 12, 10);
  }

  @Test(expected = ForbiddenValueException.class)
  public void roomOrdinateShouldBePositive() {
    new Room("", false, 0, -1, 12, 10);
  }

  @Test(expected = ForbiddenValueException.class)
  public void roomAbscissaShouldBePositive2() {
    Room room = new Room("", false, 5, 5, 5, 5);
    room.reduceXBy(6);
  }

  @Test(expected = ForbiddenValueException.class)
  public void roomOrdinateShouldBePositive2() {
    Room room = new Room("", false, 5, 5, 5, 5);
    room.reduceYBy(6);
  }
}
