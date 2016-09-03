package nbk.model.commons;

import commons.model.commons.Game;
import commons.model.entity.items.IAvailableItem;
import commons.model.entity.living.IAvailableLiving;
import nbk.model.entity.items.ENbkAvailableItem;
import nbk.model.entity.living.ENbkAvailableLivings;

import java.util.EnumSet;

/**
 * Created by Germain on 12/06/2016.
 */
public class NbkGame extends Game {

  private static final NbkGame INSTANCE = new NbkGame();

  private final EnumSet<? extends IAvailableItem> availableItems;
  private final EnumSet<? extends IAvailableLiving> availableLivings;

  private NbkGame() {
    super("Naheulbeuk");
    availableItems = EnumSet.allOf(ENbkAvailableItem.class);
    availableLivings = EnumSet.allOf(ENbkAvailableLivings.class);
  }

  public static NbkGame getInstance() {
    return INSTANCE;
  }

  public EnumSet<? extends IAvailableItem> getAvailableItems() {
    return availableItems;
  }

  public EnumSet<? extends IAvailableLiving> getAvailableLivings() {
    return availableLivings;
  }
}
