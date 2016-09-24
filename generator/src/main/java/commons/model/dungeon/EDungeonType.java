package commons.model.dungeon;

import commons.utils.StringUtils;

/**
 * Created by Germain on 24/09/2016.
 */
public enum EDungeonType implements IAvailableDungeon {

  SIMPLE_DUNGEON;


  @Override
  public String getName() {
    return StringUtils.capitalizeFirstLetter(name(), true);
  }
}
