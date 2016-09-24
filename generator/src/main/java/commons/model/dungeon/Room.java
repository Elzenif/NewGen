package commons.model.dungeon;

import commons.utils.SPositive;

/**
 * Created by Germain on 24/09/2016.
 */
public class Room {

  private final String name;
  private final boolean entry;
  private final SPositive width;
  private final SPositive height;

  public Room(String name, boolean entry, int width, int height) {
    this.name = name;
    this.entry = entry;
    this.width = new SPositive(width);
    this.height = new SPositive(height);
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
