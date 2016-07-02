package nbk.model.entity.enums;

import commons.model.entity.enums.ERarity;
import commons.model.entity.utils.builders.ItemTypeBuilder;
import commons.model.entity.utils.fields.ItemType;
import commons.utils.MathUtils;
import commons.utils.french.FrenchAdjective;
import commons.utils.french.FrenchGenderAdjective;
import commons.utils.french.FrenchNeutralAdjective;
import nbk.model.entity.utils.fields.HasQuality;
import org.jetbrains.annotations.Contract;

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
public enum ENbkQuality implements ItemType<FrenchAdjective>, HasQuality {

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

  @Contract(pure = true)
  @Override
  public ENbkQuality getQuality() {
    return this;
  }

  public static final EnumMap<ERarity, ENbkQuality> QUALITY_MAP = new EnumMap<>(
          Stream.of(ENbkQuality.values()).collect(Collectors.toMap(ENbkQuality::getRarity, Function.identity()))
  );


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
