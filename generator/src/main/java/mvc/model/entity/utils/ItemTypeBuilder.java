package mvc.model.entity.utils;

import utils.french.FrenchString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Germain on 04/06/2016.
 */
public abstract class ItemTypeBuilder {

  private final List<FrenchString> names = new ArrayList<>();
  private ERarity rarity;

  public List<FrenchString> getNames() { return names; }

  protected void addNames(FrenchString... frenchStrings) {
    names.addAll(Arrays.asList(frenchStrings));
  }

  protected void addName(FrenchString frenchString) {
    names.add(frenchString);
  }

  public ERarity getRarity() {
    return rarity;
  }

  protected ItemTypeBuilder setRarity(ERarity rarity) {
    this.rarity = rarity;
    return this;
  }
}
