package nbk.model.entity.living.characteristics.secondary.enums;

import commons.model.entity.characteristics.primary.builders.EntityTypeBuilder;
import commons.model.entity.characteristics.primary.builders.FrenchNounBuilder;
import commons.model.entity.characteristics.primary.enums.EGeneralRarity;
import commons.model.entity.characteristics.primary.fields.EntityType;
import commons.model.entity.characteristics.secondary.Secondary;
import commons.utils.MathUtils;
import commons.utils.SPositive;
import commons.utils.exception.StatNotInRangeException;
import commons.utils.french.FrenchNoun;
import commons.utils.french.Gender;
import nbk.model.entity.living.characteristics.primary.Stats;
import nbk.model.entity.living.characteristics.primary.builders.EVBuilder;
import nbk.model.entity.living.characteristics.primary.builders.StatsInRangeBuilder;
import nbk.model.entity.living.characteristics.primary.fields.HasEV;
import nbk.model.entity.living.characteristics.primary.fields.HasStatsInRange;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Germain on 28/08/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkOrigin implements Secondary, EntityType<FrenchNoun>, HasEV, HasStatsInRange {
  HUMAN(new ENbkOriginBuilder()
          .setMasculineNouns("Humain")
          .setFeminineNouns("Humaine")
          .common()
          .setEV(30)),
  BARBARIAN(new ENbkOriginBuilder()
          .setMasculineNouns("Barbare")
          .common()
          .setEV(35)
          .setMinCourage(12)
          .setMinStrength(13)),
  DWARF(new ENbkOriginBuilder()
          .setMasculineNouns("Nain")
          .setFeminineNouns("Naine")
          .common()
          .setEV(35)
          .setMinCourage(11)
          .setMinStrength(12)),
  HIGH_ELF(new ENbkOriginBuilder()
          .setMasculineNouns("Haut Elfe")
          .uncommon()
          .setEV(25)
          .setMinIntelligence(11)
          .setMinCharisma(12)
          .setMinAgility(12)
          .setMaxStrength(12)),
  HALF_ELF(new ENbkOriginBuilder()
          .setMasculineNouns("Demi-Elfe")
          .uncommon()
          .setEV(28)
          .setMinCharisma(10)
          .setMinAgility(11)),
  SYLVAN_ELF(new ENbkOriginBuilder()
          .setMasculineNouns("Elfe Sylvain")
          .common()
          .setEV(25)
          .setMinCharisma(12)
          .setMinAgility(10)
          .setMaxStrength(11)),
  DARK_ELF(new ENbkOriginBuilder()
          .setMasculineNouns("Elfe noir")
          .uncommon()
          .setEV(25)
          .setMinIntelligence(12)
          .setMinAgility(13)),
  ORC(new ENbkOriginBuilder()
          .setMasculineNouns("Orque")
          .uncommon()
          .setEV(35)
          .setMaxIntelligence(8)
          .setMaxCharisma(10)
          .setMinStrength(12)),
  HALF_ORC(new ENbkOriginBuilder()
          .setMasculineNouns("Demi-Orque")
          .uncommon()
          .setEV(35)
          .setMaxIntelligence(10)
          .setMaxAgility(11)
          .setMinStrength(12)),
  GOBLIN(new ENbkOriginBuilder()
          .setMasculineNouns("Gobelin")
          .uncommon()
          .setEV(20)
          .setMaxCourage(10)
          .setMaxIntelligence(10)
          .setMaxCharisma(8)
          .setMaxStrength(9)),
  OGRE(new ENbkOriginBuilder()
          .setMasculineNouns("Ogre")
          .setFeminineNouns("Ogresse")
          .uncommon()
          .setEV(45)
          .setMaxIntelligence(9)
          .setMaxCharisma(10)
          .setMaxAgility(11)
          .setMinStrength(13)),
  HOBBIT(new ENbkOriginBuilder()
          .setMasculineNouns("Hobbit")
          .uncommon()
          .setEV(25)
          .setMinCourage(12)
          .setMinIntelligence(10)
          .setMaxStrength(10)),
  GNOME(new ENbkOriginBuilder()
          .setMasculineNouns("Gnome")
          .uncommon()
          .setEV(15)
          .setMinIntelligence(10)
          .setMinAgility(13)
          .setMaxStrength(8));


  private final List<FrenchNoun> names;
  private final SPositive ev;
  private final EGeneralRarity rarity;
  private final Stats minStats;
  private final Stats maxStats;

  ENbkOrigin(ENbkOriginBuilder builder) {
    names = builder.getNames();
    rarity = builder.getRarity();
    ev = builder.getEV();
    minStats = builder.getMinStats();
    maxStats = builder.getMaxStats();
  }

  @NotNull
  @Contract(pure = true)
  public static Predicate<ENbkOrigin> getPredicate(Stats stats) {
    return origin -> origin.getMinStats().entrySet().stream()
        .map(entry -> entry.getValue() <= stats.get(entry.getKey()))
        .reduce(Boolean::logicalAnd).orElse(true)
        && origin.getMaxStats().entrySet().stream()
        .map(entry -> entry.getValue() >= stats.get(entry.getKey()))
        .reduce(Boolean::logicalAnd).orElse(true);
  }

  @Contract(" -> !null")
  @Override
  public FrenchNoun getName() {
    return new FrenchNoun(MathUtils.chooseRandom(names));
  }

  @Override
  public EGeneralRarity getRarity() {
    return rarity;
  }

  @Override
  public SPositive getEV() {
    return ev;
  }

  public Stats getMinStats() {
    return minStats;
  }

  public Stats getMaxStats() {
    return maxStats;
  }

  private static class ENbkOriginBuilder implements EntityTypeBuilder, EVBuilder, FrenchNounBuilder,
          StatsInRangeBuilder {

    private final List<FrenchNoun> names = new LinkedList<>();
    private EGeneralRarity rarity;
    private SPositive ev;
    private Stats minStats;
    private Stats maxStats;

    // Setters
    @Override
    public ENbkOriginBuilder setMasculineNouns(String... names) {
      for (String name : names) {
        addName(new FrenchNoun(Gender.MASCULINE, name));
      }
      return this;
    }

    @Override
    public ENbkOriginBuilder setFeminineNouns(String... names) {
      for (String name : names) {
        addName(new FrenchNoun(Gender.FEMININE, name));
      }
      return this;
    }

    void addName(FrenchNoun name) {
      names.add(name);
    }

    @Override
    public ENbkOriginBuilder setNames(Object first, Object... others) {
      throw new UnsupportedOperationException("Use setMasculineNouns or setFeminineNouns instead");
    }

    @Override
    public ENbkOriginBuilder common() {
      rarity = EGeneralRarity.COMMON;
      return this;
    }

    @Override
    public ENbkOriginBuilder uncommon() {
      rarity = EGeneralRarity.UNCOMMON;
      return this;
    }

    @Override
    public ENbkOriginBuilder rare() {
      rarity = EGeneralRarity.RARE;
      return this;
    }

    @Override
    public ENbkOriginBuilder setMinCourage(int minCourage) {
      if (minStats == null)
        minStats = new Stats();
      try {
        minStats.setCourage(minCourage);
      } catch (StatNotInRangeException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public ENbkOriginBuilder setMinIntelligence(int minIntelligence) {
      if (minStats == null)
        minStats = new Stats();
      try {
        minStats.setIntelligence(minIntelligence);
      } catch (StatNotInRangeException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public ENbkOriginBuilder setMinCharisma(int minCharisma) {
      if (minStats == null)
        minStats = new Stats();
      try {
        minStats.setCharisma(minCharisma);
      } catch (StatNotInRangeException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public ENbkOriginBuilder setMinAgility(int minAgility) {
      if (minStats == null)
        minStats = new Stats();
      try {
        minStats.setAgility(minAgility);
      } catch (StatNotInRangeException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public ENbkOriginBuilder setMinStrength(int minStrength) {
      if (minStats == null)
        minStats = new Stats();
      try {
        minStats.setStrength(minStrength);
      } catch (StatNotInRangeException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public ENbkOriginBuilder setMaxCourage(int maxCourage) {
      if (maxStats == null)
        maxStats = new Stats();
      try {
        maxStats.setCourage(maxCourage);
      } catch (StatNotInRangeException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public ENbkOriginBuilder setMaxIntelligence(int maxIntelligence) {
      if (maxStats == null)
        maxStats = new Stats();
      try {
        maxStats.setIntelligence(maxIntelligence);
      } catch (StatNotInRangeException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public ENbkOriginBuilder setMaxCharisma(int maxCharisma) {
      if (maxStats == null)
        maxStats = new Stats();
      try {
        maxStats.setCharisma(maxCharisma);
      } catch (StatNotInRangeException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public ENbkOriginBuilder setMaxAgility(int maxAgility) {
      if (maxStats == null)
        maxStats = new Stats();
      try {
        maxStats.setAgility(maxAgility);
      } catch (StatNotInRangeException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public ENbkOriginBuilder setMaxStrength(int maxStrength) {
      if (maxStats == null)
        maxStats = new Stats();
      try {
        maxStats.setStrength(maxStrength);
      } catch (StatNotInRangeException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    // Getters
    @Override
    public List<FrenchNoun> getNames() {
      return names;
    }

    @Override
    public EGeneralRarity getRarity() {
      return rarity;
    }

    @Override
    public SPositive getEV() {
      return ev;
    }

    @Override
    public ENbkOriginBuilder setEV(int ev) {
      this.ev = new SPositive(ev);
      return this;
    }

    @Override
    public Stats getMinStats() {
      return (minStats == null) ? new Stats() : minStats;
    }

    @Override
    public Stats getMaxStats() {
      return (maxStats == null) ? new Stats() : maxStats;
    }
  }
}
