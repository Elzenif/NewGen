package commons.model.dungeon;

import commons.utils.MathUtils;
import commons.utils.Pair;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.awt.Polygon;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by Germain on 24/09/2016.
 */
public class Dungeon {

  private final UndirectedGraph<Room, DefaultEdge> plan;
  private final Set<Shape> corridors;

  private final int nbRoomsDesired;
  private final int tileSize;
  private final int deviation;
  private final int mean;
  private final int radius;
  private final int factor;
  private final int corridorWidth;
  private int width;
  private int height;

  private Dungeon(DungeonBuilder builder) {
    plan = new SimpleGraph<>(DefaultEdge.class);
    corridors = new HashSet<>();

    nbRoomsDesired = builder.nbRoomsDesired;
    tileSize = builder.tileSize;
    deviation = builder.deviation;
    mean = builder.mean;
    radius = builder.radius;
    factor = builder.factor;
    corridorWidth = builder.corridorWidth;

    Queue<Room> overlappingRooms = createRooms(nbRoomsDesired);
    Queue<Room> separatedRooms = separateRooms(overlappingRooms);
    computeWidthAndHeightAndThenAdjustPlacement(separatedRooms);
    Set<Room> mainRooms = extractBiggerRooms(separatedRooms, nbRoomsDesired);

    mainRooms.forEach(plan::addVertex);
    bindRoomsWithRelativeNeighborhoodGraph();
    buildCorridors();
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
      int[] xPoints = new int[6];
      int[] yPoints = new int[6];
      if (MathUtils.nextBoolean()) {
        xPoints[0] = MathUtils.roundM(x, tileSize);
        xPoints[1] = MathUtils.roundM(x + dx + corridorWidth * tileSize / 2, tileSize);
        xPoints[2] = xPoints[1];
        xPoints[3] = MathUtils.roundM(x + dx - corridorWidth * tileSize / 2, tileSize);
        xPoints[4] = xPoints[3];
        xPoints[5] = xPoints[0];
        if (dy > 0) {
          yPoints[0] = MathUtils.roundM(y - corridorWidth * tileSize / 2, tileSize);
          yPoints[4] = MathUtils.roundM(y + corridorWidth * tileSize / 2, tileSize);
        } else {
          yPoints[0] = MathUtils.roundM(y + corridorWidth * tileSize / 2, tileSize);
          yPoints[4] = MathUtils.roundM(y - corridorWidth * tileSize / 2, tileSize);
        }
        yPoints[1] = yPoints[0];
        yPoints[2] = MathUtils.roundM(y + dy, tileSize);
        yPoints[3] = yPoints[2];
        yPoints[5] = yPoints[4];
      } else {
        xPoints[0] = MathUtils.roundM(x - corridorWidth * tileSize / 2, tileSize);
        xPoints[1] = xPoints[0];
        xPoints[2] = MathUtils.roundM(x + dx, tileSize);
        xPoints[3] = xPoints[2];
        xPoints[4] = MathUtils.roundM(x + corridorWidth * tileSize / 2, tileSize);
        xPoints[5] = xPoints[4];
        if (dy > 0) {
          yPoints[1] = MathUtils.roundM(y + dy + corridorWidth * tileSize / 2, tileSize);
          yPoints[3] = MathUtils.roundM(y + dy - corridorWidth * tileSize / 2, tileSize);
        } else {
          yPoints[1] = MathUtils.roundM(y + dy - corridorWidth * tileSize / 2, tileSize);
          yPoints[3] = MathUtils.roundM(y + dy + corridorWidth * tileSize / 2, tileSize);
        }
        yPoints[0] = MathUtils.roundM(y, tileSize);
        yPoints[2] = yPoints[1];
        yPoints[4] = yPoints[3];
        yPoints[5] = yPoints[0];
      }
      corridors.add(new Polygon(xPoints, yPoints, 6));
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

  public Set<Shape> getCorridors() {
    return corridors;
  }

  public Set<DefaultEdge> getEdges() {
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

  public static class DungeonBuilder {

    private int nbRoomsDesired = 5;
    private int tileSize = 5;
    private int deviation = 30;
    private int mean = 50;
    private int radius = 100;
    private int factor = 4;
    private int corridorWidth = 1;

    public Dungeon build() {
      return new Dungeon(this);
    }

    public DungeonBuilder setNbRoomsDesired(int nbRoomsDesired) {
      this.nbRoomsDesired = nbRoomsDesired;
      return this;
    }

    public DungeonBuilder setTileSize(int tileSize) {
      this.tileSize = tileSize;
      return this;
    }

    public DungeonBuilder setDeviation(int deviation) {
      this.deviation = deviation;
      return this;
    }

    public DungeonBuilder setMean(int mean) {
      this.mean = mean;
      return this;
    }

    public DungeonBuilder setRadius(int radius) {
      this.radius = radius;
      return this;
    }

    public DungeonBuilder setFactor(int factor) {
      this.factor = factor;
      return this;
    }

    public DungeonBuilder setCorridorWidth(int corridorWidth) {
      this.corridorWidth = corridorWidth;
      return this;
    }
  }
}
