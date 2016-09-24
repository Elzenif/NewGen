package commons.model.dungeon;

import org.assertj.core.api.Condition;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.junit.Before;
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
    dungeon = new Dungeon();
  }

  @Test
  public void dungeonShouldHaveAtLeastTwoRooms() {
    Set<Room> rooms = dungeon.getRooms();
    assertThat(rooms).isNotNull();
    assertThat(rooms.size()).isGreaterThanOrEqualTo(2);
  }

  @Test
  public void dungeonRoomsShouldBeConnected() {
    ConnectivityInspector<Room, DefaultEdge> connectivityInspector = new ConnectivityInspector<>(dungeon.getPlan());
    assertThat(connectivityInspector.isGraphConnected()).isTrue();
  }

  @Test
  public void dungeonShouldHaveAtLeastOneEntry() {
    Set<Room> rooms = dungeon.getRooms();
    assertThat(rooms).areAtLeastOne(new Condition<>(Room::isEntry, "entry"));
  }

  @Test
  public void dungeonWidthShouldBeStrictlyPositive() {
    assertThat(dungeon.getWidth()).isGreaterThan(0);
    assertThat(dungeon.getHeight()).isGreaterThan(0);
  }
}
