package mvc.model.entity.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Germain on 04/06/2016.
 */
public abstract class ItemTypeBuilder {

  private final List<String> names = new ArrayList<>();
  private ERarity rarity = ERarity.UNCOMMON;

  public List<String> getNames() {
    return names;
  }

  public ERarity getRarity() {
    return rarity;
  }

  protected ItemTypeBuilder setNames(String mainName, String... otherNames) {
    this.names.add(mainName);
    this.names.addAll(Arrays.asList(otherNames));
    return this;
  }

  protected ItemTypeBuilder setRarity(ERarity rarity) {
    this.rarity = rarity;
    return this;
  }
}
