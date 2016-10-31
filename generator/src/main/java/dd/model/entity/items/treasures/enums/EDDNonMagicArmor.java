package dd.model.entity.items.treasures.enums;

import commons.model.dice.Dice;
import commons.model.entity.characteristics.primary.CustomRarity;
import commons.utils.MathUtils;
import dd.model.entity.items.characteristics.builders.DDItemTypeBuilder;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;

/**
 * Created by Germain on 31/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EDDNonMagicArmor implements DDOneRarityItemType {

  A1(new DDItemTypeBuilder()
      .setNames("chemise de mailles")
      .setRarity(new CustomRarity(12))
      .setValue(new Dice(1, 1), "100 po")),
  A2(new DDItemTypeBuilder()
      .setNames("armure de cuir cloutée de maître")
      .setRarity(new CustomRarity(5))
      .setValue(new Dice(1, 1), "175 po")),
  A3(new DDItemTypeBuilder()
      .setNames("cuirasse")
      .setRarity(new CustomRarity(8))
      .setValue(new Dice(1, 1), "200 po")),
  A4(new DDItemTypeBuilder()
      .setNames("crevice")
      .setRarity(new CustomRarity(8))
      .setValue(new Dice(1, 1), "250 po")),
  A5(new DDItemTypeBuilder()
      .setNames("armure à plaques")
      .setRarity(new CustomRarity(20))
      .setValue(new Dice(1, 1), "600 po")),
  A6(new DDItemTypeBuilder()
      .setNames("harnois")
      .setRarity(new CustomRarity(25))
      .setValue(new Dice(1, 1), "1500 po")),
  A7(new DDItemTypeBuilder()
      .setNames("rondache d'ébénite")
      .setRarity(new CustomRarity(5))
      .setValue(new Dice(1, 1), "203 po")),
  A8(new DDItemTypeBuilder()
      .setNames("écu d'ébénite")
      .setRarity(new CustomRarity(5))
      .setValue(new Dice(1, 1), "257 po")),
  A9(new DDItemTypeBuilder()
      .setNames("targe")
      .setRarity(new CustomRarity(2))
      .setValue(new Dice(1, 1), "165 po")),
  A10(new DDItemTypeBuilder()
      .setNames("rondache en bois")
      .setRarity(new CustomRarity(2))
      .setValue(new Dice(1, 1), "153 po")),
  A11(new DDItemTypeBuilder()
      .setNames("rondache en acier")
      .setRarity(new CustomRarity(2))
      .setValue(new Dice(1, 1), "159 po")),
  A12(new DDItemTypeBuilder()
      .setNames("écu en bois")
      .setRarity(new CustomRarity(2))
      .setValue(new Dice(1, 1), "157 po")),
  A13(new DDItemTypeBuilder()
      .setNames("écu en acier")
      .setRarity(new CustomRarity(2))
      .setValue(new Dice(1, 1), "170 po"));

  private final String name;
  private final String coinValue;
  private final CustomRarity rarity;

  EDDNonMagicArmor(DDItemTypeBuilder builder) {
    name = builder.getNames().get(0);
    rarity = builder.getRarity();
    coinValue = builder.getCoinValue();
  }


  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getValue() {
    return "taille " + (MathUtils.random(1, 100) <= 10 ? "P" : "M") + ", " + coinValue;
  }

  @Override
  public CustomRarity getRarity() {
    return rarity;
  }
}
