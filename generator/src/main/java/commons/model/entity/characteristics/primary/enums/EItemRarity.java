package commons.model.entity.characteristics.primary.enums;

import com.google.common.collect.Lists;
import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by Germain on 06/06/2016.
 */
public enum EItemRarity implements IRarity<EItemRarity> {

  COMMON(49),
  UNCOMMON(30),
  RARE(15),
  EPIC(5),
  LEGENDARY(1);

  private static final Map<GenericPredicateConstraint<EItemRarity>, Integer> constraintMap = new LinkedHashMap<>(5);

  static {
    Lists.reverse(Arrays.asList(EItemRarity.values())).forEach(rarity -> constraintMap.put(rarity, rarity.getProba()));
  }

  private final int proba;

  EItemRarity(int proba) {
    this.proba = proba;
  }

  @NotNull
  public static Map<GenericPredicateConstraint<EItemRarity>, Integer> getConstraintMapView() {
    return Collections.unmodifiableMap(constraintMap);
  }

  public int getProba() {
    return proba;
  }

  @Contract(pure = true)
  @Override
  public EItemRarity getRarity() {
    return this;
  }

  /**
   * @return A predicate that accepts rarities at least the same level as this one
   */
  @NotNull
  @Override
  public Predicate<EItemRarity> getPredicate() {
    return q -> q.ordinal() >= ordinal();
  }
}
