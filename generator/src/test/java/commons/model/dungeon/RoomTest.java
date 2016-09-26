package commons.model.dungeon;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 24/09/2016.
 */
public class RoomTest {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test
  public void getXPlusWidthTest() {
    Room room = new Room(5, 8, 10, 15);
    assertThat(room.getXPlusWidth()).isEqualTo(15);
  }

  @Test
  public void getYPlusHeightTest() {
    Room room = new Room(5, 8, 10, 15);
    assertThat(room.getYPlusHeight()).isEqualTo(23);
  }

  @Test
  public void doesNotOverlapTest1() {
    Room room1 = new Room(0, 0, 10, 10);
    Room room = new Room(10, 10, 10, 10);
    assertThat(room.doesOverlap(room1)).isFalse();
  }

  @Test
  public void doesNotOverlapTest2() {
    Room room1 = new Room(0, 0, 10, 10);
    Room room = new Room(9, 9, 10, 10);
    assertThat(room.doesOverlap(room1)).isTrue();
  }

  @Test
  public void doesNotOverlapTest3() {
    Room room1 = new Room(9, 9, 10, 10);
    Room room = new Room(0, 0, 10, 10);
    assertThat(room.doesOverlap(room1)).isTrue();
  }

  @Test
  public void roomCenterTest() {
    Room room = new Room(5, 14, 12, 28);
    softly.assertThat(room.getCenterX()).isEqualTo(11);
    softly.assertThat(room.getCenterY()).isEqualTo(28);
  }

  @Test
  public void comparisonTest() {
    Room room1 = new Room(0, 0, 1, 10);
    Room room2 = new Room(5, 5, 10, 1);
    Room room3 = new Room(2, 2, 3, 4);
    Set<Room> rooms = new TreeSet<>();
    rooms.add(room1);
    rooms.add(room2);
    rooms.add(room3);
    assertThat(rooms).containsExactly(room3, room1, room2);
  }

  @Test
  public void moveFromRoomThatIsUp_ShouldGoDown() {
    Room room1 = new Room(0, 0, 10, 10);
    Room room2 = new Room(0, 5, 8, 10);
    room2.moveFrom(room1);
    softly.assertThat(room1.getCenterX()).isEqualTo(5);
    softly.assertThat(room1.getCenterY()).isEqualTo(5);
    softly.assertThat(room2.getCenterX()).isEqualTo(4);
    softly.assertThat(room2.getCenterY()).isEqualTo(15);
    softly.assertThat(room2.getVerticalDirection()).isEqualTo(Room.VD.DOWN);
    softly.assertThat(room2.getHorizontalDirection()).isEqualTo(Room.HD.LEFT);
  }

  @Test
  public void moveFromRoomThatIsLeft_ShouldGoRight() {
    Room room1 = new Room(0, 0, 10, 10);
    Room room2 = new Room(8, 5, 10, 10);
    room2.moveFrom(room1);
    softly.assertThat(room1.getCenterX()).isEqualTo(5);
    softly.assertThat(room1.getCenterY()).isEqualTo(5);
    softly.assertThat(room2.getCenterX()).isEqualTo(15);
    softly.assertThat(room2.getCenterY()).isEqualTo(10);
    softly.assertThat(room2.getVerticalDirection()).isEqualTo(Room.VD.DOWN);
    softly.assertThat(room2.getHorizontalDirection()).isEqualTo(Room.HD.RIGHT);
  }

  @Test
  public void moveFromRoomThatIsDown_ShouldGoUp() {
    Room room1 = new Room(0, 0, 10, 10);
    Room room2 = new Room(0, 5, 8, 10);
    room1.moveFrom(room2);
    softly.assertThat(room1.getCenterX()).isEqualTo(5);
    softly.assertThat(room1.getCenterY()).isEqualTo(0);
    softly.assertThat(room1.getVerticalDirection()).isEqualTo(Room.VD.UP);
    softly.assertThat(room1.getHorizontalDirection()).isEqualTo(Room.HD.RIGHT);
    softly.assertThat(room2.getCenterX()).isEqualTo(4);
    softly.assertThat(room2.getCenterY()).isEqualTo(10);
  }

  @Test
  public void moveFromRoomThatIsRight_ShouldGoLeft() {
    Room room1 = new Room(0, 0, 10, 10);
    Room room2 = new Room(8, 5, 10, 10);
    room1.moveFrom(room2);
    softly.assertThat(room1.getCenterX()).isEqualTo(3);
    softly.assertThat(room1.getCenterY()).isEqualTo(5);
    softly.assertThat(room1.getVerticalDirection()).isEqualTo(Room.VD.UP);
    softly.assertThat(room1.getHorizontalDirection()).isEqualTo(Room.HD.LEFT);
    softly.assertThat(room2.getCenterX()).isEqualTo(13);
    softly.assertThat(room2.getCenterY()).isEqualTo(10);
  }

