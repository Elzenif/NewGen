package nbk.model.entity.enums;

import commons.model.entity.enums.ERarity;
import commons.model.entity.utils.builders.ItemTypeBuilder;
import commons.model.entity.utils.builders.QuantityBuilder;
import commons.model.entity.utils.fields.HasQuantity;
import commons.model.entity.utils.fields.ItemType;
import commons.utils.MathUtils;
import commons.utils.SPositive;
import commons.utils.french.FrenchNoun;
import commons.utils.french.Gender;
import nbk.model.entity.utils.builders.DistanceBuilder;
import nbk.model.entity.utils.builders.NbHandsBuilder;
import nbk.model.entity.utils.builders.SizeBuilder;
import nbk.model.entity.utils.fields.HasDistance;
import nbk.model.entity.utils.fields.HasNbHands;
import nbk.model.entity.utils.fields.HasSize;
import nbk.model.entity.utils.fields.HasWeaponType;
import org.jetbrains.annotations.Contract;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 04/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkWeaponType implements ItemType<FrenchNoun>, HasWeaponType, HasQuantity, HasNbHands, HasDistance,
        HasSize {

  LAME_COURTE(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Poignard")
          .setFeminineNouns("Dague")
          .oneHand()
          .longDistance()
          .smallSize()),
  LAME_1MAIN(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Sabre")
          .setFeminineNouns("Epée", "Rapière")
          .oneHand()
          .printNbHands()),
  LAME_2MAINS(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Epée")
          .twoHands()
          .printNbHands()
          .largeSize()),
  HACHE_1MAIN(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Hache")
          .oneHand().printNbHands()),
  HACHE_JET(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Hache de jet")
          .uncommon()
          .oneHand()
          .longDistance()
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
          .longDistance()),
  ARC_COURT(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Arc court")
          .twoHands()
          .longDistance()),
  ARC_LONG(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Arc long")
          .twoHands()
          .longDistance()
          .largeSize()),
  FLECHE(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Flèche")
          .uncommon()
          .oneHand()
          .setQuantity(15)
          .longDistance()
          .smallSize()),
  ARBALETE(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Arbalète")
          .uncommon()
          .twoHands()
          .longDistance()),
  CARREAU(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Carreau")
          .rare()
          .oneHand()
          .setQuantity(15)
          .longDistance()
          .smallSize());

  private final List<FrenchNoun> names;
  private final ERarity rarity;
  private final ENbHands nbHands;
  private final boolean printNbHands;
  private final SPositive quantity;
  private final boolean distance;
  private final ESize size;

  ENbkWeaponType(NbKWeaponTypeBuilder builder) {
    names = builder.getNames();
    rarity = builder.getRarity();
    nbHands = builder.getNbHands();
    printNbHands = builder.getPrintNbHands();
    quantity = builder.getQuantity();
    size = builder.getSize();
    distance = builder.isLongDistance();
  }

  @Contract(pure = true)
  @Override
  public ENbkWeaponType getWeaponType() {
    return this;
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
  public boolean isLongDistance() {
    return distance;
  }

  @Override
  public ESize getSize() {
    return size;
  }


  private static class NbKWeaponTypeBuilder implements ItemTypeBuilder, QuantityBuilder, NbHandsBuilder,
          DistanceBuilder, SizeBuilder {

    List<FrenchNoun> names = new LinkedList<>();
    ERarity rarity = ERarity.COMMON;
    ENbHands nbHands;
    boolean printNbHands = false;
    SPositive quantity = SPositive.ONE;
    boolean distance = false;
    ESize size = ESize.NORMAL;

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
    public NbKWeaponTypeBuilder longDistance() {
      distance = true;
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
    public boolean isLongDistance() {
      return distance;
    }

    @Override
    public ESize getSize() {
      return size;
    }
  }
}