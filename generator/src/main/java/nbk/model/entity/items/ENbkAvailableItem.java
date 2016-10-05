package nbk.model.entity.items;

import commons.model.entity.items.IAvailableItem;
import nbk.model.commons.NbkGame;

import static commons.view.utils.Constants.resourceBundle;


/**
 * Created by Germain on 19/07/2016.
 */
public enum ENbkAvailableItem implements IAvailableItem<NbkGame> {

  WEAPON(resourceBundle.getString("row.item.weapon")),
  ARMOR(resourceBundle.getString("row.item.armor"));

  private final String name;

  ENbkAvailableItem(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
