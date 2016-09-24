package commons.model.dungeon;

/**
 * Created by Germain on 24/09/2016.
 */
public class Room {

  private final String name;
  private final boolean entry;

  public Room(String name, boolean entry) {
    this.name = name;
    this.entry = entry;
  }

  public boolean isEntry() {
    return entry;
  }

  @Override
  public String toString() {
    return "Room{" +
            "name='" + name + '\'' +
            ", entry=" + entry +
            '}';
  }

}
