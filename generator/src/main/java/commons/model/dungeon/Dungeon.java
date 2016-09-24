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

  public Dungeon() {
    plan = new SimpleGraph<>(DefaultEdge.class);
    Room room1 = new Room("room1", true);
    plan.addVertex(room1);
    Room room2 = new Room("room2", false);
    plan.addVertex(room2);
    plan.addEdge(room1, room2);

  }

  public Set<Room> getRooms() {
    return plan.vertexSet();
  }

  public UndirectedGraph<Room, DefaultEdge> getPlan() {
    return plan;
  }

  @Override
  public String toString() {
    return "Dungeon{" +
            "plan=" + plan +
            '}';
  }
}
