package dd.model.entity.items.characteristics.builders;

import commons.model.dice.Dice;
import commons.model.entity.characteristics.primary.CustomRarity;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 29/10/2016.
 */
public class DDOneRarityItemTypeBuilder {

  private final List<String> names = new LinkedList<>();
  private CustomRarity rarity;
  private Dice diceValue;
  private String coinValue;

  public DDOneRarityItemTypeBuilder setNames(String first, String... others) {
    names.add(first);
    Collections.addAll(names, others);
    return this;
  }

  public List<String> getNames() {
    return names;
  }

  public CustomRarity getRarity() {
    return rarity;
  }

  public DDOneRarityItemTypeBuilder setRarity(CustomRarity customRarity) {
    this.rarity = customRarity;
    return this;
  }

  public Dice getDiceValue() {
    return diceValue;
  }

  public DDOneRarityItemTypeBuilder setDiceValue(Dice diceValue) {
    this.diceValue = diceValue;
    return this;
  }

  public String getCoinValue() {
    return coinValue;
  }

  public DDOneRarityItemTypeBuilder setCoinValue(String coinValue) {
    this.coinValue = coinValue;
    return this;
  }
}
