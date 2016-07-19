package nbk.model.entity.items;

import commons.model.entity.items.IAvailableItem;
import nbk.model.commons.NbkGame;

import static commons.utils.StringUtils.capitalizeFirstLetter;

/**
 * Created by Germain on 19/07/2016.
 */
public enum ENbkAvailableItem implements IAvailableItem<NbkGame> {

  WEAPON, ARMOR;

  @Override
  public String getName() {
    return capitalizeFirstLetter(toString());
  }
}
