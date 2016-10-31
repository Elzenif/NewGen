package dd.model.entity.items.treasures.enums;

import commons.model.dice.Dice;
import commons.model.entity.characteristics.primary.CustomRarity;
import dd.model.entity.items.characteristics.builders.DDItemTypeBuilder;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;

/**
 * Created by Germain on 31/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EDDSpecialObject implements DDOneRarityItemType {

  SO1(new DDItemTypeBuilder()
      .setNames("feu grégeois")
      .setRarity(new CustomRarity(12))
      .setValue(new Dice(1, 4), " flasques, 20 po chacune")
  ),
  SO2(new DDItemTypeBuilder()
      .setNames("acide")
      .setRarity(new CustomRarity(12))
      .setValue(new Dice(2, 4), " flasques, 10 po chacune")
  ),
  SO3(new DDItemTypeBuilder()
      .setNames("bâtonnets fumigènes")
      .setRarity(new CustomRarity(12))
      .setValue(new Dice(1, 4), ", 20 po chacun")
  ),
  SO4(new DDItemTypeBuilder()
      .setNames("eau bénite")
      .setRarity(new CustomRarity(12))
      .setValue(new Dice(1, 4), " flasques, 25 po chacune")
  ),
  SO5(new DDItemTypeBuilder()
      .setNames("antidote")
      .setRarity(new CustomRarity(14))
      .setValue(new Dice(1, 4), " doses, 50 po chacune")
  ),
  SO6(new DDItemTypeBuilder()
      .setNames("torche éternelle")
      .setRarity(new CustomRarity(12))
      .setValue(new Dice(1, 1), " 50 po ?")
  ),
  SO7(new DDItemTypeBuilder()
      .setNames("sacoches immobilisantes")
      .setRarity(new CustomRarity(14))
      .setValue(new Dice(1, 4), ", 50 po chacune")
  ),
  SO8(new DDItemTypeBuilder()
      .setNames("pierres à tonnerre")
      .setRarity(new CustomRarity(12))
      .setValue(new Dice(1, 4), ", 30 po chacune")
  );

  private final String name;
  private final CustomRarity rarity;
  private final Dice diceValue;
  private final String coinValue;

  EDDSpecialObject(DDItemTypeBuilder builder) {
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
