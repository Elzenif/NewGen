package nbk.model.map.dungeon;

import commons.model.commons.IDrawKey;
import commons.model.commons.constraints.MapConstraint;
import commons.model.map.EMapPart;
import commons.model.map.Grid;
import commons.model.map.Room;
import commons.utils.MathUtils;
import commons.utils.Pair;
import nbk.model.map.dungeon.constraints.EDungeonDraw;
import nbk.model.map.dungeon.constraints.EDungeonRadius;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static nbk.model.map.dungeon.constraints.EDungeonDraw.NB_ROOMS;
import static nbk.model.map.dungeon.constraints.EDungeonDraw.RADIUS;
import static nbk.model.map.dungeon.constraints.EDungeonDraw.TILE_SIZE;

/**
 * Created by Germain on 24/09/2016.
 */
public class NbkDungeon {

  private final UndirectedGraph<Room, DefaultEdge> plan;
  private final Set<Rectangle> corridors;
  private final int nbRoomsDesired;
  private final int tileSize;
  private final int deviation;
  private final int mean;
  private final int radius;
  private final int factor;
  private final int corridorWidth;
  private Grid grid;
  private int width;
  private int height;

  private NbkDungeon(DungeonBuilder builder) {
    plan = new SimpleGraph<>(DefaultEdge.class);
    corridors = new HashSet<>();

    nbRoomsDesired = builder.getNbRoomsDesired();
    tileSize = builder.getTileSize();
    deviation = builder.getDeviation();
    mean = builder.getMean();
    radius = builder.getRadius();
    factor = builder.getFactor();
    corridorWidth = builder.getCorridorWidth();

    Queue<Room> overlappingRooms = createRooms(nbRoomsDesired);
    Queue<Room> separatedRooms = separateRooms(overlappingRooms);
    computeWidthAndHeightAndThenAdjustPlacement(separatedRooms);
    Set<Room> mainRooms = extractBiggerRooms(separatedRooms, nbRoomsDesired);
    mainRooms.forEach(plan::addVertex);
    bindRoomsWithRelativeNeighborhoodGraph();
    buildCorridors();
    buildGrid();
  }

  public static NbkDungeon create(MapConstraint mapConstraint) {
    return new DungeonBuilder(mapConstraint).build();
  }

