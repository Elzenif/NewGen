package mvc.model.entity.enums;

import mvc.model.entity.utils.ERarity;
import mvc.model.entity.utils.ItemType;
import mvc.model.entity.utils.ItemTypeBuilder;
import utils.MathUtils;
import utils.french.FrenchAdjective;
import utils.french.FrenchGenderAdjective;
import utils.french.FrenchNeutralAdjective;
import utils.french.FrenchString;

import java.util.List;

/**
 * Created by Germain on 16/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkQuality implements ItemType {

  MAUVAIS(new NbkQualityBuilder()
          .setGenderAdjective("grossier", "grossière")
          .setRarity(ERarity.COMMON));

  private final List<FrenchString> names;
  private final ERarity rarity;

  ENbkQuality(NbkQualityBuilder builder) {
    names = builder.getNames();
    rarity = builder.getRarity();
  }

  @Override
  public ERarity getRarity() {
    return rarity;
  }

  @Override
  public FrenchAdjective getName() {
    return (FrenchAdjective) MathUtils.chooseRandom(names);
  }


  private static class NbkQualityBuilder extends ItemTypeBuilder {

    private NbkQualityBuilder setNeutralAdjective(String... names) {
      for (String name : names) {
        addName(new FrenchNeutralAdjective(name));
      }
      return this;
    }

    private NbkQualityBuilder setGenderAdjective(String masculineForm, String feminineForm) {
      addName(new FrenchGenderAdjective(masculineForm, feminineForm));
      return this;
    }

    @Override
    protected NbkQualityBuilder setRarity(ERarity rarity) {
      return (NbkQualityBuilder) super.setRarity(rarity);
    }
  }
}
