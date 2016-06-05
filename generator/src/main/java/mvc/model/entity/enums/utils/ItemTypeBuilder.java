package mvc.model.entity.enums.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Germain on 04/06/2016.
 */
public abstract class ItemTypeBuilder {

  private final List<String> names = new ArrayList<>();
  private int proba = 0;

  public List<String> getNames() {
    return names;
  }

  public int getProba() {
    return proba;
  }

  protected ItemTypeBuilder setNames(String mainName, String... otherNames) {
    this.names.add(mainName);
    this.names.addAll(Arrays.asList(otherNames));
    return this;
  }

  protected ItemTypeBuilder setProba(int proba) {
    this.proba = proba;
    return this;
  }
}
