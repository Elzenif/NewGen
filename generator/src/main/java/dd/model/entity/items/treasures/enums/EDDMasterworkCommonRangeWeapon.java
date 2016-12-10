package dd.model.entity.items.treasures.enums;

import commons.model.entity.characteristics.primary.CustomRarity;
import dd.model.entity.items.characteristics.builders.DDOneRarityItemTypeBuilder;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;

/**
 * Created by Germain on 10/12/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EDDMasterworkCommonRangeWeapon implements DDOneRarityItemType {

  W1(new DDOneRarityItemTypeBuilder()
      .setNames("Arbalète légère")
      .setRarity(new CustomRarity(10))
      .setCoinValue("335 po")),
  W2(new DDOneRarityItemTypeBuilder()
      .setNames("Arbalète lourde")
      .setRarity(new CustomRarity(10))
      .setCoinValue("350 po")),
  W3(new DDOneRarityItemTypeBuilder()
      .setNames("Arc court")
      .setRarity(new CustomRarity(5))
      .setCoinValue("330 po")),
  W4(new DDOneRarityItemTypeBuilder()
      .setNames("Arc court composite (limite de bonus de For de +0)")
      .setRarity(new CustomRarity(5))
      .setCoinValue("375 po")),
  W5(new DDOneRarityItemTypeBuilder()
      .setNames("Arc court composite (limite de bonus de For de +1)")
      .setRarity(new CustomRarity(5))
      .setCoinValue("450 po")),
  W6(new DDOneRarityItemTypeBuilder()
      .setNames("Arc court composite (limite de bonus de For de +2)")
      .setRarity(new CustomRarity(5))
      .setCoinValue("525 po")),
  W7(new DDOneRarityItemTypeBuilder()
      .setNames("Arc long")
      .setRarity(new CustomRarity(10))
      .setCoinValue("375 po")),
  W8(new DDOneRarityItemTypeBuilder()
      .setNames("Arc long composite (limite de bonus de For de +0)")
      .setRarity(new CustomRarity(5))
      .setCoinValue("400 po")),
  W9(new DDOneRarityItemTypeBuilder()
      .setNames("Arc long composite (limite de bonus de For de +1)")
      .setRarity(new CustomRarity(5))
      .setCoinValue("500 po")),
  W10(new DDOneRarityItemTypeBuilder()
      .setNames("Arc long composite (limite de bonus de For de +2)")
      .setRarity(new CustomRarity(5))
      .setCoinValue("600 po")),
  W11(new DDOneRarityItemTypeBuilder()
      .setNames("Arc long composite (limite de bonus de For de +3)")
      .setRarity(new CustomRarity(5))
      .setCoinValue("700 po")),
  W12(new DDOneRarityItemTypeBuilder()
      .setNames("Arc long composite (limite de bonus de For de +4)")
      .setRarity(new CustomRarity(5))
      .setCoinValue("800 po")),
  W13(new DDOneRarityItemTypeBuilder()
      .setNames("Dard")
      .setRarity(new CustomRarity(4))
      .setCoinValue("300 po et 5 pa")),
  W14(new DDOneRarityItemTypeBuilder()
      .setNames("Fronde")
      .setRarity(new CustomRarity(4))
      .setCoinValue("300 po")),
  W15(new DDOneRarityItemTypeBuilder()
      .setNames("Hache de lancer")
      .setRarity(new CustomRarity(5))
      .setCoinValue("308 po")),
  W16(new DDOneRarityItemTypeBuilder()
      .setNames("Javeline")
      .setRarity(new CustomRarity(2))
      .setCoinValue("301 po")),
  W17(new DDOneRarityItemTypeBuilder()
      .setNames("Billes (50)")
      .setRarity(new CustomRarity(2))
      .setCoinValue("350 po")),
  W18(new DDOneRarityItemTypeBuilder()
      .setNames("Carreaux (50)")
      .setRarity(new CustomRarity(3))
      .setCoinValue("350 po")),
  W19(new DDOneRarityItemTypeBuilder()
      .setNames("Flèches (50)")
      .setRarity(new CustomRarity(5))
      .setCoinValue("350 po"));


  private final String name;
  private final String coinValue;
  private final CustomRarity rarity;

  EDDMasterworkCommonRangeWeapon(DDOneRarityItemTypeBuilder builder) {
    name = builder.getNames().get(0);
    coinValue = builder.getCoinValue();
    rarity = builder.getRarity();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getValue() {
    return coinValue;
  }

  @Override
  public CustomRarity getRarity() {
    return rarity;
  }
}
