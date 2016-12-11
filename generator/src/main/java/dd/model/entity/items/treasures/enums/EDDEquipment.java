package dd.model.entity.items.treasures.enums;

import commons.model.entity.characteristics.primary.CustomRarity;
import dd.model.entity.items.characteristics.builders.DDOneRarityItemTypeBuilder;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;

/**
 * Created by Germain on 11/12/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EDDEquipment implements DDOneRarityItemType {

  W1(new DDOneRarityItemTypeBuilder()
      .setNames("Sac à dos vide")
      .setRarity(new CustomRarity(3))
      .setCoinValue("2 po")),
  W2(new DDOneRarityItemTypeBuilder()
      .setNames("Pied-de-biche")
      .setRarity(new CustomRarity(3))
      .setCoinValue("2 po")),
  W3(new DDOneRarityItemTypeBuilder()
      .setNames("Lanterne souple")
      .setRarity(new CustomRarity(5))
      .setCoinValue("12 po")),
  W4(new DDOneRarityItemTypeBuilder()
      .setNames("Cadenas simple")
      .setRarity(new CustomRarity(4))
      .setCoinValue("20 po")),
  W5(new DDOneRarityItemTypeBuilder()
      .setNames("Cadenas moyen")
      .setRarity(new CustomRarity(5))
      .setCoinValue("40 po")),
  W6(new DDOneRarityItemTypeBuilder()
      .setNames("Bon cadenas")
      .setRarity(new CustomRarity(7))
      .setCoinValue("80 po")),
  W7(new DDOneRarityItemTypeBuilder()
      .setNames("Excellent cadenas")
      .setRarity(new CustomRarity(7))
      .setCoinValue("150 po")),
  W8(new DDOneRarityItemTypeBuilder()
      .setNames("Menottes de qualité supérieure")
      .setRarity(new CustomRarity(5))
      .setCoinValue("50 po")),
  W9(new DDOneRarityItemTypeBuilder()
      .setNames("Petit miroir en acier")
      .setRarity(new CustomRarity(3))
      .setCoinValue("10 po")),
  W10(new DDOneRarityItemTypeBuilder()
      .setNames("Corde en soie, 15m")
      .setRarity(new CustomRarity(3))
      .setCoinValue("10 po")),
  W11(new DDOneRarityItemTypeBuilder()
      .setNames("Longue-vue")
      .setRarity(new CustomRarity(7))
      .setCoinValue("1000 po")),
  W12(new DDOneRarityItemTypeBuilder()
      .setNames("Outils de maître artisan")
      .setRarity(new CustomRarity(5))
      .setCoinValue("55 po")),
  W13(new DDOneRarityItemTypeBuilder()
      .setNames("Matériel d'escalade")
      .setRarity(new CustomRarity(5))
      .setCoinValue("80 po")),
  W14(new DDOneRarityItemTypeBuilder()
      .setNames("Trousse de déguisement")
      .setRarity(new CustomRarity(5))
      .setCoinValue("50 po")),
  W15(new DDOneRarityItemTypeBuilder()
      .setNames("Trousse de premiers secours")
      .setRarity(new CustomRarity(5))
      .setCoinValue("50 po")),
  W16(new DDOneRarityItemTypeBuilder()
      .setNames("Symbole sacré en argent")
      .setRarity(new CustomRarity(4))
      .setCoinValue("25 po")),
  W17(new DDOneRarityItemTypeBuilder()
      .setNames("Sablier")
      .setRarity(new CustomRarity(4))
      .setCoinValue("25 po")),
  W18(new DDOneRarityItemTypeBuilder()
      .setNames("Loupe")
      .setRarity(new CustomRarity(7))
      .setCoinValue("100 po")),
  W19(new DDOneRarityItemTypeBuilder()
      .setNames("Instrument de musique de maître")
      .setRarity(new CustomRarity(7))
      .setCoinValue("100 po")),
  W20(new DDOneRarityItemTypeBuilder()
      .setNames("Outils de cambrioleur de qualité supérieure")
      .setRarity(new CustomRarity(5))
      .setCoinValue("50 po"));

  private final String name;
  private final String coinValue;
  private final CustomRarity rarity;

  EDDEquipment(DDOneRarityItemTypeBuilder builder) {
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
