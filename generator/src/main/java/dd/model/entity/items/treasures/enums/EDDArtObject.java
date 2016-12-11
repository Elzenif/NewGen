package dd.model.entity.items.treasures.enums;

import commons.model.dice.Dice;
import commons.model.entity.characteristics.primary.CustomRarity;
import commons.utils.MathUtils;
import dd.model.entity.items.characteristics.builders.DDOneRarityItemTypeBuilder;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;

import java.util.List;

/**
 * Created by Germain on 29/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EDDArtObject implements DDOneRarityItemType {

  AO1(new DDOneRarityItemTypeBuilder()
      .setNames("aiguisère en argent", "statuette en os", "statuette en ivoire", "bracelet d'or fin")
      .setRarity(new CustomRarity(10))
      .setDiceValue(new Dice(1, 10))
      .setCoinValue("0 po")
  ),
  AO2(new DDOneRarityItemTypeBuilder()
      .setNames("vêtements tissés de fil d'or", "masque de velours noir agrémenté de nombreuses citrines",
          "calice en argent serti de lapis-lazuli")
      .setRarity(new CustomRarity(15))
      .setDiceValue(new Dice(3, 6)).setCoinValue("0 po")
  ),
  AO3(new DDOneRarityItemTypeBuilder()
      .setNames("grande tapisserie en laine", "chope en laiton incrustée de motifs en jade")
      .setRarity(new CustomRarity(15))
      .setDiceValue(new Dice(1, 6))
      .setCoinValue("00 po")
  ),
  AO4(new DDOneRarityItemTypeBuilder()
      .setNames("peigne en argent serti de pierres de lune",
          "épée longue à la lame plaquée d'argent et au pommeau taillé dans le jais")
      .setRarity(new CustomRarity(10))
      .setDiceValue(new Dice(1, 10))
      .setCoinValue("00 po")
  ),
  AO5(new DDOneRarityItemTypeBuilder()
      .setNames("harpe en bois exotique, sculptée et ornée d'ivoire et de zircons", "statuette en or massif (5kg)")
      .setRarity(new CustomRarity(10))
      .setDiceValue(new Dice(2, 6))
      .setCoinValue("00 po")
  ),
  AO6(new DDOneRarityItemTypeBuilder()
      .setNames("peigne en or en forme de dragon avec un oeil de grenat", "bouchon en or et topaze",
          "dague d'apparat en électrum avec un rubis enchâssé dans son pommeau")
      .setRarity(new CustomRarity(10))
      .setDiceValue(new Dice(3, 6))
      .setCoinValue("00 po")
  ),
  AO7(new DDOneRarityItemTypeBuilder()
      .setNames("bandeau sur lequel un faux oeil a été tissé à l'aide de saphirs et de pierres de lune",
          "opale de fau fixée à une chaîne d'or fin", "peintue de maître")
      .setRarity(new CustomRarity(10))
      .setDiceValue(new Dice(4, 6))
      .setCoinValue("00 po")
  ),
  AO8(new DDOneRarityItemTypeBuilder()
      .setNames("manteau de soie et de velours orné de nombreuses pierres de lune",
          "pendentif en saphir fixé à une chaîne en or")
      .setRarity(new CustomRarity(5))
      .setDiceValue(new Dice(5, 6))
      .setCoinValue("00 po")
  ),
  AO9(new DDOneRarityItemTypeBuilder()
      .setNames("gant brodé et garni de nombreuses pierres fines", "bracelet de cheville serti de pierres fines",
          "boîte à musique en or")
      .setRarity(new CustomRarity(5))
      .setDiceValue(new Dice(1, 4))
      .setCoinValue("000 po")
  ),
  AO10(new DDOneRarityItemTypeBuilder()
      .setNames("serre-tête en or serti de quatre aigues-marines", "collier de petites perles roses")
      .setRarity(new CustomRarity(5))
      .setDiceValue(new Dice(1, 6))
      .setCoinValue("000 po")
  ),
  AO11(new DDOneRarityItemTypeBuilder()
      .setNames("couronne en or sertie de joyaux", "anneau en électrum serti d'une pierre précieuse")
      .setRarity(new CustomRarity(4))
      .setDiceValue(new Dice(2, 4))
      .setCoinValue("000 po")
  ),
  AO12(new DDOneRarityItemTypeBuilder()
      .setNames("anneau d'or serti d'un rubis", "coupe en or sertie d'émeraudes")
      .setRarity(new CustomRarity(1))
      .setDiceValue(new Dice(2, 6))
      .setCoinValue("000 po")
  );

  private final List<String> names;
  private final CustomRarity rarity;
  private final Dice diceValue;
  private final String coinValue;

  EDDArtObject(DDOneRarityItemTypeBuilder builder) {
    names = builder.getNames();
    rarity = builder.getRarity();
    diceValue = builder.getDiceValue();
    coinValue = builder.getCoinValue();
  }

  @Override
  public String getName() {
    return MathUtils.chooseRandom(names);
  }

  @Override
  public CustomRarity getRarity() {
    return rarity;
  }

  @Override
  public String getValue() {
    diceValue.roll();
    return diceValue.getScore() + coinValue;
  }
}
