package commons.model.dungeon;

/**
 * Created by Germain on 29/09/2016.
 */
public class Grid {

  private final int width;
  private final int height;
  private final int tileSize;
  private final Cell[][] cells;

  public Grid(int width, int height, int tileSize) {
    this.width = width;
    this.height = height;
    this.tileSize = tileSize;
    this.cells = new Cell[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        cells[i][j] = new Cell(j * tileSize, i * tileSize, tileSize, tileSize);
      }
    }
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public Cell[][] getCells() {
    return cells;
  }

  public Cell getCell(int x, int y) {
    return cells[y / tileSize][x / tileSize];
  }
}
