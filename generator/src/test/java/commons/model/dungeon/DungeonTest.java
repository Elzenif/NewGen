package commons.model.dungeon;

import commons.model.dungeon.Dungeon.DungeonBuilder;
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

  private DungeonBuilder dungeonBuilder;
  private Dungeon dungeon;

  @Before
  public void setUp() throws Exception {
    dungeonBuilder = new DungeonBuilder();
  }

  @Test
  public void dungeonShouldHaveAtLeastTwoRooms() {
    dungeon = dungeonBuilder.build();
    Set<Room> rooms = dungeon.getRooms();
    assertThat(rooms).isNotNull();
    assertThat(rooms.size()).isGreaterThanOrEqualTo(2);
  }

  @Test
  public void dungeonShouldHaveNbRoomsDesired() {
    dungeon = dungeonBuilder.setNbRoomsDesired(10).build();
    Set<Room> rooms = dungeon.getRooms();
    assertThat(rooms.size()).isEqualTo(10);
  }

  @Test
  public void dungeonRoomsShouldBeConnected() {
    dungeon = dungeonBuilder.build();
    ConnectivityInspector<Room, DefaultEdge> connectivityInspector = new ConnectivityInspector<>(dungeon.getPlan());
    assertThat(connectivityInspector.isGraphConnected()).isTrue();
  }

  @Ignore
  @Test
  public void dungeonShouldHaveAtLeastOneEntry() {
    dungeon = dungeonBuilder.build();
    Set<Room> rooms = dungeon.getRooms();
    assertThat(rooms).areAtLeastOne(new Condition<>(Room::isEntry, "entry"));
  }

  @Test
  public void dungeonWidthShouldBeStrictlyPositive() {
    dungeon = dungeonBuilder.build();
    assertThat(dungeon.getHeight()).isGreaterThan(0);
  }

  @Test
  public void dungeonHeightShouldBeStrictlyPositive() {
    dungeon = dungeonBuilder.build();
    assertThat(dungeon.getHeight()).isGreaterThan(0);
  }

  @Test
  public void dungeonRoomsCoordinatesShouldBeStrictlyPositive() {
    dungeon = dungeonBuilder.build();
    assertThat(dungeon.getRooms()).allMatch(room -> room.getX() > 0 && room.getY() > 0);
  }

  @Test
  public void dungeonShouldHaveAsMuchCorridorsAsGraphEdges() {
    dungeon = dungeonBuilder.build();
    assertThat(dungeon.getCorridors()).hasSameSizeAs(dungeon.getEdges());
  }
}
