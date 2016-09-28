package commons.model.dungeon;

import org.assertj.core.api.Condition;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 24/09/2016.
 */
public class DungeonTest {

  private Dungeon dungeon;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void dungeonShouldHaveAtLeastTwoRooms() {
    dungeon = new Dungeon(10);
    Set<Room> rooms = dungeon.getRooms();
    assertThat(rooms).isNotNull();
    assertThat(rooms.size()).isGreaterThanOrEqualTo(2).isEqualTo(10);
  }

  @Test
  public void dungeonRoomsShouldBeConnected() {
    dungeon = new Dungeon(10);
    ConnectivityInspector<Room, DefaultEdge> connectivityInspector = new ConnectivityInspector<>(dungeon.getPlan());
    assertThat(connectivityInspector.isGraphConnected()).isTrue();
  }

  @Ignore
  @Test
  public void dungeonShouldHaveAtLeastOneEntry() {
    dungeon = new Dungeon(10);
    Set<Room> rooms = dungeon.getRooms();
    assertThat(rooms).areAtLeastOne(new Condition<>(Room::isEntry, "entry"));
  }

  @Test
  public void dungeonWidthShouldBeStrictlyPositive() {
    dungeon = new Dungeon(10);
    assertThat(dungeon.getHeight()).isGreaterThan(0);
  }

  @Test
  public void dungeonHeightShouldBeStrictlyPositive() {
    dungeon = new Dungeon(10);
    assertThat(dungeon.getHeight()).isGreaterThan(0);
  }

  @Test
  public void dungeonRoomsCoordinatesShouldBeStrictlyPositive() {
    dungeon = new Dungeon(10);
    assertThat(dungeon.getRooms()).allMatch(room -> room.getX() > 0 && room.getY() > 0);
  }
}
