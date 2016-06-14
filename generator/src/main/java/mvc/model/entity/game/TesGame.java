package mvc.model.entity.game;

import mvc.view.entity.tes.ETesAvailableItem;

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
