package dd.model.entity.items.characteristics.builders;

import commons.model.dice.Dice;
import commons.model.entity.characteristics.primary.CustomRarity;
import commons.model.entity.characteristics.primary.fields.HasRarity;
import dd.model.entity.items.characteristics.EDDItemPowerRarityKey;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Germain on 31/10/2016.
 */
public class DDMultipleRaritiesItemTypeBuilder {

  private final List<String> names = new LinkedList<>();
  private final Map<EDDItemPowerRarityKey, HasRarity> map = new HashMap<>();
  private Dice diceValue;
  private String coinValue;

  public DDMultipleRaritiesItemTypeBuilder setNames(String first, String... others) {
    names.add(first);
    Collections.addAll(names, others);
    return this;
  }

  public DDMultipleRaritiesItemTypeBuilder setValue(Dice diceValue, String coinValue) {
    this.diceValue = diceValue;
    this.coinValue = coinValue;
    return this;
  }

  public DDMultipleRaritiesItemTypeBuilder setWeakRarity(int proba) {
    map.put(EDDItemPowerRarityKey.WEAK, new CustomRarity(proba));
    return this;
  }

  public DDMultipleRaritiesItemTypeBuilder setInterRarity(int proba) {
    map.put(EDDItemPowerRarityKey.INTERMEDIATE, new CustomRarity(proba));
    return this;
  }

  public DDMultipleRaritiesItemTypeBuilder setPowerfulRarity(int proba) {
    map.put(EDDItemPowerRarityKey.POWERFUL, new CustomRarity(proba));
    return this;
  }

  public List<String> getNames() {
    return names;
  }

  public Map<EDDItemPowerRarityKey, HasRarity> getMap() {
    return map;
  }

  public Dice getDiceValue() {
    return diceValue;
  }

  public String getCoinValue() {
    return coinValue;
  }

}
