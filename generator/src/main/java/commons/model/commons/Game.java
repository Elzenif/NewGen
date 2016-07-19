package commons.model.commons;

import commons.model.entity.items.IAvailableItem;

import java.util.EnumSet;

/**
 * Created by Germain on 12/06/2016.
 */
public abstract class Game {

  private final String name;
  private final EnumSet<? extends IAvailableItem> availableItems;

  protected Game(String name, EnumSet<? extends IAvailableItem> availableItems) {
    this.name = name;
    this.availableItems = availableItems;
  }

  public String getName() {
    return name;
  }

  public EnumSet<? extends IAvailableItem> getAvailableItems() {
    return availableItems;
  }

}
