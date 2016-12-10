package dd.model.entity.items.treasures.enums;

import commons.model.entity.characteristics.primary.CustomRarity;
import dd.model.entity.items.characteristics.builders.DDOneRarityItemTypeBuilder;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;

/**
 * Created by Germain on 01/11/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EDDMasterworkCommonMeleeWeapon implements DDOneRarityItemType {

  W1(new DDOneRarityItemTypeBuilder()
      .setNames("bâton")
      .setRarity(new CustomRarity(3))
      .setCoinValue("600 po")),
  W2(new DDOneRarityItemTypeBuilder()
      .setNames("cimeterre")
      .setRarity(new CustomRarity(5))
      .setCoinValue("315 po")),
  W3(new DDOneRarityItemTypeBuilder()
      .setNames("dague")
      .setRarity(new CustomRarity(4))
      .setCoinValue("302 po")),
  W4(new DDOneRarityItemTypeBuilder()
      .setNames("épée à deux mains")
      .setRarity(new CustomRarity(10))
      .setCoinValue("350 po")),
  W5(new DDOneRarityItemTypeBuilder()
      .setNames("épée bâtarde")
      .setRarity(new CustomRarity(10))
      .setCoinValue("335 po")),
  W6(new DDOneRarityItemTypeBuilder()
      .setNames("épée courte")
      .setRarity(new CustomRarity(5))
      .setCoinValue("310 po")),
  W7(new DDOneRarityItemTypeBuilder()
      .setNames("épée longue")
      .setRarity(new CustomRarity(13))
      .setCoinValue("315 po")),
  W8(new DDOneRarityItemTypeBuilder()
      .setNames("grande hache")
      .setRarity(new CustomRarity(10))
      .setCoinValue("320 po")),
  W9(new DDOneRarityItemTypeBuilder()
      .setNames("hache de guerre naine")
      .setRarity(new CustomRarity(11))
      .setCoinValue("330 po")),
  W10(new DDOneRarityItemTypeBuilder()
      .setNames("kama")
      .setRarity(new CustomRarity(4))
      .setCoinValue("302 po")),
  W11(new DDOneRarityItemTypeBuilder()
      .setNames("lance")
      .setRarity(new CustomRarity(4))
      .setCoinValue("302 po")),
  W12(new DDOneRarityItemTypeBuilder()
      .setNames("masse d'armes légère")
      .setRarity(new CustomRarity(4))
      .setCoinValue("305 po")),
  W13(new DDOneRarityItemTypeBuilder()
      .setNames("masse d'armes lourde")
      .setRarity(new CustomRarity(5))
      .setCoinValue("312 po")),
  W14(new DDOneRarityItemTypeBuilder()
      .setNames("nunchaku")
      .setRarity(new CustomRarity(4))
      .setCoinValue("302 po")),
  W15(new DDOneRarityItemTypeBuilder()
      .setNames("rapière")
      .setRarity(new CustomRarity(4))
      .setCoinValue("320 po")),
  W16(new DDOneRarityItemTypeBuilder()
      .setNames("siangham")
      .setRarity(new CustomRarity(4))
      .setCoinValue("303 po"));

  private final String name;
  private final String coinValue;
  private final CustomRarity rarity;

  EDDMasterworkCommonMeleeWeapon(DDOneRarityItemTypeBuilder builder) {
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
