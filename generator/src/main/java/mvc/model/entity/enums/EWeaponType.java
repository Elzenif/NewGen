package mvc.model.entity.enums;

import mvc.model.entity.utils.ERarity;
import mvc.model.entity.utils.ItemTypeBuilder;
import mvc.model.entity.utils.ItemType;
import utils.MathUtils;

import java.util.List;

/**
 * Created by Germain on 04/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EWeaponType implements ItemType {

  SWORD(new WeaponTypeBuilder()
          .setNames("épée", "sabre", "rapière", "katana")
          .setRarity(ERarity.COMMON)
          .oneHand()),
  WAR_AXE(new WeaponTypeBuilder()
          .setNames("hache", "hache de guerre")
          .setRarity(ERarity.UNCOMMON)
          .oneHand()),
  WARHAMMER(new WeaponTypeBuilder()
          .setNames("marteau", "marteau de guerre")
          .setRarity(ERarity.RARE)
          .twoHands());

  private final List<String> names;
  private final ERarity rarity;
  private final int nbHands;

  EWeaponType(WeaponTypeBuilder builder) {
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
