package nbk.model.entity.characteristics.secondary.enums;

import commons.model.entity.characteristics.primary.builders.ItemTypeBuilder;
import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.characteristics.primary.fields.ItemType;
import commons.model.entity.characteristics.secondary.Secondary;
import commons.model.entity.constraints.Constraints;
import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.MathUtils;
import commons.utils.french.FrenchAdjective;
import commons.utils.french.FrenchGenderAdjective;
import commons.utils.french.FrenchNeutralAdjective;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Germain on 16/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkQuality implements Secondary, ItemType<FrenchAdjective> {

  MAUVAIS(new NbkQualityBuilder()
          .setGenderAdjective("grossier", "grossière")
          .setNeutralAdjective("perrave", "de base", "basique", "daubesque", "quelconque", "minable",
                  "de basse qualité")
          .common()),
  BASIQUE(new NbkQualityBuilder()
          .setGenderAdjective("correct", "correcte")
          .setNeutralAdjective("de qualité")
          .uncommon()),
  BONNE_QUALITE(new NbkQualityBuilder()
          .setNeutralAdjective("de bonne qualité", "de bonne facture")
          .rare()),
  ARTISAN_RENOMME(new NbkQualityBuilder()
          .setNeutralAdjective("d'artisan renommé", "de luxe")
          .epic()),
  DURANDIL(new NbkQualityBuilder()
          .setNeutralAdjective("Durandil(TM)")
          .legendary());

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

  public static Constraints<ENbkQuality> getConstraints() {
    return CONSTRAINTS;
  }

  private static final Constraints<ENbkQuality> CONSTRAINTS = Constraints.ConstraintsBuilder
          .<ENbkQuality>start()
          .setSecondaryClass(ENbkQuality.class)
          .setPrimaryClasses(ERarity.class)
          .build();

  public static Predicate<ENbkQuality> getPredicate(GlobalConstraints globalConstraints) {
    Predicate<ERarity> rarityPredicate = globalConstraints.getPredicate(ENbkQuality.getConstraints(), ERarity.class);
    return quality -> rarityPredicate.test(quality.getRarity());
  }


  private static class NbkQualityBuilder implements ItemTypeBuilder {

    final List<FrenchAdjective> names = new LinkedList<>();
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
    public ItemTypeBuilder setNames(Object first, Object... others) {
      throw new UnsupportedOperationException("Use setNeutralAdjective or setGenderAdjective instead");
    }

    @Override
    public NbkQualityBuilder common() {
      rarity = ERarity.COMMON;
      return this;
    }

    @Override
    public NbkQualityBuilder uncommon() {
      rarity = ERarity.UNCOMMON;
      return this;
    }

    @Override
    public NbkQualityBuilder rare() {
      rarity = ERarity.RARE;
      return this;
    }

    @Override
    public NbkQualityBuilder epic() {
      rarity = ERarity.EPIC;
      return this;
    }

    @Override
    public NbkQualityBuilder legendary() {
      rarity = ERarity.LEGENDARY;
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
