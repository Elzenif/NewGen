package commons.model.map;

import commons.utils.StringUtils;

/**
 * Created by Germain on 24/09/2016.
 */
public enum EMapType implements IAvailableMap {

  SIMPLE_DUNGEON;


  @Override
  public String getName() {
    return StringUtils.capitalizeFirstLetter(name(), true);
  }
}