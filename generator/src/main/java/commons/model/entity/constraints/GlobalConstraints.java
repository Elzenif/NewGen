package commons.model.entity.constraints;

import commons.model.entity.characteristics.primary.Primary;
import commons.model.entity.characteristics.secondary.Secondary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Germain on 11/06/2016.
 */
public class GlobalConstraints {

  final Map<Constraints, ConstraintMap> map = new HashMap<>();

  public <E extends Enum<E> & Secondary, F extends Enum<F> & Primary>
  void update(Constraints<E> constraintsClass, Class<F> primaryClass, GenericConstraint<F> constraint) {
    if (!constraintsClass.getPrimaryClasses().contains(primaryClass))
      throw new IllegalArgumentException(primaryClass + " is not compatible with " + constraintsClass);
    if (!add(constraintsClass, primaryClass, constraint))
      remove(constraintsClass, primaryClass, constraint);
  }

  @SuppressWarnings("unchecked")
  public <E extends Enum<E> & Secondary, F extends Enum<F> & Primary>
  Predicate<E> getPredicate(Constraints<E> constraintsClass, Class<F> primaryClass) {
    if (!constraintsClass.getPrimaryClasses().contains(primaryClass))
      throw new IllegalArgumentException(primaryClass + " is not compatible with " + constraintsClass);
    return map.containsKey(constraintsClass)
            ? p -> map.get(constraintsClass).getPredicate(primaryClass).test((F) p)
            : p -> true;
  }

  @SuppressWarnings("unchecked")
  public <E extends Enum<E> & Secondary> Predicate<E> getPredicate(Constraints<E> constraintsClass) {
    if (map.containsKey(constraintsClass)) {
      List<Predicate> predicates = map.get(constraintsClass).getPredicates(constraintsClass.getPrimaryClasses());
      return (Predicate<E>) predicates.stream().reduce(Predicate::and).orElse(p -> true);
    } else return p -> true;
  }

  @SuppressWarnings("unchecked")
  public <E extends Enum<E> & Secondary, F extends Enum<F> & Primary>
  void clear(Constraints<E> constraintsClass, Class<F> primaryClass) {
    if (!constraintsClass.getPrimaryClasses().contains(primaryClass))
      throw new IllegalArgumentException(primaryClass + " is not compatible with " + constraintsClass);
    if (map.containsKey(constraintsClass))
      map.get(constraintsClass).clear(primaryClass);
  }

  @SuppressWarnings("unchecked")
  public <E extends Enum<E> & Secondary> void clear(Constraints<E> constraintsClass) {
    if (map.containsKey(constraintsClass)) {
      constraintsClass.getPrimaryClasses().stream().forEach(primaryClass ->
              map.get(constraintsClass).clear(primaryClass)
      );
    }
  }

  @SuppressWarnings("unchecked")
  private <E extends Enum<E> & Secondary, F extends Enum<F> & Primary>
  boolean add(Constraints<E> constraintsClass, Class<F> primaryClass, GenericConstraint<F> constraint) {
    if (!map.containsKey(constraintsClass))
      map.put(constraintsClass, new ConstraintMap());
    return map.get(constraintsClass).add(primaryClass, constraint);
  }

  @SuppressWarnings("unchecked")
  private <E extends Enum<E> & Secondary, F extends Enum<F> & Primary>
  boolean remove(Constraints<E> constraintsClass, Class<F> primaryClass, GenericConstraint<F> constraint) {
    return map.containsKey(constraintsClass) && map.get(constraintsClass).remove(primaryClass, constraint);
  }
}


class ConstraintMap {

  final Map<Class<? extends Primary>, ConstraintSet> constraintsMap = new HashMap<>();

  @SuppressWarnings("unchecked")
  <F extends Enum<F> & Primary> Predicate<F> getPredicate(Class<F> primaryClass) {
    return constraintsMap.containsKey(primaryClass)
            ? (Predicate<F>) constraintsMap.get(primaryClass).getPredicate()
            : p -> true;
  }

  List<Predicate> getPredicates(Set<Class<? extends Primary>> primaryClasses) {
    return primaryClasses.stream()
            .map(constraintsMap::get)
            .map(ConstraintSet::getPredicate)
            .collect(Collectors.toList());
  }

  void clear(Class<? extends Primary> primaryClass) {
    constraintsMap.get(primaryClass).clear();
  }

  @SuppressWarnings("unchecked")
  <F extends Enum<F> & Primary> boolean add(Class<F> primaryClass, GenericConstraint<F> constraint) {
    if (!constraintsMap.containsKey(primaryClass))
      constraintsMap.put(primaryClass, new ConstraintSet<>());
    return constraintsMap.get(primaryClass).add(constraint);
  }

  @SuppressWarnings("unchecked")
  <F extends Enum<F> & Primary> boolean remove(Class<? extends F> primaryClass, GenericConstraint constraint) {
    return constraintsMap.get(primaryClass).remove(constraint);
  }
}


class ConstraintSet<F extends Enum<F> & Primary> {

  final Set<GenericConstraint<F>> constraintSet = new HashSet<>();

  Predicate<F> getPredicate() {
    return constraintSet.stream()
            .map(GenericConstraint::getPredicate)
            .reduce(Predicate::or)
            .orElse(p -> true);
  }

  void clear() {
    constraintSet.clear();
  }

  boolean add(GenericConstraint<F> constraint) {
    return constraintSet.add(constraint);
  }

  boolean remove(GenericConstraint<F> constraint) {
    return constraintSet.remove(constraint);
  }
}