  @Test
  public void moveFromRoomThatIsUp_ShouldGoLeft() {
    Room room1 = new Room(0, 0, 10, 10);
    Room room2 = new Room(0, 5, 8, 10);
    room2.setVerticalDirection(Room.VD.UP);
    room2.moveFrom(room1);
    softly.assertThat(room1.getCenterX()).isEqualTo(5);
    softly.assertThat(room1.getCenterY()).isEqualTo(5);
    softly.assertThat(room2.getCenterX()).isEqualTo(-4);
    softly.assertThat(room2.getCenterY()).isEqualTo(10);
    softly.assertThat(room2.getVerticalDirection()).isEqualTo(Room.VD.UP);
    softly.assertThat(room2.getHorizontalDirection()).isEqualTo(Room.HD.LEFT);
  }

  @Test
  public void moveFromRoomThatIsLeft_ShouldGoDown() {
    Room room1 = new Room(0, 0, 10, 10);
    Room room2 = new Room(8, 5, 10, 10);
    room2.setHorizontalDirection(Room.HD.LEFT);
    room2.moveFrom(room1);
    softly.assertThat(room1.getCenterX()).isEqualTo(5);
    softly.assertThat(room1.getCenterY()).isEqualTo(5);
    softly.assertThat(room2.getCenterX()).isEqualTo(13);
    softly.assertThat(room2.getCenterY()).isEqualTo(15);
    softly.assertThat(room2.getVerticalDirection()).isEqualTo(Room.VD.DOWN);
    softly.assertThat(room2.getHorizontalDirection()).isEqualTo(Room.HD.LEFT);
  }

  @Test
  public void moveFromRoomThatIsDown_ShouldGoRight() {
    Room room1 = new Room(0, 0, 10, 10);
    room1.setVerticalDirection(Room.VD.DOWN);
    Room room2 = new Room(0, 5, 8, 10);
    room1.moveFrom(room2);
    softly.assertThat(room1.getCenterX()).isEqualTo(13);
    softly.assertThat(room1.getCenterY()).isEqualTo(5);
    softly.assertThat(room1.getVerticalDirection()).isEqualTo(Room.VD.DOWN);
    softly.assertThat(room1.getHorizontalDirection()).isEqualTo(Room.HD.RIGHT);
    softly.assertThat(room2.getCenterX()).isEqualTo(4);
    softly.assertThat(room2.getCenterY()).isEqualTo(10);
  }

  @Test
  public void moveFromRoomThatIsRight_ShouldGoUp() {
    Room room1 = new Room(0, 0, 10, 10);
    room1.setHorizontalDirection(Room.HD.RIGHT);
    Room room2 = new Room(8, 5, 10, 10);
    room1.moveFrom(room2);
    softly.assertThat(room1.getCenterX()).isEqualTo(5);
    softly.assertThat(room1.getCenterY()).isEqualTo(0);
    softly.assertThat(room1.getVerticalDirection()).isEqualTo(Room.VD.UP);
    softly.assertThat(room1.getHorizontalDirection()).isEqualTo(Room.HD.RIGHT);
    softly.assertThat(room2.getCenterX()).isEqualTo(13);
    softly.assertThat(room2.getCenterY()).isEqualTo(10);
  }

  @Test
  public void moveFromRoomThatIsUp_ShouldGoRight() {
    Room room1 = new Room(0, 0, 8, 10);
    Room room2 = new Room(0, 5, 10, 10);
    room2.setVerticalDirection(Room.VD.UP);
    room2.moveFrom(room1);
    softly.assertThat(room1.getCenterX()).isEqualTo(4);
    softly.assertThat(room1.getCenterY()).isEqualTo(5);
    softly.assertThat(room2.getCenterX()).isEqualTo(13);
    softly.assertThat(room2.getCenterY()).isEqualTo(10);
    softly.assertThat(room2.getVerticalDirection()).isEqualTo(Room.VD.UP);
    softly.assertThat(room2.getHorizontalDirection()).isEqualTo(Room.HD.RIGHT);
  }

  @Test
  public void moveFromRoomThatIsLeft_ShouldGoUp() {
    Room room1 = new Room(0, 0, 10, 30);
    Room room2 = new Room(8, 5, 10, 10);
    room2.setHorizontalDirection(Room.HD.LEFT);
    room2.moveFrom(room1);
    softly.assertThat(room1.getCenterX()).isEqualTo(5);
    softly.assertThat(room1.getCenterY()).isEqualTo(15);
    softly.assertThat(room2.getCenterX()).isEqualTo(13);
    softly.assertThat(room2.getCenterY()).isEqualTo(-5);
    softly.assertThat(room2.getVerticalDirection()).isEqualTo(Room.VD.UP);
    softly.assertThat(room2.getHorizontalDirection()).isEqualTo(Room.HD.LEFT);
  }

