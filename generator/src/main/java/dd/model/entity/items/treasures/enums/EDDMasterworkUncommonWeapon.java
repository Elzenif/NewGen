package dd.model.entity.items.treasures.enums;

import commons.model.entity.characteristics.primary.CustomRarity;
import dd.model.entity.items.characteristics.builders.DDOneRarityItemTypeBuilder;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;

/**
 * Created by Germain on 10/12/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EDDMasterworkUncommonWeapon implements DDOneRarityItemType {

  W1(new DDOneRarityItemTypeBuilder()
      .setNames("Arbalète légère à répétition")
      .setRarity(new CustomRarity(2))
      .setCoinValue("550 po")),
  W2(new DDOneRarityItemTypeBuilder()
      .setNames("Arbalète lourde à répétition")
      .setRarity(new CustomRarity(2))
      .setCoinValue("700 po")),
  W3(new DDOneRarityItemTypeBuilder()
      .setNames("Arbalète de poing")
      .setRarity(new CustomRarity(3))
      .setCoinValue("400 po")),
  W4(new DDOneRarityItemTypeBuilder()
      .setNames("Bolas")
      .setRarity(new CustomRarity(2))
      .setCoinValue("305 po")),
  W5(new DDOneRarityItemTypeBuilder()
      .setNames("Chaîne cloutée")
      .setRarity(new CustomRarity(3))
      .setCoinValue("325 po")),
  W6(new DDOneRarityItemTypeBuilder()
      .setNames("Cimeterre à deux mains")
      .setRarity(new CustomRarity(2))
      .setCoinValue("375 po")),
  W7(new DDOneRarityItemTypeBuilder()
      .setNames("Corsèque")
      .setRarity(new CustomRarity(2))
      .setCoinValue("310 po")),
  W8(new DDOneRarityItemTypeBuilder()
      .setNames("Coutille")
      .setRarity(new CustomRarity(2))
      .setCoinValue("308 po")),
  W9(new DDOneRarityItemTypeBuilder()
      .setNames("Dague coup-de-poing")
      .setRarity(new CustomRarity(2))
      .setCoinValue("302 po")),
  W10(new DDOneRarityItemTypeBuilder()
      .setNames("Double-lame")
      .setRarity(new CustomRarity(3))
      .setCoinValue("700 po")),
  W11(new DDOneRarityItemTypeBuilder()
      .setNames("Épieu")
      .setRarity(new CustomRarity(3))
      .setCoinValue("301 po")),
  W12(new DDOneRarityItemTypeBuilder()
      .setNames("Faux")
      .setRarity(new CustomRarity(2))
      .setCoinValue("318 po")),
  W13(new DDOneRarityItemTypeBuilder()
      .setNames("Filet")
      .setRarity(new CustomRarity(2))
      .setCoinValue("320 po")),
  W14(new DDOneRarityItemTypeBuilder()
      .setNames("Fléau d'armes léger")
      .setRarity(new CustomRarity(3))
      .setCoinValue("308 po")),
  W15(new DDOneRarityItemTypeBuilder()
      .setNames("Fléau d'armes lourd")
      .setRarity(new CustomRarity(3))
      .setCoinValue("315 po")),
  W16(new DDOneRarityItemTypeBuilder()
      .setNames("Fléau double")
      .setRarity(new CustomRarity(3))
      .setCoinValue("690 po")),
  W17(new DDOneRarityItemTypeBuilder()
      .setNames("Fouet")
      .setRarity(new CustomRarity(2))
      .setCoinValue("301 po")),
  W18(new DDOneRarityItemTypeBuilder()
      .setNames("Gantelet")
      .setRarity(new CustomRarity(2))
      .setCoinValue("302 po")),
  W19(new DDOneRarityItemTypeBuilder()
      .setNames("Gantelet clouté")
      .setRarity(new CustomRarity(2))
      .setCoinValue("305 po")),
  W20(new DDOneRarityItemTypeBuilder()
      .setNames("Gourdin")
      .setRarity(new CustomRarity(2))
      .setCoinValue("300 po")),
  W21(new DDOneRarityItemTypeBuilder()
      .setNames("Guisarme")
      .setRarity(new CustomRarity(2))
      .setCoinValue("309 po")),
  W22(new DDOneRarityItemTypeBuilder()
      .setNames("Hache d'armes")
      .setRarity(new CustomRarity(4))
      .setCoinValue("310 po")),
  W23(new DDOneRarityItemTypeBuilder()
      .setNames("Hache double orque")
      .setRarity(new CustomRarity(3))
      .setCoinValue("660 po")),
  W24(new DDOneRarityItemTypeBuilder()
      .setNames("Hachette")
      .setRarity(new CustomRarity(2))
      .setCoinValue("306 po")),
  W25(new DDOneRarityItemTypeBuilder()
      .setNames("Hallebarde")
      .setRarity(new CustomRarity(3))
      .setCoinValue("310 po")),
  W26(new DDOneRarityItemTypeBuilder()
      .setNames("Kukri")
      .setRarity(new CustomRarity(3))
      .setCoinValue("308 po")),
  W27(new DDOneRarityItemTypeBuilder()
      .setNames("Lance d'arçon")
      .setRarity(new CustomRarity(3))
      .setCoinValue("310 po")),
  W28(new DDOneRarityItemTypeBuilder()
      .setNames("Marteau de guerre")
      .setRarity(new CustomRarity(3))
      .setCoinValue("312 po")),
  W29(new DDOneRarityItemTypeBuilder()
      .setNames("Marteau léger")
      .setRarity(new CustomRarity(2))
      .setCoinValue("301 po")),
  W30(new DDOneRarityItemTypeBuilder()
      .setNames("Marteau-piolet gnome")
      .setRarity(new CustomRarity(3))
      .setCoinValue("620 po")),
  W31(new DDOneRarityItemTypeBuilder()
      .setNames("Massue")
      .setRarity(new CustomRarity(2))
      .setCoinValue("305 po")),
  W32(new DDOneRarityItemTypeBuilder()
      .setNames("Matraque")
      .setRarity(new CustomRarity(2))
      .setCoinValue("301 po")),
  W33(new DDOneRarityItemTypeBuilder()
      .setNames("Morgenstern")
      .setRarity(new CustomRarity(3))
      .setCoinValue("308 po")),
  W34(new DDOneRarityItemTypeBuilder()
      .setNames("Pic de guerre léger")
      .setRarity(new CustomRarity(2))
      .setCoinValue("304 po")),
  W35(new DDOneRarityItemTypeBuilder()
      .setNames("Pic de guerre lourd")
      .setRarity(new CustomRarity(2))
      .setCoinValue("308 po")),
  W36(new DDOneRarityItemTypeBuilder()
      .setNames("Pique")
      .setRarity(new CustomRarity(3))
      .setCoinValue("305 po")),
  W37(new DDOneRarityItemTypeBuilder()
      .setNames("Sai")
      .setRarity(new CustomRarity(2))
      .setCoinValue("301 po")),
  W38(new DDOneRarityItemTypeBuilder()
      .setNames("Serpe")
      .setRarity(new CustomRarity(2))
      .setCoinValue("306 po")),
  W39(new DDOneRarityItemTypeBuilder()
      .setNames("Shuriken (50)")
      .setRarity(new CustomRarity(2))
      .setCoinValue("301 po")),
  W40(new DDOneRarityItemTypeBuilder()
      .setNames("Trident")
      .setRarity(new CustomRarity(2))
      .setCoinValue("315 po")),
  W41(new DDOneRarityItemTypeBuilder()
      .setNames("Urgrosh nain")
      .setRarity(new CustomRarity(3))
      .setCoinValue("650 po"));

  private final String name;
  private final String coinValue;
  private final CustomRarity rarity;

  EDDMasterworkUncommonWeapon(DDOneRarityItemTypeBuilder builder) {
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
