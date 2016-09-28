package commons.model.dungeon;

import commons.utils.MathUtils;
import commons.utils.Pair;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
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

  private static final int TILE_SIZE = 5;
  private static final double RATIO = 1.2;

  private static final int DEVIATION = 30;
  private static final int MEAN = 50;
  private static final int RADIUS = 100;

  private final UndirectedGraph<Room, DefaultEdge> plan;
  private int width;
  private int height;
  private int factor = 4;

  public Dungeon(int nbRoomsDesired) {
    plan = new SimpleGraph<>(DefaultEdge.class);

    Queue<Room> overlappingRooms = createRooms(nbRoomsDesired);
    Queue<Room> separatedRooms = separateRooms(overlappingRooms);
    computeWidthAndHeightAndThenAdjustPlacement(separatedRooms);
    Set<Room> mainRooms = extractBiggerRooms(separatedRooms, nbRoomsDesired);

    mainRooms.forEach(plan::addVertex);
    bindRooms();
  }

  private void bindRooms() {
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
      Pair<Integer, Integer> pointInCircle = MathUtils.getRandomPointInCircle(RADIUS, TILE_SIZE);
      int width = MathUtils.nextPositiveGaussian(DEVIATION, MEAN);
      int height = MathUtils.nextPositiveGaussian(DEVIATION, MEAN);
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
}
