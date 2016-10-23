package nbk.model.entity.living.characteristics.secondary.enums;

import commons.model.entity.characteristics.primary.builders.EntityTypeBuilder;
import commons.model.entity.characteristics.primary.builders.FrenchNounBuilder;
import commons.model.entity.characteristics.primary.enums.EGeneralRarity;
import commons.model.entity.characteristics.primary.fields.EntityType;
import commons.model.entity.characteristics.secondary.Secondary;
import commons.utils.MathUtils;
import commons.utils.exception.StatNotInRangeException;
import commons.utils.french.FrenchNoun;
import commons.utils.french.Gender;
import nbk.model.entity.living.characteristics.primary.Stats;
import nbk.model.entity.living.characteristics.primary.builders.EABuilder;
import nbk.model.entity.living.characteristics.primary.builders.StatsInRangeBuilder;
import nbk.model.entity.living.characteristics.primary.fields.HasEA;
import nbk.model.entity.living.characteristics.primary.fields.HasStatsInRange;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Germain on 08/09/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkProfession implements Secondary, EntityType<FrenchNoun>, HasEA, HasStatsInRange {

  WARRIOR(new ENbkProfessionBuilder()
      .setMasculineNouns("Guerrier", "Gladiateur")
      .setFeminineNouns("Guerrière", "Gladiateur")
      .setMinCourage(12)
      .setMinStrength(12)) {
    @Override
    public int getEV(ENbkOrigin origin) {
      return (origin == ENbkOrigin.HUMAN || origin == ENbkOrigin.BARBARIAN) ? origin.getEV() : origin.getEV() + 5;
    }
  },
  NINJA(new ENbkProfessionBuilder()
      .setNeutralNouns("Ninja", "Assassin")
      .uncommon()
      .setMinAgility(13)),
  THIEF(new ENbkProfessionBuilder()
      .setMasculineNouns("Voleur")
      .setFeminineNouns("Voleuse")
      .setMinAgility(12)),
  PRIEST(new ENbkProfessionBuilder()
      .setMasculineNouns("Prêtre")
      .setFeminineNouns("Prêtresse")
      .uncommon()
      .setEA(20)
      .setMinCharisma(12)),
  MAGE(new ENbkProfessionBuilder()
      .setMasculineNouns("Mage", "Sorcier")
      .setFeminineNouns("Sorcière")
      .uncommon()
      .setEA(30)
      .setMinIntelligence(12)) {
    @Override
    public int getEV(ENbkOrigin origin) {
      return (origin == ENbkOrigin.HUMAN) ? 20 : (int) (origin.getEV() * 0.7);
    }
  },
  PALADIN(new ENbkProfessionBuilder()
      .setMasculineNouns("Paladin")
      .setFeminineNouns("Paladine")
      .uncommon()
      .setEA(10)
      .setMinCharisma(11)
      .setMinCourage(12)
      .setMinStrength(9)
      .setMinIntelligence(10)) {
    @Override
    public int getEV(ENbkOrigin origin) {
      return (origin == ENbkOrigin.HUMAN) ? 32 : origin.getEV() + 2;
    }
  },
  RANGER(new ENbkProfessionBuilder()
      .setNeutralNouns("Ranger")
      .setMinAgility(10)
      .setMinCharisma(10)),
  BARD(new ENbkProfessionBuilder()
      .setNeutralNouns("Ménestrel")
      .uncommon()
      .setMinAgility(11)
      .setMinCharisma(12)),
  PIRATE(new ENbkProfessionBuilder()
      .setNeutralNouns("Pirate")
      .uncommon()
      .setMinAgility(11)
      .setMinCourage(11)),
  SELLER(new ENbkProfessionBuilder()
      .setMasculineNouns("Marchand")
      .setFeminineNouns("Marchande")
      .rare()
      .setMinIntelligence(12)
      .setMinCharisma(11)),
  ENGINEER(new ENbkProfessionBuilder()
      .setNeutralNouns("Ingénieur")
      .rare()
      .setMinAgility(11)),
  NOBLE(new ENbkProfessionBuilder()
      .setMasculineNouns("Bourgeois", "Noble")
      .setFeminineNouns("Bourgeoise", "Noble")
      .rare()
      .setMinIntelligence(10)
      .setMinCharisma(11)),;

  final List<FrenchNoun> names;
  private final int ea;
  private final EGeneralRarity rarity;
  private final Stats minStats;
  private final Stats maxStats;

  ENbkProfession(ENbkProfessionBuilder builder) {
    names = builder.getNames();
    rarity = builder.getRarity();
    ea = builder.getEA();
    minStats = builder.getMinStats();
    maxStats = builder.getMaxStats();
  }

  @NotNull
  @Contract(pure = true)
  public static Predicate<ENbkProfession> getPredicate(Stats stats) {
    return profession -> profession.getMinStats().entrySet().stream()
        .filter(entry -> stats.containsKey(entry.getKey()))
        .map(entry -> entry.getValue() <= stats.get(entry.getKey()))
        .reduce(Boolean::logicalAnd).orElse(true)
        && profession.getMaxStats().entrySet().stream()
        .filter(entry -> stats.containsKey(entry.getKey()))
        .map(entry -> entry.getValue() >= stats.get(entry.getKey()))
        .reduce(Boolean::logicalAnd).orElse(true);
  }

  @Contract(" -> !null")
  @Override
  public FrenchNoun getName() {
    return new FrenchNoun(MathUtils.chooseRandom(names));
  }

  public FrenchNoun getName(Gender gender) {
    if (gender == Gender.NEUTRAL) {
      return getName();
    }
    List<FrenchNoun> frenchNouns = names.stream()
        .filter(name -> name.getGender() == gender || name.getGender() == Gender.NEUTRAL)
        .collect(Collectors.toList());
    return new FrenchNoun(MathUtils.chooseRandom(frenchNouns));
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
  public int getEA() {
    return ea;
  }

  public int getEV(ENbkOrigin origin) {
    return origin.getEV();
  }


  private static class ENbkProfessionBuilder implements EntityTypeBuilder, EABuilder, FrenchNounBuilder,
      StatsInRangeBuilder {

    private final List<FrenchNoun> names = new LinkedList<>();
    private EGeneralRarity rarity = EGeneralRarity.COMMON;
    private int ev = 0;
    private int ea = 0;
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

    @Override
    public ENbkProfessionBuilder setNeutralNouns(String... names) {
      for (String name : names) {
        addName(new FrenchNoun(Gender.NEUTRAL, name));
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
    public int getEA() {
      return ea;
    }

    @Override
    public ENbkProfessionBuilder setEA(int ea) {
      this.ea = ea;
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
