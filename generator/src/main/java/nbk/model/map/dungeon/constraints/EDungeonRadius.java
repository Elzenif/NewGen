package nbk.model.map.dungeon.constraints;

import org.jetbrains.annotations.Contract;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 02/10/2016.
 */
public enum EDungeonRadius {
  SMALL(25, resourceBundle.getString("dungeon.radius.small")),
  NORMAL(100, resourceBundle.getString("dungeon.radius.normal")),
  BIG(500, resourceBundle.getString("dungeon.radius.big"));

  private final int value;
  private final String name;

  EDungeonRadius(int value, String name) {
    this.value = value;
    this.name = name;
  }

  public int getValue() {
    return value;
  }


  @Contract(pure = true)
  @Override
  public String toString() {
    return name;
  }
}
