package dd.model.entity.items;

import commons.model.entity.items.IAvailableItem;
import dd.model.commons.DDGame;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 25/10/2016.
 */
public enum EDDAvailableItem implements IAvailableItem<DDGame> {

  TREASURE(resourceBundle.getString("row.item.treasure"));

  private final String name;

  EDDAvailableItem(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