  private void buildGrid() {
    grid = new Grid(width, height, tileSize);
    for (Room room : getRooms()) {
      linkToCells(room.getX(), room.getY(), room.getWidth(), room.getHeight());
    }
    for (Rectangle rectangle : getCorridors()) {
      linkToCells((int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(),
          (int) rectangle.getHeight());
    }
  }

  private void linkToCells(int x, int y, int width, int height) {
    for (int i = x; i < x + width; i += tileSize) {
      for (int j = y; j < y + height; j++) {
        grid.getCell(i, j).setMapPart(EMapPart.SPACE);
      }
    }
  }

  private void buildCorridors() {
    for (DefaultEdge edge : getEdges()) {
      Room source = plan.getEdgeSource(edge);
      Room target = plan.getEdgeTarget(edge);
      Room a, b;
      // a must be to the left of b
      if (source.getCenterX() < target.getCenterX()) {
        a = source;
        b = target;
      } else {
        a = target;
        b = source;
      }
      // the starting points
      int x = a.getCenterX();
      int y = a.getCenterY();
      // the deltas to get from a to b
      int dx = b.getCenterX() - x;
      int dy = b.getCenterY() - y;
      Rectangle horizontalRectangle = new Rectangle();
      Rectangle verticalRectangle = new Rectangle();
      if (MathUtils.nextBoolean()) {
        horizontalRectangle.setBounds(MathUtils.roundM(x, tileSize),
            MathUtils.roundM(y - corridorWidth * tileSize / 2, tileSize), dx, corridorWidth * tileSize);
        if (dy > 0) {
          verticalRectangle.setBounds(MathUtils.roundM(x + dx - corridorWidth * tileSize / 2, tileSize),
              MathUtils.roundM(y - corridorWidth * tileSize / 2, tileSize), corridorWidth * tileSize, dy);
        } else {
          verticalRectangle.setBounds(MathUtils.roundM(x + dx - corridorWidth * tileSize / 2, tileSize),
              MathUtils.roundM(y + dy - corridorWidth * tileSize / 2, tileSize), corridorWidth * tileSize, -dy);
        }
      } else {
        horizontalRectangle.setBounds(MathUtils.roundM(x - corridorWidth * tileSize / 2, tileSize),
            MathUtils.roundM(y + dy - corridorWidth * tileSize / 2, tileSize), dx, corridorWidth * tileSize);
        if (dy > 0) {
          verticalRectangle.setBounds(MathUtils.roundM(x - corridorWidth * tileSize / 2, tileSize),
              MathUtils.roundM(y, tileSize), corridorWidth * tileSize, dy);
        } else {
          verticalRectangle.setBounds(MathUtils.roundM(x - corridorWidth * tileSize / 2, tileSize),
              MathUtils.roundM(y + dy - corridorWidth * tileSize / 2, tileSize), corridorWidth * tileSize, -dy);
        }
      }
      corridors.add(horizontalRectangle);
      corridors.add(verticalRectangle);
    }
  }

  private void bindRoomsWithRelativeNeighborhoodGraph() {
    List<Room> mainRooms = new ArrayList<>(plan.vertexSet());
    boolean skip;
    for (int i = 0; i < mainRooms.size(); i++) {
      Room a = mainRooms.get(i);
      for (int j = i + 1; j < mainRooms.size(); j++) {
        skip = false;
        Room b = mainRooms.get(j);
        double ab = a.distanceFrom(b);
        for (int k = 0; k < mainRooms.size(); k++) {
          if (k == i || k == j) {
            continue;
          }
          Room c = mainRooms.get(k);
          double ac = a.distanceFrom(c);
          double bc = b.distanceFrom(c);
          if (ac < ab && bc < ab) {
            skip = true;
            break;
          }
        }
        if (!skip) {
          plan.addEdge(a, b);
        }
      }
    }
  }

  private Set<Room> extractBiggerRooms(Queue<Room> separatedRooms, int nbRoomsDesired) {
    Set<Room> mainRooms = new TreeSet<>((o1, o2) ->
        (o1.getWidth() * o1.getHeight() > o2.getWidth() * o2.getHeight()) ? -1 : 1);
    mainRooms.addAll(separatedRooms);
    return mainRooms.stream().limit(nbRoomsDesired).collect(Collectors.toSet());
  }

  private Queue<Room> separateRooms(Queue<Room> overlappingRooms) {
    Queue<Room> separatedRooms = null;
    boolean overlapping = true;
    while (overlapping) {
      overlapping = false;
      Queue<Room> tmpRooms = new PriorityQueue<>(overlappingRooms);
      separatedRooms = new PriorityQueue<>(tmpRooms.size());
      while (!tmpRooms.isEmpty()) {
        Room mostCenteredRoom = tmpRooms.poll();
        separatedRooms.add(mostCenteredRoom);
        Queue<Room> toBeSeparatedRooms = new PriorityQueue<>();
        for (Room tmpRoom : tmpRooms) {
          if (mostCenteredRoom.doesOverlap(tmpRoom)) {
            overlapping = true;
            tmpRoom.moveFrom(mostCenteredRoom);
          }
          toBeSeparatedRooms.add(tmpRoom);
        }
        tmpRooms.clear();
        tmpRooms.addAll(toBeSeparatedRooms);
      }
    }
    return separatedRooms;
  }

  private Queue<Room> createRooms(int nbRoomsDesired) {
    Queue<Room> overlappingRooms = new PriorityQueue<>();

    for (int i = 0; i < nbRoomsDesired * factor; i++) {
      Pair<Integer, Integer> pointInCircle = MathUtils.getRandomPointInCircle(radius, tileSize);
      int width = MathUtils.nextPositiveGaussian(deviation, mean);
      int height = MathUtils.nextPositiveGaussian(deviation, mean);
      Room room = new Room(pointInCircle.getLeft(), pointInCircle.getRight(), width, height);
      overlappingRooms.add(room);
    }
    return overlappingRooms;
  }

  private void computeWidthAndHeightAndThenAdjustPlacement(Queue<Room> separatedRooms) {
    int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
    for (Room room : separatedRooms) {
      minX = Math.min(minX, room.getX());
      minY = Math.min(minY, room.getY());
      maxX = Math.max(maxX, room.getXPlusWidth());
      maxY = Math.max(maxY, room.getYPlusHeight());
    }
    width = maxX - minX + 3;
    height = maxY - minY + 3;

    // we want to translate all the rooms so that their coordinates are positive
    // and there is a one pixel margin on each side
    int diffX = minX - 1;
    int diffY = minY - 1;
    for (Room room : separatedRooms) {
      room.reduceXBy(diffX);
      room.reduceYBy(diffY);
    }
  }

  public Set<Room> getRooms() {
    return plan.vertexSet();
  }

  public Set<Rectangle> getCorridors() {
    return corridors;
  }

  private Set<DefaultEdge> getEdges() {
    return plan.edgeSet();
  }

  public UndirectedGraph<Room, DefaultEdge> getPlan() {
    return plan;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public Grid getGrid() {
    return grid;
  }

  public int getTileSize() {
    return tileSize;
  }


  static class DungeonBuilder {

    private int nbRoomsDesired = (int) NB_ROOMS.getDefaultValue();
    private int tileSize = (int) TILE_SIZE.getDefaultValue();
    private int deviation = 30;
    private int mean = 50;
    private EDungeonRadius radius = (EDungeonRadius) RADIUS.getDefaultValue();
    private int factor = 4;
    private int corridorWidth = 1;

    public DungeonBuilder(MapConstraint mapConstraint) {
      for (IDrawKey dungeonDrawKey : mapConstraint.keySet()) {
        if (dungeonDrawKey.equals(EDungeonDraw.NB_ROOMS)) {
          setNbRoomsDesired((Integer) mapConstraint.get(dungeonDrawKey));
        } else if (dungeonDrawKey.equals(EDungeonDraw.TILE_SIZE)) {
          setTileSize((Integer) mapConstraint.get(dungeonDrawKey));
        } else if (dungeonDrawKey.equals(EDungeonDraw.RADIUS)) {
          setRadius((EDungeonRadius) mapConstraint.get(dungeonDrawKey));
        }
      }
    }

    public NbkDungeon build() {
      return new NbkDungeon(this);
    }

    int getNbRoomsDesired() {
      return nbRoomsDesired;
    }

    private void setNbRoomsDesired(int nbRoomsDesired) {
      this.nbRoomsDesired = nbRoomsDesired;
    }

    int getTileSize() {
      return tileSize;
    }

    private void setTileSize(int tileSize) {
      this.tileSize = tileSize;
    }

    int getDeviation() {
      return deviation;
    }

    private void setDeviation(int deviation) {
      this.deviation = deviation;
    }

    int getMean() {
      return mean;
    }

    private void setMean(int mean) {
      this.mean = mean;
    }

    int getRadius() {
      return radius.getValue();
    }

    private void setRadius(EDungeonRadius radius) {
      this.radius = radius;
    }

    int getFactor() {
      return factor;
    }

    private void setFactor(int factor) {
      this.factor = factor;
    }

    int getCorridorWidth() {
      return corridorWidth;
    }

    private void setCorridorWidth(int corridorWidth) {
      this.corridorWidth = corridorWidth;
    }
  }
}
