package mvc.model.entity.constraints;

import mvc.model.entity.enums.ENbkQuality;
import mvc.model.entity.utils.ERarity;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Germain on 18/06/2016.
 */
public enum NbkQualityConstraint implements GenericConstraint<ENbkQuality> {

  LEGENDARY(ERarity.LEGENDARY),
  AT_LEAST_EPIC(ERarity.EPIC),
  AT_LEAST_RARE(ERarity.RARE),
  AT_LEAST_UNCOMMON(ERarity.UNCOMMON),
  NO_CONSTRAINT(ERarity.COMMON);

  private final ERarity rarity;

  NbkQualityConstraint(ERarity rarity) {
    this.rarity = rarity;
  }

  public ERarity getRarity() {
    return rarity;
  }

  public static final Map<NbkQualityConstraint, Integer> constraintMap = new TreeMap<>(
          Stream.of(NbkQualityConstraint.values()).collect(
                  Collectors.toMap(Function.identity(), qc -> qc.getRarity().getProba()))
  );

  @NotNull
  @Override
  public Predicate<ENbkQuality> getPredicate() {
    return quality -> quality.getRarity().getRarityLevel() >= rarity.getRarityLevel();
  }
}
