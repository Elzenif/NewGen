package commons.view.map.results;

import commons.model.map.Cell;
import commons.model.map.EDungeonPart;
import commons.model.map.NbkDungeon;
import commons.view.commons.Result;

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

  public DungeonResult(NbkDungeon dungeon) {
    this.dungeon = dungeon;
  }

  @Override
  public BufferedImage getRawResult() {
    BufferedImage bufferedImage = new BufferedImage(dungeon.getWidth(), dungeon.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = bufferedImage.createGraphics();
    graphics.setComposite(AlphaComposite.Clear);
    graphics.fillRect(0, 0, dungeon.getWidth(), dungeon.getHeight());

    graphics.setComposite(AlphaComposite.Src.derive(0.2f));
    for (Cell[] cells : dungeon.getGrid().getCells()) {
      for (Cell cell : cells) {
        graphics.setColor(getColor(cell));
        graphics.fill(cell);
      }
    }
    return bufferedImage;

  }

  private Color getColor(Cell cell) {
    return (cell.getDungeonPart() == EDungeonPart.WALL) ? Color.BLACK : Color.WHITE;
  }
}
