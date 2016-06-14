package mvc.model.entity.game;

import mvc.view.entity.nbk.ENbkAvailableItem;

/**
 * Created by Germain on 12/06/2016.
 */
public class NbkGame extends Game {

  private static final NbkGame INSTANCE = new NbkGame();

  private NbkGame() {
    super("Naheulbeuk", ENbkAvailableItem.class);
  }

  public static NbkGame getInstance() {
    return INSTANCE;
  }
}
