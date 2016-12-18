package dd.model.entity.items.treasures.enums;

import commons.model.entity.characteristics.primary.CustomRarity;
import dd.model.entity.items.characteristics.builders.DDOneRarityItemTypeBuilder;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Germain on 17/12/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EDDDeadlyArrowTarget implements DDOneRarityItemType {

  W1(new DDOneRarityItemTypeBuilder()
      .setNames("Aberrations")
      .setRarity(new CustomRarity(5))),
  W2(new DDOneRarityItemTypeBuilder()
      .setNames("Animaux")
      .setRarity(new CustomRarity(4))),
  W3(new DDOneRarityItemTypeBuilder()
      .setNames("Créatures artificielles")
      .setRarity(new CustomRarity(7))),
  W4(new DDOneRarityItemTypeBuilder()
      .setNames("Créatures magiques")
      .setRarity(new CustomRarity(5))),
  W5(new DDOneRarityItemTypeBuilder()
      .setNames("Dragons")
      .setRarity(new CustomRarity(6))),
  W6(new DDOneRarityItemTypeBuilder()
      .setNames("Élémentaires")
      .setRarity(new CustomRarity(5))),
  W7(new DDOneRarityItemTypeBuilder()
      .setNames("Extérieurs bons")
      .setRarity(new CustomRarity(3))),
  W8(new DDOneRarityItemTypeBuilder()
      .setNames("Extérieurs chaotiques")
      .setRarity(new CustomRarity(3))),
  W9(new DDOneRarityItemTypeBuilder()
      .setNames("Extérieurs de l'Air")
      .setRarity(new CustomRarity(1))),
  W10(new DDOneRarityItemTypeBuilder()
      .setNames("Extérieurs de l'Eau")
      .setRarity(new CustomRarity(1))),
  W11(new DDOneRarityItemTypeBuilder()
      .setNames("Extérieurs de la Terre")
      .setRarity(new CustomRarity(2))),
  W12(new DDOneRarityItemTypeBuilder()
      .setNames("Extérieurs du Feu")
      .setRarity(new CustomRarity(1))),
  W13(new DDOneRarityItemTypeBuilder()
      .setNames("Extérieurs loyaux")
      .setRarity(new CustomRarity(3))),
  W14(new DDOneRarityItemTypeBuilder()
      .setNames("Extérieurs mauvais")
      .setRarity(new CustomRarity(3))),
  W15(new DDOneRarityItemTypeBuilder()
      .setNames("Fées")
      .setRarity(new CustomRarity(5))),
  W16(new DDOneRarityItemTypeBuilder()
      .setNames("Géants")
      .setRarity(new CustomRarity(7))),
  W17(new DDOneRarityItemTypeBuilder()
      .setNames("Humanoïdes aquatiques")
      .setRarity(new CustomRarity(1))),
  W18(new DDOneRarityItemTypeBuilder()
      .setNames("Humanoïdes elfes")
      .setRarity(new CustomRarity(2))),
  W19(new DDOneRarityItemTypeBuilder()
      .setNames("Humanoïdes gnolls")
      .setRarity(new CustomRarity(1))),
  W20(new DDOneRarityItemTypeBuilder()
      .setNames("Humanoïdes gnomes")
      .setRarity(new CustomRarity(1))),
  W21(new DDOneRarityItemTypeBuilder()
      .setNames("Humanoïdes goblinoïdes")
      .setRarity(new CustomRarity(3))),
  W22(new DDOneRarityItemTypeBuilder()
      .setNames("Humanoïdes halfelins")
      .setRarity(new CustomRarity(1))),
  W23(new DDOneRarityItemTypeBuilder()
      .setNames("Humanoïdes humains")
      .setRarity(new CustomRarity(4))),
  W24(new DDOneRarityItemTypeBuilder()
      .setNames("Humanoïdes nains")
      .setRarity(new CustomRarity(2))),
  W25(new DDOneRarityItemTypeBuilder()
      .setNames("Humanoïdes orques")
      .setRarity(new CustomRarity(3))),
  W26(new DDOneRarityItemTypeBuilder()
      .setNames("Humanoïdes reptiliens")
      .setRarity(new CustomRarity(3))),
  W27(new DDOneRarityItemTypeBuilder()
      .setNames("Humanoïdes monstrueux")
      .setRarity(new CustomRarity(5))),
  W28(new DDOneRarityItemTypeBuilder()
      .setNames("Morts-vivants")
      .setRarity(new CustomRarity(8))),
  W29(new DDOneRarityItemTypeBuilder()
      .setNames("Plantes")
      .setRarity(new CustomRarity(2))),
  W30(new DDOneRarityItemTypeBuilder()
      .setNames("Vases")
      .setRarity(new CustomRarity(2))),
  W31(new DDOneRarityItemTypeBuilder()
      .setNames("Vermine")
      .setRarity(new CustomRarity(2)));

  private final String name;
  private final CustomRarity rarity;

  EDDDeadlyArrowTarget(DDOneRarityItemTypeBuilder builder) {
    name = builder.getNames().get(0);
    rarity = builder.getRarity();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public CustomRarity getRarity() {
    return rarity;
  }

  @NotNull
  @Contract(pure = true)
  @Override
  public String getValue() {
    return "";
  }
}
