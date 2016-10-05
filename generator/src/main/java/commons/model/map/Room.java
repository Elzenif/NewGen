package commons.model.map;

import commons.utils.MathUtils;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Germain on 24/09/2016.
 */
public class Room implements Comparable<Room> {

  private final int width;
  private final int height;
  private String name;
  private boolean entry;
  private int x;
  private int y;
  private VD verticalDirection = null;
  private HD horizontalDirection = null;

  private Room(String name, boolean entry, int x, int y, int width, int height) {
    this.name = name;
    this.entry = entry;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public Room(int x, int y, int width, int height) {
    this("", false, x, y, width, height);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isEntry() {
    return entry;
  }

  public void setEntry(boolean entry) {
    this.entry = entry;
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

  public VD getVerticalDirection() {
    return verticalDirection;
  }

  public void setVerticalDirection(VD verticalDirection) {
    this.verticalDirection = verticalDirection;
  }

  public HD getHorizontalDirection() {
    return horizontalDirection;
  }

  public void setHorizontalDirection(HD horizontalDirection) {
    this.horizontalDirection = horizontalDirection;
  }

  public int getXPlusWidth() {
    return x + width;
  }

  public int getYPlusHeight() {
    return y + height;
  }

  public int getCenterX() {
    return (getX() + getXPlusWidth()) / 2;
  }

  public int getCenterY() {
    return (getY() + getYPlusHeight()) / 2;
  }

  public void reduceXBy(int diff) {
    x -= diff;
  }

  public void reduceYBy(int diff) {
    y -= diff;
  }

  public boolean doesOverlap(Room room) {
    return (room.getX() < this.getXPlusWidth()) && (this.getX() < room.getXPlusWidth())
        && (room.getY() < this.getYPlusHeight()) && (this.getY() < room.getYPlusHeight());
  }

  @Override
  public int compareTo(@NotNull Room o) {
    if (this.equals(o))
      return 0;
    double thisCenter = MathUtils.mean(this.getCenterX(), this.getCenterY());
    double oCenter = MathUtils.mean(o.getCenterX(), o.getCenterY());
    if (thisCenter > oCenter)
      return 1;
    return -1;
  }

  public double distanceFrom(Room other) {
    return MathUtils.mean(other.getCenterX() - this.getCenterX(), other.getCenterY() - this.getCenterY());
  }

  public void moveFrom(Room immobileRoom) {
    int dx;
    HD hd;
    if (horizontalDirection == HD.RIGHT
        || (horizontalDirection != HD.LEFT && immobileRoom.getCenterX() < getCenterX())) {
      dx = immobileRoom.getXPlusWidth() - getX();
      hd = HD.RIGHT;
    } else {
      dx = immobileRoom.getX() - getXPlusWidth();
      hd = HD.LEFT;
    }
    int dy;
    VD vd;
    if (verticalDirection == VD.DOWN
        || (verticalDirection != VD.UP && immobileRoom.getCenterY() < getCenterY())) {
      dy = immobileRoom.getYPlusHeight() - getY();
      vd = VD.DOWN;
    } else {
      dy = immobileRoom.getY() - getYPlusHeight();
      vd = VD.UP;
    }
    if (Math.abs(dx) < Math.abs(dy)) {
      reduceXBy(-dx);
    } else {
      reduceYBy(-dy);
    }
    setVerticalDirection(vd);
    setHorizontalDirection(hd);
  }

  public enum VD {
    UP,
    DOWN
  }

  public enum HD {
    LEFT,
    RIGHT
  }
}
