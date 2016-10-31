package dd.model.entity.items.characteristics.builders;

import commons.model.dice.Dice;
import commons.model.entity.characteristics.primary.CustomRarity;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 29/10/2016.
 */
public class DDItemTypeBuilder {

  private final List<String> names = new LinkedList<>();
  private CustomRarity rarity;
  private Dice diceValue;
  private String coinValue;

  public DDItemTypeBuilder setNames(String first, String... others) {
    names.add(first);
    Collections.addAll(names, others);
    return this;
  }

  public DDItemTypeBuilder setValue(Dice diceValue, String coinValue) {
    this.diceValue = diceValue;
    this.coinValue = coinValue;
    return this;
  }

  public List<String> getNames() {
    return names;
  }

  public CustomRarity getRarity() {
    return rarity;
  }

  public DDItemTypeBuilder setRarity(CustomRarity customRarity) {
    this.rarity = customRarity;
    return this;
  }

  public Dice getDiceValue() {
    return diceValue;
  }

  public String getCoinValue() {
    return coinValue;
  }
}
