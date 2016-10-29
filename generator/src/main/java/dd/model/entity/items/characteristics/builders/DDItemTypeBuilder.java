package dd.model.entity.items.characteristics.builders;

import commons.model.dice.Dice;
import commons.model.entity.characteristics.primary.CustomRarity;

/**
 * Created by Germain on 29/10/2016.
 */
public interface DDItemTypeBuilder<B> {

  B setNames(String first, String... others);

  B setRarity(CustomRarity customRarity);

  B setValue(Dice diceValue, String coinValue);
}
