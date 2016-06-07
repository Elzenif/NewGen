package mvc.model.entity.utils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Germain on 06/06/2016.
 */
public enum  ERarity {

  COMMON(0, 50),
  UNCOMMON(1, 35),
  RARE(2, 20),
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

  private static final Map<Integer, ERarity> map = new TreeMap<>(
          Stream.of(ERarity.values()).collect(Collectors.toMap(ERarity::getRarityLevel, Function.identity()))
  );

  public static ERarity getRarity(int rarityLevel) {
    Optional<Integer> optional = map.keySet().stream().filter(e -> e >= rarityLevel).findFirst();
    return optional.isPresent() ? map.get(optional.get()) : LEGENDARY;
  }

  public static ERarity computeRarity(List<HasRarity> rarities) {
    return getRarity(rarities.stream().map(e -> e.getRarity().getRarityLevel()).mapToInt(Integer::intValue).sum());
  }

}
