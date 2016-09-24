package commons.model.dungeon;

import commons.utils.Positive;
import commons.utils.SPositive;

/**
 * Created by Germain on 24/09/2016.
 */
public class Room {

  private final String name;
  private final boolean entry;
  private final int width;
  private final int height;
  private int x;
  private int y;

  public Room(String name, boolean entry, int x, int y, int width, int height) {
    this.name = name;
    this.entry = entry;
    this.x = new Positive(x).getValue();
    this.y = new Positive(y).getValue();
    this.width = new SPositive(width).getValue();
    this.height = new SPositive(height).getValue();
  }

  public String getName() {
    return name;
  }

  public boolean isEntry() {
    return entry;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public void reduceXBy(int diff) {
    x = new Positive(x - diff).getValue();
  }

  public void reduceYBy(int diff) {
    y = new Positive(y - diff).getValue();
  }
}
