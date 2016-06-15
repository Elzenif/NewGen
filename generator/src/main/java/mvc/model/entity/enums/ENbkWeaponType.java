package mvc.model.entity.enums;

import mvc.model.entity.utils.ERarity;
import mvc.model.entity.utils.ItemType;
import mvc.model.entity.utils.ItemTypeBuilder;
import utils.MathUtils;

import java.util.List;

/**
 * Created by Germain on 04/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkWeaponType implements ItemType {

  LAME_COURTE(new WeaponTypeBuilder()
          .setNames("poignard", "dague")
          .setRarity(ERarity.COMMON)
          .oneHand()),
  LAME_1MAIN(new WeaponTypeBuilder()
          .setNames("épée", "rapière", "sabre")
          .setRarity(ERarity.COMMON)
          .oneHand()),
  LAME_2MAINS(new WeaponTypeBuilder()
          .setNames("épée")
          .setRarity(ERarity.COMMON)
          .twoHands()),
  HACHE_1MAIN(new WeaponTypeBuilder()
          .setNames("hache")
          .setRarity(ERarity.COMMON)
          .oneHand()),
  HACHE_JET(new WeaponTypeBuilder()
          .setNames("hache de jet")
          .setRarity(ERarity.UNCOMMON)
          .oneHand()),
  HACHE_2MAINS(new WeaponTypeBuilder()
          .setNames("hache")
          .setRarity(ERarity.UNCOMMON)
          .twoHands()),
  MARTEAU_1MAIN(new WeaponTypeBuilder()
          .setNames("marteau", "masse")
          .setRarity(ERarity.UNCOMMON)
          .oneHand()),
  MARTEAU_2MAINS(new WeaponTypeBuilder()
          .setNames("marteau")
          .setRarity(ERarity.UNCOMMON)
          .twoHands()),
  LANCE(new WeaponTypeBuilder()
          .setNames("lance", "pique")
          .setRarity(ERarity.UNCOMMON)
          .twoHands()),
  JAVELOT(new WeaponTypeBuilder()
          .setNames("javelot")
          .setRarity(ERarity.UNCOMMON)
          .oneHand()),
  ARC(new WeaponTypeBuilder()
          .setNames("arc court", "arc long")
          .setRarity(ERarity.COMMON)
          .twoHands()),
  ARBALETE(new WeaponTypeBuilder()
          .setNames("arbalete")
          .setRarity(ERarity.UNCOMMON)
          .twoHands());

  private final List<String> names;
  private final ERarity rarity;
  private final int nbHands;

  ENbkWeaponType(WeaponTypeBuilder builder) {
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
  public String toString() {
    return MathUtils.chooseRandom(names) + "(" + nbHands + ")";
  }

  private static class WeaponTypeBuilder extends ItemTypeBuilder {

    private int nbHands = 0;

    WeaponTypeBuilder() {
    }

    @Override
    protected WeaponTypeBuilder setNames(String mainName, String... otherNames) {
      return (WeaponTypeBuilder) super.setNames(mainName, otherNames);
    }

    @Override
    protected WeaponTypeBuilder setRarity(ERarity rarity) {
      return (WeaponTypeBuilder) super.setRarity(rarity);
    }

    WeaponTypeBuilder oneHand() {
      this.nbHands = 1;
      return this;
    }

    WeaponTypeBuilder twoHands() {
      this.nbHands = 2;
      return this;
    }

    int getNbHands() {
      return nbHands;
    }
  }
}
