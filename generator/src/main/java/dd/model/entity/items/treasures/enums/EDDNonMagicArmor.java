package dd.model.entity.items.treasures.enums;

import commons.model.entity.characteristics.primary.CustomRarity;
import commons.utils.MathUtils;
import dd.model.entity.items.characteristics.builders.DDOneRarityItemTypeBuilder;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;

/**
 * Created by Germain on 31/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EDDNonMagicArmor implements DDOneRarityItemType {

  A1(new DDOneRarityItemTypeBuilder()
      .setNames("chemise de mailles")
      .setRarity(new CustomRarity(12))
      .setCoinValue("100 po")),
  A2(new DDOneRarityItemTypeBuilder()
      .setNames("armure de cuir cloutée de maître")
      .setRarity(new CustomRarity(5))
      .setCoinValue("175 po")),
  A3(new DDOneRarityItemTypeBuilder()
      .setNames("cuirasse")
      .setRarity(new CustomRarity(8))
      .setCoinValue("200 po")),
  A4(new DDOneRarityItemTypeBuilder()
      .setNames("crevice")
      .setRarity(new CustomRarity(8))
      .setCoinValue("250 po")),
  A5(new DDOneRarityItemTypeBuilder()
      .setNames("armure à plaques")
      .setRarity(new CustomRarity(20))
      .setCoinValue("600 po")),
  A6(new DDOneRarityItemTypeBuilder()
      .setNames("harnois")
      .setRarity(new CustomRarity(25))
      .setCoinValue("1500 po")),
  A7(new DDOneRarityItemTypeBuilder()
      .setNames("rondache d'ébénite")
      .setRarity(new CustomRarity(5))
      .setCoinValue("203 po")),
  A8(new DDOneRarityItemTypeBuilder()
      .setNames("écu d'ébénite")
      .setRarity(new CustomRarity(5))
      .setCoinValue("257 po")),
  A9(new DDOneRarityItemTypeBuilder()
      .setNames("targe")
      .setRarity(new CustomRarity(2))
      .setCoinValue("165 po")),
  A10(new DDOneRarityItemTypeBuilder()
      .setNames("rondache en bois")
      .setRarity(new CustomRarity(2))
      .setCoinValue("153 po")),
  A11(new DDOneRarityItemTypeBuilder()
      .setNames("rondache en acier")
      .setRarity(new CustomRarity(2))
      .setCoinValue("159 po")),
  A12(new DDOneRarityItemTypeBuilder()
      .setNames("écu en bois")
      .setRarity(new CustomRarity(2))
      .setCoinValue("157 po")),
  A13(new DDOneRarityItemTypeBuilder()
      .setNames("écu en acier")
      .setRarity(new CustomRarity(2))
      .setCoinValue("170 po"));

  private final String name;
  private final String coinValue;
  private final CustomRarity rarity;

  EDDNonMagicArmor(DDOneRarityItemTypeBuilder builder) {
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
