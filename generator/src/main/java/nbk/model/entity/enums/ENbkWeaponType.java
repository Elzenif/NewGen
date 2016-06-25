package nbk.model.entity.enums;

import commons.model.entity.enums.ERarity;
import commons.model.entity.utils.ItemType;
import commons.model.entity.utils.ItemTypeBuilder;
import commons.utils.MathUtils;
import commons.utils.french.FrenchNoun;
import commons.utils.french.Gender;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 04/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkWeaponType implements ItemType<FrenchNoun> {

  LAME_COURTE(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Poignard")
          .setFeminineNouns("Dague")
          .setRarity(ERarity.COMMON)
          .oneHand(false)
          .isDistance()),
  LAME_1MAIN(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Sabre")
          .setFeminineNouns("Epée", "Rapière")
          .setRarity(ERarity.COMMON)
          .oneHand(true)),
  LAME_2MAINS(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Epée")
          .setRarity(ERarity.COMMON)
          .twoHands(true)),
  HACHE_1MAIN(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Hache")
          .setRarity(ERarity.COMMON)
          .oneHand(true)),
  HACHE_JET(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Hache de jet")
          .setRarity(ERarity.UNCOMMON)
          .oneHand(false)
          .isDistance()),
  HACHE_2MAINS(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Hache")
          .setRarity(ERarity.UNCOMMON)
          .twoHands(true)),
  MARTEAU_1MAIN(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Marteau")
          .setFeminineNouns("Masse")
          .setRarity(ERarity.UNCOMMON)
          .oneHand(true)),
  MARTEAU_2MAINS(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Marteau")
          .setRarity(ERarity.UNCOMMON)
          .twoHands(true)),
  LANCE(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Lance", "Pique")
          .setRarity(ERarity.UNCOMMON)
          .twoHands(false)),
  JAVELOT(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Javelot")
          .setRarity(ERarity.UNCOMMON)
          .oneHand(false)
          .isDistance()),
  ARC(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Arc court", "Arc long")
          .setRarity(ERarity.COMMON)
          .twoHands(false)
          .isDistance()),
  FLECHE(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Flèche")
          .setRarity(ERarity.UNCOMMON)
          .oneHand(false)
          .setQuantity(15)
          .isDistance()),
  ARBALETE(new NbKWeaponTypeBuilder()
          .setFeminineNouns("Arbalète")
          .setRarity(ERarity.UNCOMMON)
          .twoHands(false)
          .isDistance()),
  CARREAU(new NbKWeaponTypeBuilder()
          .setMasculineNouns("Carreau")
          .setRarity(ERarity.RARE)
          .oneHand(false)
          .setQuantity(15)
          .isDistance());

  private final List<FrenchNoun> names;
  private final ERarity rarity;
  private final int nbHands;
  private final boolean printNbHands;
  private final int quantity;
  private final boolean distance;

  ENbkWeaponType(NbKWeaponTypeBuilder builder) {
    names = builder.getNames();
    rarity = builder.getRarity();
    nbHands = builder.getNbHands();
    printNbHands = builder.getPrintNbHands();
    quantity = builder.getQuantity();
    distance = builder.getDistance();
  }

  @Override
  public FrenchNoun getName() {
    FrenchNoun noun = new FrenchNoun(MathUtils.chooseRandom(names));
    if (printNbHands) {
      String s = nbHands == 2 ? "s" : "";
      noun.addString("à " + nbHands + " main" + s);
    }
    return noun;
  }

  @Override
  public ERarity getRarity() {
    return rarity;
  }

  public int getNbHands() {
    return nbHands;
  }

  public int getQuantity() {
    return quantity;
  }

  public boolean isDistance() {
    return distance;
  }


  private static class NbKWeaponTypeBuilder implements ItemTypeBuilder {

    final List<FrenchNoun> names = new LinkedList<>();
    ERarity rarity;
    int nbHands = 0;
    boolean printNbHands = false;
    int quantity = 1;
    private boolean distance = false;

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
    public NbKWeaponTypeBuilder setRarity(ERarity rarity) {
      this.rarity = rarity;
      return this;
    }

    NbKWeaponTypeBuilder oneHand(boolean printNbHands) {
      this.nbHands = 1;
      this.printNbHands = printNbHands;
      return this;
    }

    NbKWeaponTypeBuilder twoHands(boolean printNbHands) {
      this.nbHands = 2;
      this.printNbHands = printNbHands;
      return this;
    }

    NbKWeaponTypeBuilder setQuantity(int quantity) {
      this.quantity = quantity;
      return this;
    }

    NbKWeaponTypeBuilder isDistance() {
      this.distance = true;
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

    int getNbHands() {
      return nbHands;
    }

    boolean getPrintNbHands() {
      return printNbHands;
    }

    int getQuantity() {
      return quantity;
    }

    boolean getDistance() {
      return distance;
    }
  }
}
