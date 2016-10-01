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
 * Created by Germain on 08/09/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkProfession implements Secondary, EntityType<FrenchNoun>, HasEV, HasStatsInRange {
  WARRIOR(new ENbkProfessionBuilder()
          .setMasculineNouns("Guerrier", "Gladiateur")
          .setFeminineNouns("Guerrière", "Gladiateur")
          .common()
          .setEV(30)
          .setMinCourage(12)
          .setMinStrength(12)
  );

  private final List<FrenchNoun> names;
  private final SPositive ev;
  private final EGeneralRarity rarity;
  private final Stats minStats;
  private final Stats maxStats;

  ENbkProfession(ENbkProfessionBuilder builder) {
    names = builder.getNames();
    rarity = builder.getRarity();
    ev = builder.getEV();
    minStats = builder.getMinStats();
    maxStats = builder.getMaxStats();
  }

  @NotNull
  @Contract(pure = true)
  public static Predicate<ENbkProfession> getPredicate(Stats stats) {
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
  public Stats getMinStats() {
    return minStats;
  }

  @Override
  public Stats getMaxStats() {
    return maxStats;
  }

  @Override
  public EGeneralRarity getRarity() {
    return rarity;
  }

  @Override
  public SPositive getEV() {
    return ev;
  }

  private static class ENbkProfessionBuilder implements EntityTypeBuilder, EVBuilder, FrenchNounBuilder,
          StatsInRangeBuilder {

    private final List<FrenchNoun> names = new LinkedList<>();
    private EGeneralRarity rarity;
    private SPositive ev;
    private Stats minStats;
    private Stats maxStats;

    // Setters
    @Override
    public ENbkProfessionBuilder setMasculineNouns(String... names) {
      for (String name : names) {
        addName(new FrenchNoun(Gender.MASCULINE, name));
      }
      return this;
    }

    @Override
    public ENbkProfessionBuilder setFeminineNouns(String... names) {
      for (String name : names) {
        addName(new FrenchNoun(Gender.FEMININE, name));
      }
      return this;
    }

    void addName(FrenchNoun name) {
      names.add(name);
    }

    @Override
    public ENbkProfessionBuilder setNames(Object first, Object... others) {
      throw new UnsupportedOperationException("Use setMasculineNouns or setFeminineNouns instead");
    }

    @Override
    public ENbkProfessionBuilder common() {
      rarity = EGeneralRarity.COMMON;
      return this;
    }

    @Override
    public ENbkProfessionBuilder uncommon() {
      rarity = EGeneralRarity.UNCOMMON;
      return this;
    }

    @Override
    public ENbkProfessionBuilder rare() {
      rarity = EGeneralRarity.RARE;
      return this;
    }

    @Override
    public ENbkProfessionBuilder setMinCourage(int minCourage) {
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
    public ENbkProfessionBuilder setMinIntelligence(int minIntelligence) {
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
    public ENbkProfessionBuilder setMinCharisma(int minCharisma) {
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
    public ENbkProfessionBuilder setMinAgility(int minAgility) {
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
    public ENbkProfessionBuilder setMinStrength(int minStrength) {
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
    public ENbkProfessionBuilder setMaxCourage(int maxCourage) {
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
    public ENbkProfessionBuilder setMaxIntelligence(int maxIntelligence) {
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
    public ENbkProfessionBuilder setMaxCharisma(int maxCharisma) {
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
    public ENbkProfessionBuilder setMaxAgility(int maxAgility) {
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
    public ENbkProfessionBuilder setMaxStrength(int maxStrength) {
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
    public ENbkProfessionBuilder setEV(int ev) {
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
