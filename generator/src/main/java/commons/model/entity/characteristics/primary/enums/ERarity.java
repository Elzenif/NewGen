package commons.model.entity.characteristics.primary.enums;

import commons.model.entity.characteristics.primary.fields.HasRarity;
import org.jetbrains.annotations.Contract;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Germain on 06/06/2016.
 */
public enum ERarity implements HasRarity {

  COMMON(0, 49),
  UNCOMMON(1, 30),
  RARE(2, 15),
  EPIC(4, 5),
  LEGENDARY(8, 1);

  private final int rarityLevel;
  private final int proba;

  ERarity(int rarityLevel, int proba) {
    this.rarityLevel = rarityLevel;
    this.proba = proba;
  }

  public int getRarityLevel() {
    return rarityLevel;
  }

  public int getProba() {
    return proba;
  }

  @Contract(pure = true)
  @Override
  public ERarity getRarity() {
    return this;
  }

  private static final Map<Integer, ERarity> map = new TreeMap<>(
          Stream.of(ERarity.values()).collect(Collectors.toMap(ERarity::getRarityLevel, Function.identity()))
  );

  public static ERarity getRarity(int rarityLevel) {
    Optional<Integer> optional = map.keySet().stream().filter(e -> e >= rarityLevel).findFirst();
    return optional.isPresent() ? map.get(optional.get()) : LEGENDARY;
  }
}
