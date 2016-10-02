package nbk.model.map.dungeon.constraints;

/**
 * Created by Germain on 02/10/2016.
 */
public enum EDungeonRadius {
  SMALL(25), NORMAL(100), BIG(500);

  private final int value;

  EDungeonRadius(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
