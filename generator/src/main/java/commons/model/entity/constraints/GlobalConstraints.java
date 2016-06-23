package commons.model.entity.constraints;

import commons.model.entity.utils.HasRarity;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
public class GlobalConstraints {

  // This is not pretty, but since it is not possible for a wildcard to extends multiple interfaces/classes...
  private final Map<
          Class<? extends HasRarity>,
          Map<Class<? extends GenericConstraint>, GenericConstraint<? extends HasRarity>>> map;

  public GlobalConstraints() {
    map = new HashMap<>();
  }

  public <T extends GenericConstraint<E>, E extends Enum<E> & HasRarity> void put(Class<E> hasRarityClass,
                                                                                 Class<T> constraintClass,
                                                                                 GenericConstraint<E> constraint) {
    if (!map.containsKey(hasRarityClass))
      map.put(hasRarityClass, new HashMap<>());
    map.get(hasRarityClass).put(constraintClass, constraint);
  }

  @SuppressWarnings("unchecked")
  public <T extends GenericConstraint<E>, E extends Enum<E> & HasRarity> Predicate<E>
  getPredicate(Class<E> hasRarityClass, Class<T> constraintClass) {
    return map.containsKey(hasRarityClass)
            ? (Predicate<E>) map.get(hasRarityClass).get(constraintClass).getPredicate()
            : p -> true;
  }

  @SuppressWarnings("unchecked")
  public <E extends Enum<E> & HasRarity> Predicate<E> getPredicate(Class<E> hasRarityClass) {
    return map.containsKey(hasRarityClass)
            ? (Predicate<E>) map.get(hasRarityClass).values()
            .stream().map(GenericConstraint::getPredicate).reduce(Predicate::and).orElse(p -> true)
            : p -> true;
  }

}
