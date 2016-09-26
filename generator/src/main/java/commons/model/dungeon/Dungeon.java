package commons.model.dungeon;

import commons.utils.MathUtils;
import commons.utils.Pair;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Germain on 24/09/2016.
 */
public class Dungeon {

  private static final int TILE_SIZE = 5;
  private static final double RATIO = 1.25;

  private static final int DEVIATION = 30;
  private static final int MEAN = 50;
  private static final int RADIUS = 100;

  private final UndirectedGraph<Room, DefaultEdge> plan;
  private int width;
  private int height;

  public Dungeon(int nbRoomsDesired, int maxAttempts) {
    plan = new SimpleGraph<>(DefaultEdge.class);

    Queue<Room> tmpRooms = createRooms(nbRoomsDesired, maxAttempts);
    Queue<Room> separatedRooms = separateRooms(tmpRooms);
    separatedRooms.forEach(plan::addVertex);

    computeWidthAndHeightAndThenAdjustPlacement();
  }

  private Queue<Room> separateRooms(Queue<Room> rooms) {
    Queue<Room> separatedRooms = null;
    boolean overlapping = true;
    while (overlapping) {
      overlapping = false;
      Queue<Room> tmpRooms = new PriorityQueue<>(rooms);
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

  private Queue<Room> createRooms(int nbRoomsDesired, int maxAttempts) {
    Queue<Room> rooms = new PriorityQueue<>();

    int nbRoomsAccepted = 0;
    int nbAttempts = 0;
    while (nbRoomsAccepted < nbRoomsDesired && nbAttempts < maxAttempts) {
      for (int i = 0; i < nbRoomsDesired; i++) {
        Pair<Integer, Integer> pointInCircle = MathUtils.getRandomPointInCircle(RADIUS, TILE_SIZE);
        int width = MathUtils.nextPositiveGaussian(DEVIATION, MEAN);
        if (width <= TILE_SIZE)
          continue;
        int height = MathUtils.nextPositiveGaussian(DEVIATION, MEAN);
        if (height <= TILE_SIZE)
          continue;
        Room room = new Room(pointInCircle.getLeft(), pointInCircle.getRight(), width, height);
        if (width >= RATIO * MEAN && height >= RATIO * MEAN) {
          nbRoomsAccepted++;
        }
        rooms.add(room);
      }
      nbAttempts++;
    }
    return rooms;
  }

  private void computeWidthAndHeightAndThenAdjustPlacement() {
    int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
    for (Room room : getRooms()) {
      minX = Math.min(minX, room.getX());
      minY = Math.min(minY, room.getY());
      maxX = Math.max(maxX, room.getXPlusWidth());
      maxY = Math.max(maxY, room.getYPlusHeight());
    }
    width = maxX - minX + 3;
    height = maxY - minY + 3;

    // we want to translate all the rooms so that there is a one pixel margin on each side
    int diffX = minX - 1;
    int diffY = minY - 1;
    for (Room room : getRooms()) {
      room.reduceXBy(diffX);
      room.reduceYBy(diffY);
    }
  }

  public Set<Room> getRooms() {
    return plan.vertexSet();
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
}
