package dd.model.entity.items.treasures;

/**
 * Created by Germain on 26/10/2016.
 */
public class DDTreasure {

  public static final int LEVEL_MAX = 2;
  protected String name;
  protected String value;

  public DDTreasure() {
  }

  public DDTreasure(String name) {
    this.name = name;
  }

  public DDTreasure(String name, String value) {
    this.name = name;
    this.value = value;
  }

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
        result += " (" + value + ")";
      }
    }
    return result;
  }
}
