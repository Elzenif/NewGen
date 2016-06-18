package mvc.model.entity.enums;

import mvc.model.entity.utils.ERarity;
import mvc.model.entity.utils.ItemType;
import mvc.model.entity.utils.ItemTypeBuilder;
import utils.french.FrenchNoun;
import utils.french.FrenchString;
import utils.MathUtils;
import utils.french.Gender;

import java.util.List;

/**
 * Created by Germain on 04/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkWeaponType implements ItemType {

  LAME_COURTE(new NbKWeaponTypeBuilder()
          .setMasculineNouns("poignard")
          .setFeminineNouns("dague")
          .setRarity(ERarity.COMMON)
          .oneHand(false)),
  LAME_1MAIN(new NbKWeaponTypeBuilder()
          .setMasculineNouns("sabre")
          .setFeminineNouns("épée", "rapière")
          .setRarity(ERarity.COMMON)
          .oneHand(true)),
  LAME_2MAINS(new NbKWeaponTypeBuilder()
          .setFeminineNouns("épée")
          .setRarity(ERarity.COMMON)
          .twoHands(true)),
  HACHE_1MAIN(new NbKWeaponTypeBuilder()
          .setFeminineNouns("hache")
          .setRarity(ERarity.COMMON)
          .oneHand(true)),
  HACHE_JET(new NbKWeaponTypeBuilder()
          .setFeminineNouns("hache de jet")
          .setRarity(ERarity.UNCOMMON)
          .oneHand(false)),
  HACHE_2MAINS(new NbKWeaponTypeBuilder()
          .setFeminineNouns("hache")
          .setRarity(ERarity.UNCOMMON)
          .twoHands(true)),
  MARTEAU_1MAIN(new NbKWeaponTypeBuilder()
          .setMasculineNouns("marteau")
          .setFeminineNouns("masse")
          .setRarity(ERarity.UNCOMMON)
          .oneHand(true)),
  MARTEAU_2MAINS(new NbKWeaponTypeBuilder()
          .setMasculineNouns("marteau")
          .setRarity(ERarity.UNCOMMON)
          .twoHands(true)),
  LANCE(new NbKWeaponTypeBuilder()
          .setFeminineNouns("lance", "pique")
          .setRarity(ERarity.UNCOMMON)
          .twoHands(false)),
  JAVELOT(new NbKWeaponTypeBuilder()
          .setMasculineNouns("javelot")
          .setRarity(ERarity.UNCOMMON)
          .oneHand(false)),
  ARC(new NbKWeaponTypeBuilder()
          .setMasculineNouns("arc court", "arc long")
          .setRarity(ERarity.COMMON)
          .twoHands(false)),
  ARBALETE(new NbKWeaponTypeBuilder()
          .setFeminineNouns("arbalète")
          .setRarity(ERarity.UNCOMMON)
          .twoHands(false));

  private final List<FrenchString> names;
  private final ERarity rarity;
  private final int nbHands;
  private final boolean printNbHands;

  ENbkWeaponType(NbKWeaponTypeBuilder builder) {
    this.names = builder.getNames();
    this.rarity = builder.getRarity();
    this.nbHands = builder.getNbHands();
    this.printNbHands = builder.getPrintNbHands();
  }

  @Override
  public ERarity getRarity() {
    return rarity;
  }

  public int getNbHands() {
    return nbHands;
  }

  @Override
  public FrenchNoun getName() {
    FrenchNoun noun = new FrenchNoun((FrenchNoun) MathUtils.chooseRandom(names));
    if (printNbHands) {
      String s = nbHands == 2 ? "s" : "";
      noun.addString("à " + nbHands + " main" + s);
    }
    return noun;
  }

  private static class NbKWeaponTypeBuilder extends ItemTypeBuilder {

    private int nbHands = 0;
    private boolean printNbHands = false;

    private NbKWeaponTypeBuilder setMasculineNouns(String... names) {
      for (String name : names) {
        addName(new FrenchNoun(Gender.MASCULINE, name));
      }
      return this;
    }

    private NbKWeaponTypeBuilder setFeminineNouns(String... names) {
      for (String name : names) {
        addName(new FrenchNoun(Gender.FEMININE, name));
      }
      return this;
    }

    @Override
    protected NbKWeaponTypeBuilder setRarity(ERarity rarity) {
      return (NbKWeaponTypeBuilder) super.setRarity(rarity);
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

    int getNbHands() {
      return nbHands;
    }

    public boolean getPrintNbHands() {
      return printNbHands;
    }
  }
}
