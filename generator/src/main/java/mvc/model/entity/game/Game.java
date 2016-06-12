package mvc.model.entity.game;

import mvc.model.entity.utils.IAvailableItem;

/**
 * Created by Germain on 12/06/2016.
 */
public abstract class Game {

  public static final int NB_GAMES = 2;

  private final String name;
  private final Class<? extends IAvailableItem> availableItems;

  Game(String name, Class<? extends IAvailableItem> availableItems) {
    this.name = name;
    this.availableItems = availableItems;
  }

  public String getName() {
    return name;
  }

  public Class<? extends IAvailableItem> getAvailableItems() {
    return availableItems;
  }

}
