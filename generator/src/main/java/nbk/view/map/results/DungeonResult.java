package nbk.view.map.results;

import commons.model.map.Cell;
import commons.model.map.EMapPart;
import commons.view.map.results.MapResult;
import nbk.model.map.dungeon.NbkDungeon;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Created by Germain on 24/09/2016.
 */
public class DungeonResult implements MapResult {

  private final NbkDungeon dungeon;
  private boolean showGrid;
  private double scale;

  public DungeonResult(NbkDungeon dungeon, boolean showGrid) {
    this.dungeon = dungeon;
    this.showGrid = showGrid;
    this.scale = (double) 1;
  }

  @Override
  public BufferedImage getRawResult() {
    BufferedImage bufferedImage = new BufferedImage((int) (dungeon.getWidth() * scale),
        (int) (dungeon.getHeight() * scale), BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = bufferedImage.createGraphics();

    graphics.scale(scale, scale);

    graphics.setComposite(AlphaComposite.Clear);
    graphics.fillRect(0, 0, dungeon.getWidth(), dungeon.getHeight());

    graphics.setComposite(AlphaComposite.Src.derive(0.7f));
    for (Cell[] cells : dungeon.getGrid().getCells()) {
      for (Cell cell : cells) {
        graphics.setColor(getColor(cell));
        graphics.fill(cell);
      }
    }
    if (showGrid) {
      graphics.setComposite(AlphaComposite.Src.derive(0.1f));
      graphics.setColor(Color.BLACK);
      for (Cell[] cells : dungeon.getGrid().getCells()) {
        for (Cell cell : cells) {
          graphics.draw(cell);
        }
      }
    }
    return bufferedImage;
  }

  private Color getColor(Cell cell) {
    return (cell.getMapPart() == EMapPart.WALL) ? Color.BLACK : Color.WHITE;
  }

  public void setShowGrid(boolean showGrid) {
    this.showGrid = showGrid;
  }

  @Override
  public int getTileSize() {
    return dungeon.getTileSize();
  }

  public void setScale(double scale) {
    this.scale = scale;
  }
}
