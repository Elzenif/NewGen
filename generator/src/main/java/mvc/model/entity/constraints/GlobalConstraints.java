package mvc.model.entity.constraints;

import mvc.model.entity.utils.ItemType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
public class GlobalConstraints {

  // This is not pretty, but since it is not possible for a wildcard to extends multiple interfaces/classes...
  private final Map<
          Class<? extends ItemType>,
          Map<Class<? extends GenericConstraint>, GenericConstraint<? extends ItemType>>> map;

  public GlobalConstraints() {
    map = new HashMap<>();
  }

  public <T extends GenericConstraint<E>, E extends Enum<E> & ItemType> void put(Class<E> itemTypeClass,
                                                                                 Class<T> constraintClass,
                                                                                 GenericConstraint<E> constraint) {
    if (!map.containsKey(itemTypeClass))
      map.put(itemTypeClass, new HashMap<>());
    map.get(itemTypeClass).put(constraintClass, constraint);
  }

  @SuppressWarnings("unchecked")
  public <T extends GenericConstraint<E>, E extends Enum<E> & ItemType> Predicate<E>
  getConstraint(Class<E> itemTypeClass, Class<T> constraintClass) {
    return map.containsKey(itemTypeClass)
            ? (Predicate<E>) map.get(itemTypeClass).get(constraintClass).getPredicate()
            : p -> true;
  }

  @SuppressWarnings("unchecked")
  public <E extends Enum<E> & ItemType> Predicate<E> getConstraint(Class<E> itemTypeClass) {
    return map.containsKey(itemTypeClass)
            ? (Predicate<E>) map.get(itemTypeClass).values()
            .stream().map(GenericConstraint::getPredicate).reduce(Predicate::and).orElse(p -> true)
            : p -> true;
  }

}
