package tes.model.commons;

import commons.model.commons.Game;
import tes.model.entity.items.ETesAvailableItem;

import java.util.EnumSet;

/**
 * Created by Germain on 12/06/2016.
 */
public class TesGame extends Game {

  private static final TesGame INSTANCE = new TesGame();

  private TesGame() {
    super("The Elder Scrolls", EnumSet.allOf(ETesAvailableItem.class));
  }

  public static TesGame getInstance() {
    return INSTANCE;
  }
}
