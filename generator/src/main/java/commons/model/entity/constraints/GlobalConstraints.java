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

  public <T extends GenericConstraint<E>, E extends Enum<E> & HasRarity> void put(Class<E> enumClass,
                                                                                  Class<T> constraintClass,
                                                                                  GenericConstraint<E> constraint) {
    if (!map.containsKey(enumClass))
      map.put(enumClass, new HashMap<>());
    map.get(enumClass).put(constraintClass, constraint);
  }

  @SuppressWarnings("unchecked")
  public <T extends GenericConstraint<E>, E extends Enum<E> & HasRarity> Predicate<E>
  getPredicate(Class<E> enumClass, Class<T> constraintClass) {
    return map.containsKey(enumClass)
            ? (Predicate<E>) map.get(enumClass).get(constraintClass).getPredicate()
            : p -> true;
  }

  @SuppressWarnings("unchecked")
  public <E extends Enum<E> & HasRarity> Predicate<E> getPredicate(Class<E> enumClass) {
    return map.containsKey(enumClass)
            ? (Predicate<E>) map.get(enumClass).values()
            .stream().map(GenericConstraint::getPredicate).reduce(Predicate::and).orElse(p -> true)
            : p -> true;
  }

}
