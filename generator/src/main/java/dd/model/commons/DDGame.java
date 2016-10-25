package dd.model.commons;

import commons.model.commons.Game;
import commons.model.entity.items.IAvailableItem;
import dd.model.entity.items.EDDAvailableItem;

import java.util.EnumSet;

/**
 * Created by Germain on 25/10/2016.
 */
public class DDGame extends Game {

  private static final DDGame INSTANCE = new DDGame();

  private final EnumSet<? extends IAvailableItem<DDGame>> availableItems;

  private DDGame() {
    super("Donjons & Dragons");
    availableItems = EnumSet.allOf(EDDAvailableItem.class);
  }

  public static DDGame getInstance() {
    return INSTANCE;
  }

  public EnumSet<? extends IAvailableItem<DDGame>> getAvailableItems() {
    return availableItems;
  }
}
