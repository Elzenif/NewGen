package commons.model.map;

import commons.model.map.constraints.EDungeonDraw;
import commons.model.map.constraints.MapConstraint;
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
public class NbkDungeonTest {

  private NbkDungeon dungeon;
  private MapConstraint<EDungeonDraw> mapConstraint;

  @Before
  public void setUp() throws Exception {
    mapConstraint = new MapConstraint<>();
  }

  @Test
  public void dungeonShouldHaveAtLeastTwoRooms() {
    dungeon = NbkDungeon.create(mapConstraint);
    Set<Room> rooms = dungeon.getRooms();
    assertThat(rooms).isNotNull();
    assertThat(rooms.size()).isGreaterThanOrEqualTo(2);
  }

  @Test
  public void dungeonShouldHaveNbRoomsDesired() {
    mapConstraint.put(NB_ROOMS, 10);
    dungeon = NbkDungeon.create(mapConstraint);
    Set<Room> rooms = dungeon.getRooms();
    assertThat(rooms.size()).isEqualTo(10);
  }

  @Test
  public void dungeonRoomsShouldBeConnected() {
    dungeon = NbkDungeon.create(mapConstraint);
    ConnectivityInspector<Room, DefaultEdge> connectivityInspector = new ConnectivityInspector<>(dungeon.getPlan());
    assertThat(connectivityInspector.isGraphConnected()).isTrue();
  }

  @Ignore
  @Test
  public void dungeonShouldHaveAtLeastOneEntry() {
    dungeon = NbkDungeon.create(mapConstraint);
    Set<Room> rooms = dungeon.getRooms();
    assertThat(rooms).areAtLeastOne(new Condition<>(Room::isEntry, "entry"));
  }

  @Test
  public void dungeonWidthShouldBeStrictlyPositive() {
    dungeon = NbkDungeon.create(mapConstraint);
    assertThat(dungeon.getHeight()).isGreaterThan(0);
  }

  @Test
  public void dungeonHeightShouldBeStrictlyPositive() {
    dungeon = NbkDungeon.create(mapConstraint);
    assertThat(dungeon.getHeight()).isGreaterThan(0);
  }

  @Test
  public void dungeonRoomsCoordinatesShouldBeStrictlyPositive() {
    dungeon = NbkDungeon.create(mapConstraint);
    assertThat(dungeon.getRooms()).allMatch(room -> room.getX() > 0 && room.getY() > 0);
  }

  @Test
  public void dungeonShouldHaveAtLeastOneCorridor() {
    dungeon = NbkDungeon.create(mapConstraint);
    assertThat(dungeon.getCorridors().size()).isGreaterThanOrEqualTo(1);
  }
}
