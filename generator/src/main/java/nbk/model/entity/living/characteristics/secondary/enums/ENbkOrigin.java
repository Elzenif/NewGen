package nbk.model.entity.living.characteristics.secondary.enums;

import commons.model.entity.characteristics.primary.builders.EntityTypeBuilder;
import commons.model.entity.characteristics.primary.builders.FrenchNounBuilder;
import commons.model.entity.characteristics.primary.enums.EGeneralRarity;
import commons.model.entity.characteristics.primary.fields.EntityType;
import commons.model.entity.characteristics.secondary.Secondary;
import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.MathUtils;
import commons.utils.SPositive;
import commons.utils.french.FrenchNoun;
import commons.utils.french.Gender;
import nbk.model.entity.living.characteristics.primary.builders.EVBuilder;
import nbk.model.entity.living.characteristics.primary.fields.HasEV;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Germain on 28/08/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkOrigin implements Secondary, EntityType<FrenchNoun>, HasEV {
  HUMAN(new ENbkOriginBuilder()
          .setMasculineNouns("Humain")
          .setFeminineNouns("Humaine")
          .common()
          .setEV(30));


  private final List<FrenchNoun> names;
  private final SPositive ev;
  private final EGeneralRarity rarity;

  ENbkOrigin(ENbkOriginBuilder builder) {
    names = builder.getNames();
    rarity = builder.getRarity();
    ev = builder.getEV();
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

  @NotNull
  @Contract(pure = true)
  public static Predicate<ENbkOrigin> getPredicate(GlobalConstraints globalConstraints) {
    return origin -> true;
  }

  private static class ENbkOriginBuilder implements EntityTypeBuilder, EVBuilder, FrenchNounBuilder {

    private List<FrenchNoun> names = new LinkedList<>();
    private EGeneralRarity rarity;
    private SPositive ev;

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
    public ENbkOriginBuilder setEV(int ev) {
      this.ev = new SPositive(ev);
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
  }
}
