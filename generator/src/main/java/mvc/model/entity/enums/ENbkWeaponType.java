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
          .oneHand()),
  LAME_1MAIN(new NbKWeaponTypeBuilder()
          .setMasculineNouns("sabre")
          .setFeminineNouns("épée", "rapière")
          .setRarity(ERarity.COMMON)
          .oneHand()),
  LAME_2MAINS(new NbKWeaponTypeBuilder()
          .setFeminineNouns("épée")
          .setRarity(ERarity.COMMON)
          .twoHands()),
  HACHE_1MAIN(new NbKWeaponTypeBuilder()
          .setFeminineNouns("hache")
          .setRarity(ERarity.COMMON)
          .oneHand()),
  HACHE_JET(new NbKWeaponTypeBuilder()
          .setFeminineNouns("hache de jet")
          .setRarity(ERarity.UNCOMMON)
          .oneHand()),
  HACHE_2MAINS(new NbKWeaponTypeBuilder()
          .setFeminineNouns("hache")
          .setRarity(ERarity.UNCOMMON)
          .twoHands()),
  MARTEAU_1MAIN(new NbKWeaponTypeBuilder()
          .setMasculineNouns("marteau")
          .setFeminineNouns("masse")
          .setRarity(ERarity.UNCOMMON)
          .oneHand()),
  MARTEAU_2MAINS(new NbKWeaponTypeBuilder()
          .setMasculineNouns("marteau")
          .setRarity(ERarity.UNCOMMON)
          .twoHands()),
  LANCE(new NbKWeaponTypeBuilder()
          .setFeminineNouns("lance", "pique")
          .setRarity(ERarity.UNCOMMON)
          .twoHands()),
  JAVELOT(new NbKWeaponTypeBuilder()
          .setMasculineNouns("javelot")
          .setRarity(ERarity.UNCOMMON)
          .oneHand()),
  ARC(new NbKWeaponTypeBuilder()
          .setMasculineNouns("arc court", "arc long")
          .setRarity(ERarity.COMMON)
          .twoHands()),
  ARBALETE(new NbKWeaponTypeBuilder()
          .setFeminineNouns("arbalète")
          .setRarity(ERarity.UNCOMMON)
          .twoHands());

  private final List<FrenchString> names;
  private final ERarity rarity;
  private final int nbHands;

  ENbkWeaponType(NbKWeaponTypeBuilder builder) {
    this.names = builder.getNames();
    this.rarity = builder.getRarity();
    this.nbHands = builder.getNbHands();
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
    String s = nbHands == 2 ? "s" : "";
    noun.addString(" à " + nbHands + " main" + s + " ");
    return noun;
  }

  private static class NbKWeaponTypeBuilder extends ItemTypeBuilder {

    private int nbHands = 0;

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

    NbKWeaponTypeBuilder oneHand() {
      this.nbHands = 1;
      return this;
    }

    NbKWeaponTypeBuilder twoHands() {
      this.nbHands = 2;
      return this;
    }

    int getNbHands() {
      return nbHands;
    }
  }
}
