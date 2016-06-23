package nbk.model.entity.enums;

import commons.model.entity.utils.ERarity;
import commons.model.entity.utils.ItemType;
import commons.model.entity.utils.ItemTypeBuilder;
import commons.utils.MathUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 23/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkPredefinedWeapon implements ItemType<String> {
  // Picked up
  GOURDIN(new ENbkPredefinedWeaponBuilder()
          .setNames("Bonne branche", "Gourdin", "Pied de chaise")
          .setRarity(ERarity.COMMON)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  // Blades
  COUTEAU_DE_POCHE(new ENbkPredefinedWeaponBuilder()
          .setNames("Couteau de poche du grand-père")
          .setRarity(ERarity.UNCOMMON)
          .setWeaponType(ENbkWeaponType.LAME_COURTE)),
  // Axes
  HACHE_CIMERIENNE(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de combat cimérienne à double affûtage")
          .setRarity(ERarity.RARE)
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)),
  HACHE_MORIAQUE(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de Marave Moriaque")
          .setRarity(ERarity.EPIC)
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)),
  HACHE_ANNIHILATION(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache d'Annihilation de Nyarlapalathep")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS));

  private final List<String> names;
  private final ERarity rarity;
  private final ENbkWeaponType weaponType;

  ENbkPredefinedWeapon(ENbkPredefinedWeaponBuilder builder) {
    names = builder.getNames();
    rarity = builder.getRarity();
    weaponType = builder.getWeaponType();
  }

  @Override
  public String getName() {
    return MathUtils.chooseRandom(names);
  }

  @Override
  public ERarity getRarity() {
    return rarity;
  }

  public ENbkWeaponType getWeaponType() {
    return weaponType;
  }

  private static class ENbkPredefinedWeaponBuilder implements ItemTypeBuilder {

    List<String> names = new LinkedList<>();
    ERarity rarity;
    ENbkWeaponType weaponType;

    ENbkPredefinedWeaponBuilder setNames(String... names) {
      Collections.addAll(this.names, names);
      return this;
    }

    @Override
    public ENbkPredefinedWeaponBuilder setRarity(ERarity rarity) {
      this.rarity = rarity;
      return this;
    }

    ENbkPredefinedWeaponBuilder setWeaponType(ENbkWeaponType weaponType) {
      this.weaponType = weaponType;
      return this;
    }

    @Override
    public List<String> getNames() {
      return names;
    }

    @Override
    public ERarity getRarity() {
      return rarity;
    }

    ENbkWeaponType getWeaponType() {
      return weaponType;
    }
  }
}
