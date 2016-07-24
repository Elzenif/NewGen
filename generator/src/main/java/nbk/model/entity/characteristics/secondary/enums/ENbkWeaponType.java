package nbk.model.entity.characteristics.secondary.enums;

import commons.model.entity.characteristics.primary.builders.ItemTypeBuilder;
import commons.model.entity.characteristics.primary.builders.QuantityBuilder;
import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.characteristics.primary.fields.HasQuantity;
import commons.model.entity.characteristics.primary.fields.ItemType;
import commons.model.entity.characteristics.secondary.Secondary;
import commons.model.entity.constraints.Constraints;
import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.MathUtils;
import commons.utils.SPositive;
import commons.utils.french.FrenchNoun;
import commons.utils.french.Gender;
import nbk.model.entity.characteristics.primary.builders.NbHandsBuilder;
import nbk.model.entity.characteristics.primary.builders.RangeBuilder;
import nbk.model.entity.characteristics.primary.builders.SizeBuilder;
import nbk.model.entity.characteristics.primary.enums.ENbHands;
import nbk.model.entity.characteristics.primary.enums.ERange;
import nbk.model.entity.characteristics.primary.enums.ESize;
import nbk.model.entity.characteristics.primary.fields.HasNbHands;
import nbk.model.entity.characteristics.primary.fields.HasRange;
import nbk.model.entity.characteristics.primary.fields.HasSize;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Germain on 04/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkWeaponType implements Secondary, ItemType<FrenchNoun>, HasQuantity, HasNbHands, HasRange, HasSize {

  LAME_COURTE(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Poignard")
          .setFeminineNouns("Dague")
          .common()
          .oneHand()
          .longRange()
          .smallSize()),
  LAME_1MAIN(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Sabre")
          .setFeminineNouns("Epée", "Rapière")
          .common()
          .oneHand()
          .printNbHands()),
  LAME_2MAINS(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Epée")
          .common()
          .twoHands()
          .printNbHands()
          .largeSize()),
  HACHE_1MAIN(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Hache")
          .common()
          .oneHand()
          .printNbHands()),
  HACHE_JET(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Hache de jet")
          .uncommon()
          .oneHand()
          .longRange()
          .smallSize()),
  HACHE_2MAINS(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Hache")
          .uncommon()
          .twoHands()
          .printNbHands()
          .largeSize()),
  MARTEAU_1MAIN(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Marteau")
          .setFeminineNouns("Masse")
          .uncommon()
          .oneHand()
          .printNbHands()),
  MARTEAU_2MAINS(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Marteau")
          .uncommon()
          .twoHands()
          .printNbHands()
          .largeSize()),
  LANCE(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Lance", "Pique")
          .uncommon()
          .twoHands()
          .largeSize()),
  JAVELOT(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Javelot")
          .uncommon()
          .oneHand()
          .longRange()),
  ARC_COURT(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Arc court")
          .common()
          .twoHands()
          .longRange()),
  ARC_LONG(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Arc long")
          .common()
          .twoHands()
          .longRange()
          .largeSize()),
  FLECHE(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Flèche")
          .uncommon()
          .oneHand()
          .setQuantity(15)
          .longRange()
          .smallSize()),
  ARBALETE(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Arbalète")
          .uncommon()
          .twoHands()
          .longRange()),
  CARREAU(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Carreau")
          .rare()
          .oneHand()
          .setQuantity(15)
          .longRange()
          .smallSize());

  private final List<FrenchNoun> names;
  private final ERarity rarity;
  private final ENbHands nbHands;
  private final boolean printNbHands;
  private final SPositive quantity;
  private final ERange range;
  private final ESize size;

  ENbkWeaponType(NbKWeaponTypeBuilder builder) {
    names = builder.getNames();
    rarity = builder.getRarity();
    nbHands = builder.getNbHands();
    printNbHands = builder.getPrintNbHands();
    quantity = builder.getQuantity();
    size = builder.getSize();
    range = builder.getRange();
  }

  @Override
  public FrenchNoun getName() {
    FrenchNoun noun = new FrenchNoun(MathUtils.chooseRandom(names));
    if (printNbHands) {
      noun.addString("à " + nbHands.getNb() + " main" + nbHands.getPlural());
    }
    return noun;
  }

  @Override
  public ERarity getRarity() {
    return rarity;
  }

  @Override
  public ENbHands getNbHands() {
    return nbHands;
  }

  @Override
  public SPositive getQuantity() {
    return quantity;
  }

  @Override
  public ERange getRange() {
    return range;
  }

  @Override
  public ESize getSize() {
    return size;
  }

  public static Constraints<ENbkWeaponType> getConstraints() {
    return CONSTRAINTS;
  }

  private static final Constraints<ENbkWeaponType> CONSTRAINTS = Constraints.ConstraintsBuilder
          .<ENbkWeaponType>start()
          .setSecondaryClass(ENbkWeaponType.class)
          .setPrimaryClasses(ENbHands.class, ERange.class, ESize.class)
          .build();

  @NotNull
  public static Predicate<ENbkWeaponType> getPredicate(GlobalConstraints globalConstraints) {
    Predicate<ENbHands> nbHandsPredicate = globalConstraints.getPredicate(CONSTRAINTS, ENbHands.class);
    Predicate<ERange> rangePredicate = globalConstraints.getPredicate(CONSTRAINTS, ERange.class);
    Predicate<ESize> sizePredicate = globalConstraints.getPredicate(CONSTRAINTS, ESize.class);
    return weaponType -> nbHandsPredicate.test(weaponType.getNbHands())
            && rangePredicate.test(weaponType.getRange())
            && sizePredicate.test(weaponType.getSize());
  }

  private static class NbKWeaponTypeBuilder implements ItemTypeBuilder, QuantityBuilder, NbHandsBuilder,
          RangeBuilder, SizeBuilder {

    final List<FrenchNoun> names = new LinkedList<>();
    ERarity rarity;
    ENbHands nbHands;
    boolean printNbHands = false;
    SPositive quantity = SPositive.ONE;
    ERange range = ERange.CLOSE;
    ESize size = ESize.MEDIUM;

    NbKWeaponTypeBuilder setMasculineNouns(String... names) {
      for (String name : names) {
        addName(new FrenchNoun(Gender.MASCULINE, name));
      }
      return this;
    }

    NbKWeaponTypeBuilder setFeminineNouns(String... names) {
      for (String name : names) {
        addName(new FrenchNoun(Gender.FEMININE, name));
      }
      return this;
    }

    void addName(FrenchNoun name) {
      names.add(name);
    }

    @Override
    public ItemTypeBuilder setNames(Object first, Object... others) {
      throw new UnsupportedOperationException("Use setMasculineNouns or setFeminineNouns instead");
    }

    @Override
    public NbKWeaponTypeBuilder common() {
      rarity = ERarity.COMMON;
      return this;
    }

    @Override
    public NbKWeaponTypeBuilder uncommon() {
      rarity = ERarity.UNCOMMON;
      return this;
    }

    @Override
    public NbKWeaponTypeBuilder rare() {
      rarity = ERarity.RARE;
      return this;
    }

    @Override
    public NbKWeaponTypeBuilder epic() {
      rarity = ERarity.EPIC;
      return this;
    }

    @Override
    public NbKWeaponTypeBuilder legendary() {
      rarity = ERarity.LEGENDARY;
      return this;
    }

    @Override
    public NbKWeaponTypeBuilder oneHand() {
      this.nbHands = ENbHands.ONE;
      return this;
    }

    @Override
    public NbKWeaponTypeBuilder twoHands() {
      this.nbHands = ENbHands.TWO;
      return this;
    }

    NbKWeaponTypeBuilder printNbHands() {
      this.printNbHands = true;
      return this;
    }

    @Override
    public NbKWeaponTypeBuilder setQuantity(int quantity) {
      this.quantity = new SPositive(quantity);
      return this;
    }

    @Override
    public NbKWeaponTypeBuilder longRange() {
      range = ERange.LONG;
      return this;
    }

    @Override
    public NbKWeaponTypeBuilder smallSize() {
      size = ESize.SMALL;
      return this;
    }

    @Override
    public NbKWeaponTypeBuilder largeSize() {
      size = ESize.LARGE;
      return this;
    }

    @Override
    public List<FrenchNoun> getNames() {
      return names;
    }

    @Override
    public ERarity getRarity() {
      return rarity;
    }

    @Override
    public ENbHands getNbHands() {
      return nbHands;
    }

    boolean getPrintNbHands() {
      return printNbHands;
    }

    @Override
    public SPositive getQuantity() {
      return quantity;
    }

    @Override
    public ERange getRange() {
      return range;
    }

    @Override
    public ESize getSize() {
      return size;
    }
  }
}