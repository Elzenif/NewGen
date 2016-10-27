package dd.model.entity.items.treasure;

/**
 * Created by Germain on 26/10/2016.
 */
public abstract class DDTreasure {

  public static final int LEVEL_MAX = 2;
  protected String name;
  protected String value;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    String result = "";
    if (name != null) {
      result += name;
      if (value != null) {
        result += " " + value;
      }
    }
    return result;
  }
}
