package nbk.view.map.results;

import commons.model.map.Cell;
import commons.model.map.EMapPart;
import commons.view.commons.results.Result;
import nbk.model.map.dungeon.NbkDungeon;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Created by Germain on 24/09/2016.
 */
public class DungeonResult implements Result<Image> {

  private final NbkDungeon dungeon;
  private boolean showGrid;

  public DungeonResult(NbkDungeon dungeon, boolean showGrid) {
    this.dungeon = dungeon;
    this.showGrid = showGrid;
  }

  @Override
  public BufferedImage getRawResult() {
    BufferedImage bufferedImage = new BufferedImage(dungeon.getWidth(), dungeon.getHeight(),
        BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = bufferedImage.createGraphics();
    graphics.setComposite(AlphaComposite.Clear);
    graphics.fillRect(0, 0, dungeon.getWidth(), dungeon.getHeight());

    graphics.setComposite(AlphaComposite.Src.derive(0.4f));
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
}
