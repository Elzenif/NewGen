package dd.model.entity.items.treasures.enums;

import commons.model.dice.Dice;
import commons.model.entity.characteristics.primary.fields.HasRarity;
import dd.model.entity.items.characteristics.EDDItemPowerRarityKey;
import dd.model.entity.items.characteristics.builders.DDMultipleRaritiesItemTypeBuilder;
import dd.model.entity.items.characteristics.fields.DDMultipleRaritiesItemType;
import org.jetbrains.annotations.Contract;

import java.util.Map;

/**
 * Created by Germain on 31/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EDDRing implements DDMultipleRaritiesItemType {

  R1(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("protection +1")
      .setWeakRarity(18)
      .setInterRarity(0)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "2000 po")),
  R2(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("feuille morte")
      .setWeakRarity(10)
      .setInterRarity(0)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "2200 po")),
  R3(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("escalade")
      .setWeakRarity(8)
      .setInterRarity(0)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "2500 po")),
  R4(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("nage")
      .setWeakRarity(8)
      .setInterRarity(0)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "2500 po")),
  R5(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("saut")
      .setWeakRarity(8)
      .setInterRarity(0)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "2500 po")),
  R6(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("subsistance")
      .setWeakRarity(8)
      .setInterRarity(0)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "2500 po")),
  R7(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("contresort")
      .setWeakRarity(10)
      .setInterRarity(5)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "4000 po")),
  R8(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("barrière mentale")
      .setWeakRarity(5)
      .setInterRarity(3)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "8000 po")),
  R9(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("protection +2")
      .setWeakRarity(5)
      .setInterRarity(10)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "8000 po")),
  R10(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("bouclier de force")
      .setWeakRarity(5)
      .setInterRarity(5)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "8500 po")),
  R11(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("bélier")
      .setWeakRarity(5)
      .setInterRarity(5)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "8600 po")),

  R15(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("amitié avec les animaux")
      .setWeakRarity(3)
      .setInterRarity(5)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "10800 po")),
  R16(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("résistance aux énergies destructives, mineur")
      .setWeakRarity(3)
      .setInterRarity(5)
      .setPowerfulRarity(2)
      .setValue(Dice.D1, "12000 po")),
  R17(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("caméléon")
      .setWeakRarity(2)
      .setInterRarity(4)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "12700 po")),
  R18(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("marche sur l'onde")
      .setWeakRarity(2)
      .setInterRarity(5)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "15000 po")),
  // TODO continue other rarities
  ;

  private final String name;
  private final Map<EDDItemPowerRarityKey, HasRarity> map;
  private final String value;

  EDDRing(DDMultipleRaritiesItemTypeBuilder builder) {
    name = builder.getNames().get(0);
    map = builder.getMap();
    value = builder.getCoinValue();
  }

  @Contract(pure = true)
  @Override
  public String getName() {
    return "anneau " + name;
  }

  @Override
  public Map<EDDItemPowerRarityKey, HasRarity> getRarities() {
    return map;
  }

  @Override
  public String getValue() {
    return value;
  }
}
