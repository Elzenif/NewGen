package nbk.model.map.dungeon.constraints;

import commons.model.commons.IDrawKey;
import org.jetbrains.annotations.Contract;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 02/10/2016.
 */
public enum EDungeonDraw implements IDrawKey {
  NB_ROOMS(EDungeonNbRooms.values(), 5, resourceBundle.getString("row.dungeon.nbRooms"),
      resourceBundle.getString("tooltip.dungeon.nbRooms")),
  TILE_SIZE(EDungeonTileSizes.values(), 5, resourceBundle.getString("row.dungeon.tileSize"),
      resourceBundle.getString("tooltip.dungeon.tileSize")),
  RADIUS(EDungeonRadius.values(), EDungeonRadius.NORMAL, resourceBundle.getString("row.dungeon.radius"),
      resourceBundle.getString("tooltip.dungeon.radius"));

  private final Object[] drawValues;
  private final Object defaultValue;
  private final String name;
  private final String toolTipText;


  EDungeonDraw(Object[] drawValues, Object defaultValue, String name, String toolTipText) {
    this.drawValues = drawValues;
    this.defaultValue = defaultValue;
    this.name = name;
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


  @Contract(pure = true)
  @Override
  public String toString() {
    return name;
  }
}
