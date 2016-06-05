package mvc.model.entity.enums;

import mvc.model.entity.enums.utils.ItemTypeBuilder;
import mvc.model.entity.enums.utils.ItemType;
import utils.MathUtils;

import java.util.List;

/**
 * Created by Germain on 04/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum WeaponType implements ItemType {

  SWORD(new WeaponTypeBuilder()
          .setNames("épée", "sabre", "rapière", "katana")
          .setProba(10)
          .oneHand()),
  WAR_AXE(new WeaponTypeBuilder()
          .setNames("hache", "hache de guerre")
          .setProba(8)
          .oneHand()),
  WARHAMMER(new WeaponTypeBuilder()
          .setNames("marteau", "marteau de guerre")
          .setProba(9)
          .twoHands());

  private final List<String> names;
  private final int proba;
  private final int nbHands;

  WeaponType(WeaponTypeBuilder builder) {
    this.names = builder.getNames();
    this.proba = builder.getProba();
    this.nbHands = builder.getNbHands();
  }

  @Override
  public int getProba() {
    return proba;
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
    protected WeaponTypeBuilder setProba(int proba) {
      return (WeaponTypeBuilder) super.setProba(proba);
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