  @Test
  public void moveFromRoomThatIsDown_ShouldGoLeft() {
    Room room1 = new Room(0, 0, 8, 10);
    room1.setVerticalDirection(Room.VD.DOWN);
    Room room2 = new Room(0, 5, 10, 10);
    room1.moveFrom(room2);
    softly.assertThat(room1.getCenterX()).isEqualTo(-4);
    softly.assertThat(room1.getCenterY()).isEqualTo(5);
    softly.assertThat(room1.getVerticalDirection()).isEqualTo(Room.VD.DOWN);
    softly.assertThat(room1.getHorizontalDirection()).isEqualTo(Room.HD.LEFT);
    softly.assertThat(room2.getCenterX()).isEqualTo(5);
    softly.assertThat(room2.getCenterY()).isEqualTo(10);
  }

  @Test
  public void moveFromRoomThatIsRight_ShouldGoDown() {
    Room room1 = new Room(0, 0, 10, 30);
    room1.setHorizontalDirection(Room.HD.RIGHT);
    Room room2 = new Room(8, 5, 10, 10);
    room1.moveFrom(room2);
    softly.assertThat(room1.getCenterX()).isEqualTo(5);
    softly.assertThat(room1.getCenterY()).isEqualTo(30);
    softly.assertThat(room1.getVerticalDirection()).isEqualTo(Room.VD.DOWN);
    softly.assertThat(room1.getHorizontalDirection()).isEqualTo(Room.HD.RIGHT);
    softly.assertThat(room2.getCenterX()).isEqualTo(13);
    softly.assertThat(room2.getCenterY()).isEqualTo(10);
  }

  @Test
  public void moveFromRoomThatIsUp_ShouldGoUp() {
    Room room1 = new Room(0, 0, 10, 10);
    Room room2 = new Room(-50, 5, 100, 10);
    room2.setVerticalDirection(Room.VD.UP);
    room2.moveFrom(room1);
    softly.assertThat(room1.getCenterX()).isEqualTo(5);
    softly.assertThat(room1.getCenterY()).isEqualTo(5);
    softly.assertThat(room2.getCenterX()).isEqualTo(0);
    softly.assertThat(room2.getCenterY()).isEqualTo(-5);
    softly.assertThat(room2.getVerticalDirection()).isEqualTo(Room.VD.UP);
    softly.assertThat(room2.getHorizontalDirection()).isEqualTo(Room.HD.LEFT);
  }

  @Test
  public void moveFromRoomThatIsLeft_ShouldGoLeft() {
    Room room1 = new Room(0, 0, 10, 10);
    Room room2 = new Room(8, -50, 10, 100);
    room2.setHorizontalDirection(Room.HD.LEFT);
    room2.moveFrom(room1);
    softly.assertThat(room1.getCenterX()).isEqualTo(5);
    softly.assertThat(room1.getCenterY()).isEqualTo(5);
    softly.assertThat(room2.getCenterX()).isEqualTo(-5);
    softly.assertThat(room2.getCenterY()).isEqualTo(0);
    softly.assertThat(room2.getVerticalDirection()).isEqualTo(Room.VD.UP);
    softly.assertThat(room2.getHorizontalDirection()).isEqualTo(Room.HD.LEFT);
  }

  @Test
  public void moveFromRoomThatIsDown_ShouldGoDown() {
    Room room1 = new Room(-50, 0, 100, 10);
    room1.setVerticalDirection(Room.VD.DOWN);
    Room room2 = new Room(0, 5, 8, 10);
    room1.moveFrom(room2);
    softly.assertThat(room1.getCenterX()).isEqualTo(0);
    softly.assertThat(room1.getCenterY()).isEqualTo(20);
    softly.assertThat(room1.getVerticalDirection()).isEqualTo(Room.VD.DOWN);
    softly.assertThat(room1.getHorizontalDirection()).isEqualTo(Room.HD.LEFT);
    softly.assertThat(room2.getCenterX()).isEqualTo(4);
    softly.assertThat(room2.getCenterY()).isEqualTo(10);
  }

  @Test
  public void moveFromRoomThatIsRight_ShouldGoRight() {
    Room room1 = new Room(0, -50, 10, 100);
    room1.setHorizontalDirection(Room.HD.RIGHT);
    Room room2 = new Room(8, 5, 10, 10);
    room1.moveFrom(room2);
    softly.assertThat(room1.getCenterX()).isEqualTo(23);
    softly.assertThat(room1.getCenterY()).isEqualTo(0);
    softly.assertThat(room1.getVerticalDirection()).isEqualTo(Room.VD.UP);
    softly.assertThat(room1.getHorizontalDirection()).isEqualTo(Room.HD.RIGHT);
    softly.assertThat(room2.getCenterX()).isEqualTo(13);
    softly.assertThat(room2.getCenterY()).isEqualTo(10);
  }

}
