package commons.model.entity.characteristics.primary.enums;

import com.google.common.collect.Lists;
import commons.model.entity.characteristics.primary.Primary;
import commons.model.entity.characteristics.primary.fields.HasRarity;
import commons.model.entity.characteristics.secondary.Secondary;
import commons.model.entity.constraints.Constraints;
import commons.model.entity.constraints.GenericConstraint;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Germain on 06/06/2016.
 */
public enum ERarity implements Primary, Secondary, HasRarity, GenericConstraint<ERarity> {

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

  /**
   * @return A predicate that accepts rarities at least the same level as this one
   */
  @NotNull
  @Override
  public Predicate<ERarity> getPredicate() {
    return q -> q.getRarity().getRarityLevel() >= rarityLevel;
  }

  public static Constraints<ERarity> getConstraints() {
    return RARITY_CONSTRAINTS;
  }

  private final static Constraints<ERarity> RARITY_CONSTRAINTS = Constraints.ConstraintsBuilder.<ERarity>start()
          .setSecondaryClass(ERarity.class)
          .setPrimaryClasses(ERarity.class)
          .build();

  @NotNull
  public static Map<GenericConstraint<ERarity>, Integer> getConstraintMapView() {
    return Collections.unmodifiableMap(constraintMap);
  }

  private static final Map<GenericConstraint<ERarity>, Integer> constraintMap = new LinkedHashMap<>(5);

  static {
    Lists.reverse(Arrays.asList(ERarity.values())).forEach(rarity ->  constraintMap.put(rarity, rarity.getProba()));
  }

  public static ERarity getRarity(int rarityLevel) {
    Optional<Integer> optional = map.keySet().stream().filter(e -> e >= rarityLevel).findFirst();
    return optional.isPresent() ? map.get(optional.get()) : LEGENDARY;
  }

  private static final Map<Integer, ERarity> map = new TreeMap<>(
          Stream.of(ERarity.values()).collect(Collectors.toMap(ERarity::getRarityLevel, Function.identity()))
  );
}
