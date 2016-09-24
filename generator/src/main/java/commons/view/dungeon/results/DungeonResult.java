package commons.view.dungeon.results;

import commons.model.dungeon.Dungeon;
import commons.utils.ColorUtils;
import commons.view.commons.Result;

import java.awt.Color;
import java.awt.Font;

/**
 * Created by Germain on 24/09/2016.
 */
public class DungeonResult implements Result {

  private final Dungeon dungeon;

  public DungeonResult(Dungeon dungeon) {
    this.dungeon = dungeon;
  }

  @Override
  public String getRawResult() {
    return dungeon.toString();
  }

  @Override
  public int getFontStyle() {
    return Font.PLAIN;
  }

  @Override
  public Color getColor() {
    return ColorUtils.BLACK;
  }
}
