package tes.model.entity.game;

import commons.model.entity.game.Game;
import tes.view.entity.ETesAvailableItem;

/**
 * Created by Germain on 12/06/2016.
 */
public class TesGame extends Game {

  private static final TesGame INSTANCE = new TesGame();

  private TesGame() {
    super("The Elder Scrolls", ETesAvailableItem.class);
  }

  public static TesGame getInstance() {
    return INSTANCE;
  }
}