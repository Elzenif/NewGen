package commons.model.entity.constraints;

import commons.model.entity.enums.ERarity;
import commons.model.entity.utils.fields.HasRarity;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by Germain on 18/06/2016.
 */
public class RarityConstraints<E extends Enum<E> & HasRarity> extends AbstractConstraints<E> {

  private final GenericConstraint<E> atLeastUncommon = () -> predicate(ERarity.UNCOMMON);

  private final GenericConstraint<E> atLeastRare = () -> predicate(ERarity.RARE);

  private final GenericConstraint<E> atLeastEpic = () -> predicate(ERarity.EPIC);

  private final GenericConstraint<E> atLeastLegendary = () -> predicate(ERarity.LEGENDARY);

  private final Map<GenericConstraint<E>, Integer> constraintMap = new LinkedHashMap<>(5);

  public RarityConstraints(Class<E> clazz) {
    super(clazz);
    constraintMap.put(atLeastLegendary, ERarity.LEGENDARY.getProba());
    constraintMap.put(atLeastEpic, ERarity.EPIC.getProba());
    constraintMap.put(atLeastRare, ERarity.RARE.getProba());
    constraintMap.put(atLeastUncommon, ERarity.UNCOMMON.getProba());
    constraintMap.put(noConstraint, ERarity.COMMON.getProba());
  }

  public Map<GenericConstraint<E>, Integer> getConstraintMapView() {
    return Collections.unmodifiableMap(constraintMap);
  }

  @NotNull
  private Predicate<E> predicate(ERarity rarity) {
    return q -> q.getRarity().getRarityLevel() >= rarity.getRarityLevel();
  }
}
