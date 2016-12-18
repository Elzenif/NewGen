package dd.model.entity.items.treasures.enums;

import commons.model.dice.Dice;
import commons.model.entity.characteristics.primary.CustomRarity;
import dd.model.entity.items.characteristics.builders.DDOneRarityItemTypeBuilder;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;

/**
 * Created by Germain on 31/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EDDSpecialObject implements DDOneRarityItemType {

  SO1(new DDOneRarityItemTypeBuilder()
      .setNames("feu grégeois")
      .setRarity(new CustomRarity(12))
      .setDiceValue(new Dice(1, 4))
      .setCoinValue(" flasques, 20 po chacune")
  ),
  SO2(new DDOneRarityItemTypeBuilder()
      .setNames("acide")
      .setRarity(new CustomRarity(12))
      .setDiceValue(new Dice(2, 4))
      .setCoinValue(" flasques, 10 po chacune")
  ),
  SO3(new DDOneRarityItemTypeBuilder()
      .setNames("bâtonnets fumigènes")
      .setRarity(new CustomRarity(12))
      .setDiceValue(new Dice(1, 4))
      .setCoinValue(", 20 po chacun")
  ),
  SO4(new DDOneRarityItemTypeBuilder()
      .setNames("eau bénite")
      .setRarity(new CustomRarity(12))
      .setDiceValue(new Dice(1, 4))
      .setCoinValue(" flasques, 25 po chacune")
  ),
  SO5(new DDOneRarityItemTypeBuilder()
      .setNames("antidote")
      .setRarity(new CustomRarity(14))
      .setDiceValue(new Dice(1, 4))
      .setCoinValue(" doses, 50 po chacune")
  ),
  SO6(new DDOneRarityItemTypeBuilder()
      .setNames("torche éternelle")
      .setRarity(new CustomRarity(12))
      .setDiceValue(Dice.D1)
      .setCoinValue(" 50 po ?")
  ),
  SO7(new DDOneRarityItemTypeBuilder()
      .setNames("sacoches immobilisantes")
      .setRarity(new CustomRarity(14))
      .setDiceValue(new Dice(1, 4))
      .setCoinValue(", 50 po chacune")
  ),
  SO8(new DDOneRarityItemTypeBuilder()
      .setNames("pierres à tonnerre")
      .setRarity(new CustomRarity(12))
      .setDiceValue(new Dice(1, 4))
      .setCoinValue(", 30 po chacune")
  );

  private final String name;
  private final CustomRarity rarity;
  private final Dice diceValue;
  private final String coinValue;

  EDDSpecialObject(DDOneRarityItemTypeBuilder builder) {
    name = builder.getNames().get(0);
    rarity = builder.getRarity();
    diceValue = builder.getDiceValue();
    coinValue = builder.getCoinValue();
  }

  @Override
  public String getName() {
    return name;
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
