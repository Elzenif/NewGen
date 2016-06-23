package nbk.model.entity.enums;

import commons.model.entity.utils.ERarity;
import commons.model.entity.utils.ItemType;
import commons.model.entity.utils.ItemTypeBuilder;
import commons.utils.MathUtils;
import commons.utils.french.FrenchAdjective;
import commons.utils.french.FrenchGenderAdjective;
import commons.utils.french.FrenchNeutralAdjective;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Germain on 16/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkQuality implements ItemType<FrenchAdjective> {

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
          .setNeutralAdjective("d'artisan renommé", "de luxe")
          .setRarity(ERarity.EPIC)),
  DURANDIL(new NbkQualityBuilder()
          .setNeutralAdjective("Durandil(TM)")
          .setRarity(ERarity.LEGENDARY));

  private final List<FrenchAdjective> names;
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
    return MathUtils.chooseRandom(names);
  }

  public static final EnumMap<ERarity, ENbkQuality> QUALITY_MAP = new EnumMap<>(
          Stream.of(ENbkQuality.values()).collect(Collectors.toMap(ENbkQuality::getRarity, Function.identity()))
  );

  private static class NbkQualityBuilder implements ItemTypeBuilder {

    List<FrenchAdjective> names = new LinkedList<>();
    ERarity rarity;

    NbkQualityBuilder setNeutralAdjective(String... names) {
      for (String name : names) {
        addName(new FrenchNeutralAdjective(name));
      }
      return this;
    }

    NbkQualityBuilder setGenderAdjective(String masculineForm, String feminineForm) {
      addName(new FrenchGenderAdjective(masculineForm, feminineForm));
      return this;
    }

    void addName(FrenchAdjective name) {
      names.add(name);
    }

    @Override
    public NbkQualityBuilder setRarity(ERarity rarity) {
      this.rarity = rarity;
      return this;
    }

    @Override
    public List<FrenchAdjective> getNames() {
      return names;
    }

    @Override
    public ERarity getRarity() {
      return rarity;
    }
  }
}
