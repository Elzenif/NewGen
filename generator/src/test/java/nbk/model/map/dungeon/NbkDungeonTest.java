package nbk.model.map.dungeon;

import commons.model.map.Room;
import commons.model.map.constraints.MapConstraint;
import nbk.model.map.dungeon.NbkDungeon.DungeonBuilder;
import nbk.model.map.dungeon.constraints.EDungeonDraw;
import nbk.model.map.dungeon.constraints.EDungeonRadius;
import org.assertj.core.api.Condition;
import org.assertj.core.api.JUnitSoftAssertions;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.util.Set;

import static nbk.model.map.dungeon.constraints.EDungeonDraw.NB_ROOMS;
import static nbk.model.map.dungeon.constraints.EDungeonDraw.RADIUS;
import static nbk.model.map.dungeon.constraints.EDungeonDraw.TILE_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 24/09/2016.
 */
public class NbkDungeonTest {

  @Rule
  public JUnitSoftAssertions softly = new JUnitSoftAssertions();

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
    assertThat(rooms).areAtLeastOne(new Condition<>(Room::isEntry, "entry")); //NON-NLS
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

  @Test
  public void dungeonDefaultValuesShouldBeValid() {
    DungeonBuilder dungeonBuilder = new DungeonBuilder(mapConstraint);
    softly.assertThat(dungeonBuilder.getNbRoomsDesired()).isEqualTo(NB_ROOMS.getDefaultValue());
    softly.assertThat(dungeonBuilder.getTileSize()).isEqualTo(TILE_SIZE.getDefaultValue());
    softly.assertThat(dungeonBuilder.getRadius()).isEqualTo(((EDungeonRadius) RADIUS.getDefaultValue()).getValue());
  }

  @Test
  public void dungeonBuilderShouldHaveNbRoomsDesired() {
    for (Object nbRoom : NB_ROOMS.getDrawValues()) {
      mapConstraint.put(NB_ROOMS, nbRoom);
      DungeonBuilder dungeonBuilder = new DungeonBuilder(mapConstraint);
      assertThat(dungeonBuilder.getNbRoomsDesired()).isEqualTo(nbRoom);
    }
  }

  @Test
  public void dungeonBuilderShouldHaveTileSizeDesired() {
    for (Object tileSize : TILE_SIZE.getDrawValues()) {
      mapConstraint.put(TILE_SIZE, tileSize);
      DungeonBuilder dungeonBuilder = new DungeonBuilder(mapConstraint);
      assertThat(dungeonBuilder.getTileSize()).isEqualTo(tileSize);
    }
  }

  @Test
  public void dungeonBuilderShouldHaveRadiusDesired() {
    for (Object radius : RADIUS.getDrawValues()) {
      mapConstraint.put(RADIUS, radius);
      DungeonBuilder dungeonBuilder = new DungeonBuilder(mapConstraint);
      assertThat(dungeonBuilder.getRadius()).isEqualTo(((EDungeonRadius) radius).getValue());
    }
  }
}
