package commons.model.entity.constraints;

import commons.model.entity.characteristics.primary.fields.HasRarity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
public class GlobalConstraints {

  private final Map<Class<? extends HasRarity>, ConstraintMap> map = new HashMap<>();

  @SuppressWarnings("unchecked")
  public <E extends Enum<E> & HasRarity> void update(Class<E> enumClass, AbstractConstraints<E> constraintsClass,
                                                     GenericConstraint<E> constraint) {
    if (!add(enumClass, constraintsClass, constraint))
      remove(enumClass, constraintsClass, constraint);
  }

  @SuppressWarnings("unchecked")
  public <E extends Enum<E> & HasRarity> Predicate<E> getPredicate(Class<E> enumClass,
                                                                   AbstractConstraints<E> constraintsClass) {
    return map.containsKey(enumClass)
            ? (Predicate<E>) map.get(enumClass).getPredicate(constraintsClass)
            : p -> true;
  }

  @SuppressWarnings("unchecked")
  public <E extends Enum<E> & HasRarity> Predicate<E> getPredicate(Class<E> enumClass) {
    return map.containsKey(enumClass)
            ? (Predicate<E>) map.get(enumClass).getPredicate()
            : p -> true;
  }

  @SuppressWarnings("unchecked")
  public <E extends Enum<E> & HasRarity> void clear(Class<E> enumClass, AbstractConstraints<E> constraintsClass) {
    if (map.containsKey(enumClass))
      map.get(enumClass).clear(constraintsClass);
  }

  @SuppressWarnings("unchecked")
  private  <E extends Enum<E> & HasRarity> boolean add(Class<E> enumClass, AbstractConstraints<E> constraintsClass,
                                                       GenericConstraint<E> constraint) {
    if (!map.containsKey(enumClass))
      map.put(enumClass, new ConstraintMap<E>());
    return map.get(enumClass).add(constraintsClass, constraint);
  }


  @SuppressWarnings("unchecked")
  private <E extends Enum<E> & HasRarity> boolean remove(Class<E> enumClass, AbstractConstraints<E> constraintsClass,
                                                         GenericConstraint<E> constraint) {
    return map.containsKey(enumClass) && map.get(enumClass).remove(constraintsClass, constraint);
  }
}

class ConstraintMap<E extends Enum<E> & HasRarity> {

  private final Map<AbstractConstraints<E>, ConstraintSet<E>> constraintsMap = new HashMap<>();

  Predicate<E> getPredicate(AbstractConstraints<E> constraintsClass) {
    return constraintsMap.get(constraintsClass).getPredicate();
  }

  Predicate<E> getPredicate() {
    return constraintsMap.values().stream()
            .map(ConstraintSet::getPredicate)
            .reduce(Predicate::and)
            .orElse(p -> true);
  }

  void clear(AbstractConstraints<E> constraintsClass) {
    constraintsMap.get(constraintsClass).clear();
  }

  boolean add(AbstractConstraints<E> constraintsClass, GenericConstraint<E> constraint) {
    if (!constraintsMap.containsKey(constraintsClass))
      constraintsMap.put(constraintsClass, new ConstraintSet<>());
    return constraintsMap.get(constraintsClass).add(constraint);
  }


  boolean remove(AbstractConstraints<E> constraintsClass, GenericConstraint<E> constraint) {
    return constraintsMap.get(constraintsClass).remove(constraint);
  }
}

class ConstraintSet<E extends Enum<E> & HasRarity> {

  private final Set<GenericConstraint<E>> constraintSet = new HashSet<>();

  Predicate<E> getPredicate() {
    return constraintSet.stream()
            .map(GenericConstraint::getPredicate)
            .reduce(Predicate::or)
            .orElse(p -> true);
  }

  void clear() {
    constraintSet.clear();
  }

  boolean add(GenericConstraint<E> constraint) {
    return constraintSet.add(constraint);
  }

  boolean remove(GenericConstraint<E> constraint) {
    return constraintSet.remove(constraint);
  }
}