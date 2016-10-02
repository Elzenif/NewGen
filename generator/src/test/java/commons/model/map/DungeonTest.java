package commons.model.map;

import commons.model.map.constraints.DungeonConstraint;
import commons.model.map.constraints.EDungeonDraw;
import org.assertj.core.api.Condition;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Set;

import static commons.model.map.constraints.EDungeonDraw.NB_ROOMS;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 24/09/2016.
 */
public class DungeonTest {

  private Dungeon dungeon;
  private DungeonConstraint<EDungeonDraw> dungeonConstraint;

  @Before
  public void setUp() throws Exception {
    dungeonConstraint = new DungeonConstraint<>();
  }

  @Test
  public void dungeonShouldHaveAtLeastTwoRooms() {
    dungeon = Dungeon.create(dungeonConstraint);
    Set<Room> rooms = dungeon.getRooms();
    assertThat(rooms).isNotNull();
    assertThat(rooms.size()).isGreaterThanOrEqualTo(2);
  }

  @Test
  public void dungeonShouldHaveNbRoomsDesired() {
    dungeonConstraint.put(NB_ROOMS, 10);
    dungeon = Dungeon.create(dungeonConstraint);
    Set<Room> rooms = dungeon.getRooms();
    assertThat(rooms.size()).isEqualTo(10);
  }

  @Test
  public void dungeonRoomsShouldBeConnected() {
    dungeon = Dungeon.create(dungeonConstraint);
    ConnectivityInspector<Room, DefaultEdge> connectivityInspector = new ConnectivityInspector<>(dungeon.getPlan());
    assertThat(connectivityInspector.isGraphConnected()).isTrue();
  }

  @Ignore
  @Test
  public void dungeonShouldHaveAtLeastOneEntry() {
    dungeon = Dungeon.create(dungeonConstraint);
    Set<Room> rooms = dungeon.getRooms();
    assertThat(rooms).areAtLeastOne(new Condition<>(Room::isEntry, "entry"));
  }

  @Test
  public void dungeonWidthShouldBeStrictlyPositive() {
    dungeon = Dungeon.create(dungeonConstraint);
    assertThat(dungeon.getHeight()).isGreaterThan(0);
  }

  @Test
  public void dungeonHeightShouldBeStrictlyPositive() {
    dungeon = Dungeon.create(dungeonConstraint);
    assertThat(dungeon.getHeight()).isGreaterThan(0);
  }

  @Test
  public void dungeonRoomsCoordinatesShouldBeStrictlyPositive() {
    dungeon = Dungeon.create(dungeonConstraint);
    assertThat(dungeon.getRooms()).allMatch(room -> room.getX() > 0 && room.getY() > 0);
  }

  @Test
  public void dungeonShouldHaveAtLeastOneCorridor() {
    dungeon = Dungeon.create(dungeonConstraint);
    assertThat(dungeon.getCorridors().size()).isGreaterThanOrEqualTo(1);
  }
}
