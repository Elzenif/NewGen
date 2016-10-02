package nbk.model.map.dungeon.constraints;

import commons.model.map.constraints.IMapDrawKey;

/**
 * Created by Germain on 02/10/2016.
 */
public enum EDungeonDraw implements IMapDrawKey {
  NB_ROOMS(EDungeonNbRooms.values(), 5, "Number of rooms the map will contain"),
  TILE_SIZE(EDungeonTileSizes.values(), 5, "Size of the tiles"),
  RADIUS(EDungeonRadius.values(), EDungeonRadius.NORMAL,
      "The global radius of the dungeon: on SMALL, rooms tend to be closer to each other; on BIG, they are farther");

  private final Object[] drawValues;
  private final Object defaultValue;
  private final String toolTipText;


  EDungeonDraw(Object[] drawValues, Object defaultValue, String toolTipText) {
    this.drawValues = drawValues;
    this.defaultValue = defaultValue;
    this.toolTipText = toolTipText;
  }

  public Object[] getDrawValues() {
    return drawValues;
  }

  public Object getDefaultValue() {
    return defaultValue;
  }

  public String getToolTipText() {
    return toolTipText;
  }
}
