package nbk.model.entity.items.characteristics.secondary.enums;

import commons.model.commons.constraints.PredicateConstraints;
import commons.model.commons.constraints.PrimarySecondaryConstraints;
import commons.model.entity.characteristics.primary.builders.ItemTypeBuilder;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.characteristics.primary.fields.EntityType;
import commons.model.entity.characteristics.secondary.Secondary;
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
public enum ENbkQuality implements Secondary, EntityType<FrenchAdjective> {

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

  public static final EnumMap<EItemRarity, ENbkQuality> QUALITY_MAP = new EnumMap<>(
      Stream.of(ENbkQuality.values()).collect(Collectors.toMap(ENbkQuality::getRarity, Function.identity()))
  );
  private static final PrimarySecondaryConstraints<ENbkQuality> CONSTRAINTS = PrimarySecondaryConstraints.ConstraintsBuilder
      .<ENbkQuality>start()
      .setSecondaryClass(ENbkQuality.class)
      .setPrimaryClasses(EItemRarity.class)
      .build();
  private final List<FrenchAdjective> names;
  private final EItemRarity rarity;

  ENbkQuality(NbkQualityBuilder builder) {
    names = builder.getNames();
    rarity = builder.getRarity();
  }

  public static PrimarySecondaryConstraints<ENbkQuality> getConstraints() {
    return CONSTRAINTS;
  }

  public static Predicate<ENbkQuality> getPredicate(PredicateConstraints predicateConstraints) {
    Predicate<EItemRarity> rarityPredicate = predicateConstraints.getPredicate(ENbkQuality.getConstraints(), EItemRarity.class);
    return quality -> rarityPredicate.test(quality.getRarity());
  }

  @Override
  public EItemRarity getRarity() {
    return rarity;
  }

  @Override
  public FrenchAdjective getName() {
    return MathUtils.chooseRandom(names);
  }

  private static class NbkQualityBuilder implements ItemTypeBuilder {

    final List<FrenchAdjective> names = new LinkedList<>();
    EItemRarity rarity;

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
      rarity = EItemRarity.COMMON;
      return this;
    }

    @Override
    public NbkQualityBuilder uncommon() {
      rarity = EItemRarity.UNCOMMON;
      return this;
    }

    @Override
    public NbkQualityBuilder rare() {
      rarity = EItemRarity.RARE;
      return this;
    }

    @Override
    public NbkQualityBuilder epic() {
      rarity = EItemRarity.EPIC;
      return this;
    }

    @Override
    public NbkQualityBuilder legendary() {
      rarity = EItemRarity.LEGENDARY;
      return this;
    }

    @Override
    public List<FrenchAdjective> getNames() {
      return names;
    }

    @Override
    public EItemRarity getRarity() {
      return rarity;
    }
  }
}
