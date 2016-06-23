package commons.model.entity.game;

import commons.view.entity.IAvailableItem;

/**
 * Created by Germain on 12/06/2016.
 */
public abstract class Game {

  private final String name;
  private final Class<? extends IAvailableItem> availableItems;

  protected Game(String name, Class<? extends IAvailableItem> availableItems) {
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
