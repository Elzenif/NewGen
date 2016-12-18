package dd.model.entity.items.treasures.enums;

import commons.model.dice.Dice;
import commons.model.entity.characteristics.primary.fields.HasRarity;
import dd.model.entity.items.characteristics.EDDItemPowerRarityKey;
import dd.model.entity.items.characteristics.builders.DDMultipleRaritiesItemTypeBuilder;
import dd.model.entity.items.characteristics.fields.DDMultipleRaritiesItemType;

import java.util.Map;

/**
 * Created by Germain on 11/12/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EDDSpecificWeapon implements DDMultipleRaritiesItemType {

  W1(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("Flèche endormante")
      .setWeakRarity(15)
      .setInterRarity(0)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "132 po")),
  W2(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("Carreau hurleur")
      .setWeakRarity(10)
      .setInterRarity(0)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "267 po")),
  W3(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("Dague de maître en argent")
      .setWeakRarity(20)
      .setInterRarity(0)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "322 po")),
  W4(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("Épée longue de maître en fer froid")
      .setWeakRarity(20)
      .setInterRarity(0)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "330 po")),
  W5(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("Javeline de foudre")
      .setWeakRarity(10)
      .setInterRarity(9)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "1500 po")),
  W6(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("Flèche mortelle")
      .setWeakRarity(5)
      .setInterRarity(6)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "2282 po")
      .deadlyArrow()),
  W7(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("Dague en adamantium")
      .setWeakRarity(10)
      .setInterRarity(6)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "3002 po")),
  W8(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("Hache d'armes en adamantium")
      .setWeakRarity(10)
      .setInterRarity(9)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "3010 po")),
  W9(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("Grande flèche mortelle")
      .setWeakRarity(0)
      .setInterRarity(4)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "4057 po")
      .deadlyArrow()),
  W10(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("Brise-arme")
      .setWeakRarity(0)
      .setInterRarity(3)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "4315 po")),
  W11(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("Dague venimeuse")
      .setWeakRarity(0)
      .setInterRarity(6)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "8302 po")),
  W12(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("Trident d'alerte")
      .setWeakRarity(0)
      .setInterRarity(5)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "10115 po")),
  W13(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("Regret du changeant")
      .setWeakRarity(0)
      .setInterRarity(5)
      .setPowerfulRarity(3)
      .setValue(Dice.D1, "12780 po"))
  // TODO continue with other rarities
  ;

  private final String name;
  private final Map<EDDItemPowerRarityKey, HasRarity> map;
  private final String value;
  private final boolean deadlyArrow;

  EDDSpecificWeapon(DDMultipleRaritiesItemTypeBuilder builder) {
    name = builder.getNames().get(0);
    map = builder.getMap();
    value = builder.getCoinValue();
    deadlyArrow = builder.isDeadlyArrow();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Map<EDDItemPowerRarityKey, HasRarity> getRarities() {
    return map;
  }

  @Override
  public String getValue() {
    return value;
  }

  public boolean isDeadlyArrow() {
    return deadlyArrow;
  }
}
