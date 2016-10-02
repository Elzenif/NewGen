package commons.model.map.constraints;

/**
 * Created by Germain on 02/10/2016.
 */
public enum EDungeonDraw implements IDungeonDrawKey {
  NB_ROOMS(5, "Number of rooms the map will contain");

  private final String toolTipText;
  private final Integer defaultValue;


  EDungeonDraw(Integer defaultValue, String toolTipText) {
    this.defaultValue = defaultValue;
    this.toolTipText = toolTipText;
  }

  public String getToolTipText() {
    return toolTipText;
  }

  public Integer getDefaultValue() {
    return defaultValue;
  }
}
