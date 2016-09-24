package commons.model.dungeon;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.Set;

/**
 * Created by Germain on 24/09/2016.
 */
public class Dungeon {

  private final UndirectedGraph<Room, DefaultEdge> plan;
  private int width;
  private int height;

  public Dungeon() {
    plan = new SimpleGraph<>(DefaultEdge.class);
    Room room1 = new Room("room1", true, 5, 10, 12, 10);
    plan.addVertex(room1);
    Room room2 = new Room("room2", false, 40, 30, 8, 20);
    plan.addVertex(room2);
    plan.addEdge(room1, room2);

    computeWidthAndHeightAndThenAdjustPlacement();
  }

  private void computeWidthAndHeightAndThenAdjustPlacement() {
    int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
    for (Room room : getRooms()) {
      minX = Math.min(minX, room.getX());
      minY = Math.min(minY, room.getY());
      maxX = Math.max(maxX, room.getX() + room.getWidth());
      maxY = Math.max(maxY, room.getY() + room.getHeight());
    }
    width = maxX - minX + 2;
    height = maxY - minY + 2;

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
