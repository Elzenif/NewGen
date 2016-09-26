package commons.view.dungeon.results;

import commons.model.dungeon.Dungeon;
import commons.model.dungeon.Room;
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

  private final Dungeon dungeon;

  public DungeonResult(Dungeon dungeon) {
    this.dungeon = dungeon;
  }

  @Override
  public Image getRawResult() {
    BufferedImage bufferedImage = new BufferedImage(dungeon.getWidth(), dungeon.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = bufferedImage.createGraphics();
    graphics.setComposite(AlphaComposite.Clear);
    graphics.fillRect(0, 0, dungeon.getWidth(), dungeon.getHeight());

    // create Grid
    graphics.setComposite(AlphaComposite.Src.derive(0.1f));
    graphics.setColor(Color.BLACK);
    graphics.drawRect(0, 0, dungeon.getWidth() - 1, dungeon.getHeight() - 1);
    for (int i = 0; i < dungeon.getWidth(); i += 10) {
      graphics.drawLine(i, 0, i, dungeon.getHeight());
    }
    for (int j = 0; j < dungeon.getHeight(); j += 10) {
      graphics.drawLine(0, j, dungeon.getWidth(), j);
    }

    // create rooms
    graphics.setComposite(AlphaComposite.Src);
    graphics.setColor(Color.RED);
    for (Room room : dungeon.getRooms()) {
      graphics.drawRect(room.getX(), room.getY(), room.getWidth(), room.getHeight());
    }
    return bufferedImage;

  }
}
