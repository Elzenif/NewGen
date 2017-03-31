package commons.model.map;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 24/09/2016.
 */
public enum EMapType implements IAvailableMap {

  SIMPLE_DUNGEON(resourceBundle.getString("row.map.dungeon"));

  private final String name;

  EMapType(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
