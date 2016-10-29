package dd.model.entity.items.treasure.enums;

import commons.model.dice.Dice;
import commons.model.entity.characteristics.primary.CustomRarity;
import commons.utils.MathUtils;
import dd.model.entity.items.characteristics.builders.DDItemTypeBuilder;
import dd.model.entity.items.characteristics.fields.DDItemType;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 29/10/2016.
 */
@SuppressWarnings({"HardCodedStringLiteral", "SpellCheckingInspection"})
public enum EDDArtObject implements DDItemType {

  AO1(new ArtObjectBuilder()
      .setNames("aiguisère en argent", "statuette en os", "statuette en ivoire", "bracelet d'or fin")
      .setRarity(new CustomRarity(10))
      .setValue(new Dice(1, 10), "0 po")
  ),
  AO2(new ArtObjectBuilder()
      .setNames("vêtements tissés de fil d'or", "masque de velours noir agrémenté de nombreuses citrines",
          "calice en argent serti de lapis-lazuli")
      .setRarity(new CustomRarity(15))
      .setValue(new Dice(3, 6), "0 po")
  ),
  AO3(new ArtObjectBuilder()
      .setNames("grande tapisserie en laine", "chope en laiton incrustée de motifs en jade")
      .setRarity(new CustomRarity(15))
      .setValue(new Dice(1, 6), "00 po")
  ),
  AO4(new ArtObjectBuilder()
      .setNames("peigne en argent serti de pierres de lune",
          "épée longue à la lame plaquée d'argent et au pommeau taillé dans le jais")
      .setRarity(new CustomRarity(10))
      .setValue(new Dice(1, 10), "00 po")
  ),
  AO5(new ArtObjectBuilder()
      .setNames("harpe en bois exotique, sculptée et ornée d'ivoire et de zircons", "statuette en or massif (5kg)")
      .setRarity(new CustomRarity(10))
      .setValue(new Dice(2, 6), "00 po")
  ),
  AO6(new ArtObjectBuilder()
      .setNames("peigne en or en forme de dragon avec un oeil de grenat", "bouchon en or et topaze",
          "dague d'apparat en électrum avec un rubis enchâssé dans son pommeau")
      .setRarity(new CustomRarity(10))
      .setValue(new Dice(3, 6), "00 po")
  ),
  AO7(new ArtObjectBuilder()
      .setNames("bandeau sur lequel un faux oeil a été tissé à l'aide de saphirs et de pierres de lune",
          "opale de fau fixée à une chaîne d'or fin", "peintue de maître")
      .setRarity(new CustomRarity(10))
      .setValue(new Dice(4, 6), "00 po")
  ),
  AO8(new ArtObjectBuilder()
      .setNames("manteau de soie et de velours orné de nombreuses pierres de lune",
          "pendentif en saphir fixé à une chaîne en or")
      .setRarity(new CustomRarity(5))
      .setValue(new Dice(5, 6), "00 po")
  ),
  AO9(new ArtObjectBuilder()
      .setNames("gant brodé et garni de nombreuses pierres fines", "bracelet de cheville serti de pierres fines",
          "boîte à musique en or")
      .setRarity(new CustomRarity(5))
      .setValue(new Dice(1, 4), "000 po")
  ),
  AO10(new ArtObjectBuilder()
      .setNames("serre-tête en or serti de quatre aigues-marines", "collier de petites perles roses")
      .setRarity(new CustomRarity(5))
      .setValue(new Dice(1, 6), "000 po")
  ),
  AO11(new ArtObjectBuilder()
      .setNames("couronne en or sertie de joyaux", "anneau en électrum serti d'une pierre précieuse")
      .setRarity(new CustomRarity(4))
      .setValue(new Dice(2, 4), "000 po")
  ),
  AO12(new ArtObjectBuilder()
      .setNames("anneau d'or serti d'un rubis", "coupe en or sertie d'émeraudes")
      .setRarity(new CustomRarity(1))
      .setValue(new Dice(2, 6), "000 po")
  );

  private final List<String> names;
  private final CustomRarity rarity;
  private final Dice diceValue;
  private final String coinValue;

  EDDArtObject(ArtObjectBuilder builder) {
    names = builder.names;
    rarity = builder.rarity;
    diceValue = builder.diceValue;
    coinValue = builder.coinValue;
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

  private static class ArtObjectBuilder implements DDItemTypeBuilder<ArtObjectBuilder> {

    private final List<String> names = new LinkedList<>();
    private CustomRarity rarity;
    private Dice diceValue;
    private String coinValue;

    @Override
    public ArtObjectBuilder setNames(String first, String... others) {
      names.add(first);
      Collections.addAll(names, others);
      return this;
    }

    @Override
    public ArtObjectBuilder setRarity(CustomRarity customRarity) {
      this.rarity = customRarity;
      return this;
    }

    @Override
    public ArtObjectBuilder setValue(Dice diceValue, String coinValue) {
      this.diceValue = diceValue;
      this.coinValue = coinValue;
      return this;
    }
  }
}
