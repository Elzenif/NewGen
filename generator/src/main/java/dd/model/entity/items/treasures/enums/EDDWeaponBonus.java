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
public enum EDDWeaponBonus implements DDMultipleRaritiesItemType {

  W1(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("+1")
      .setWeakRarity(70)
      .setInterRarity(10)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "2000 po")),
  W2(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("+2")
      .setWeakRarity(15)
      .setInterRarity(29)
      .setPowerfulRarity(0)
      .setValue(Dice.D1, "8000 po")),
  W3(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("+3")
      .setWeakRarity(0)
      .setInterRarity(29)
      .setPowerfulRarity(20)
      .setValue(Dice.D1, "18000 po")),
  W4(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("+4")
      .setWeakRarity(0)
      .setInterRarity(4)
      .setPowerfulRarity(18)
      .setValue(Dice.D1, "32000 po")),
  W5(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("+5")
      .setWeakRarity(0)
      .setInterRarity(0)
      .setPowerfulRarity(11)
      .setValue(Dice.D1, "50000 po")),
  SPECIFIC_WEAPON(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("")
      .setWeakRarity(5)
      .setInterRarity(5)
      .setPowerfulRarity(13)
      .setValue(Dice.D1, "")),
  SPECIAL_PROPERTY(new DDMultipleRaritiesItemTypeBuilder()
      .setNames("")
      .setWeakRarity(10)
      .setInterRarity(32)
      .setPowerfulRarity(37)
      .setValue(Dice.D1, ""));

  private final String name;
  private final Map<EDDItemPowerRarityKey, HasRarity> map;
  private final String value;

  EDDWeaponBonus(DDMultipleRaritiesItemTypeBuilder builder) {
    name = builder.getNames().get(0);
    map = builder.getMap();
    value = builder.getCoinValue();
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
}
