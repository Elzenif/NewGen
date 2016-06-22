package mvc.model.entity.enums;

import mvc.model.entity.utils.ERarity;
import mvc.model.entity.utils.ItemType;
import mvc.model.entity.utils.ItemTypeBuilder;
import utils.MathUtils;
import utils.french.FrenchAdjective;
import utils.french.FrenchGenderAdjective;
import utils.french.FrenchNeutralAdjective;
import utils.french.FrenchString;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Germain on 16/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkQuality implements ItemType {

  MAUVAIS(new NbkQualityBuilder()
          .setGenderAdjective("grossier", "grossière")
          .setNeutralAdjective("perrave", "de base", "basique", "daubesque", "quelconque", "minable",
                  "de basse qualité")
          .setRarity(ERarity.COMMON)),
  BASIQUE(new NbkQualityBuilder()
          .setGenderAdjective("correct", "correcte")
          .setNeutralAdjective("de qualité")
          .setRarity(ERarity.UNCOMMON)),
  BONNE_QUALITE(new NbkQualityBuilder()
          .setNeutralAdjective("de bonne qualité", "de bonne facture")
          .setRarity(ERarity.RARE)),
  ARTISAN_RENOMME(new NbkQualityBuilder()
          .setNeutralAdjective("d'artisan renommé")
          .setRarity(ERarity.EPIC)),
  DURANDIL(new NbkQualityBuilder()
          .setNeutralAdjective("Durandil(TM)")
          .setRarity(ERarity.LEGENDARY));

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

  public static final EnumMap<ERarity, ENbkQuality> qualityMap = new EnumMap<>(
          Stream.of(ENbkQuality.values()).collect(Collectors.toMap(ENbkQuality::getRarity, Function.identity()))
  );

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
