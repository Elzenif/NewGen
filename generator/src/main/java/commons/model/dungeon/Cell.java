package commons.model.dungeon;

import java.awt.Rectangle;

/**
 * Created by Germain on 29/09/2016.
 */
public class Cell extends Rectangle {

  private EDungeonPart dungeonPart = EDungeonPart.WALL;

  public Cell(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  public EDungeonPart getDungeonPart() {
    return dungeonPart;
  }

  public void setDungeonPart(EDungeonPart dungeonPart) {
    this.dungeonPart = dungeonPart;
  }
}
