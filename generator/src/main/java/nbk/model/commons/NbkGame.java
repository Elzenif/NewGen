package nbk.model.commons;

import commons.model.commons.Game;
import nbk.model.entity.items.ENbkAvailableItem;

import java.util.EnumSet;

/**
 * Created by Germain on 12/06/2016.
 */
public class NbkGame extends Game {

  private static final NbkGame INSTANCE = new NbkGame();

  private NbkGame() {
    super("Naheulbeuk", EnumSet.allOf(ENbkAvailableItem.class));
  }

  public static NbkGame getInstance() {
    return INSTANCE;
  }
}
