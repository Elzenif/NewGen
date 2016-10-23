package commons.model.commons.constraints;

import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import commons.model.entity.characteristics.primary.Primary;
import commons.model.entity.characteristics.secondary.Secondary;
import commons.utils.exception.IncompatiblePrimaryClass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by Germain on 11/06/2016.
 */
public class PredicateConstraints {

  final Map<PrimarySecondaryConstraints, ConstraintMap> globalConstraintsMap = new HashMap<>();

  PredicateConstraints() {
  }

  public <E extends Secondary, F extends Primary>
  void update(PrimarySecondaryConstraints<E> constraintsClass, Class<F> primaryClass, GenericPredicateConstraint<F> constraint) {
    if (!constraintsClass.getPrimaryClasses().contains(primaryClass))
      throw new IncompatiblePrimaryClass(primaryClass.toString(), constraintsClass.getSecondaryClass().toString());
    if (!add(constraintsClass, primaryClass, constraint))
      remove(constraintsClass, primaryClass, constraint);
  }

  public <E extends Secondary, F extends Primary>
  Predicate<F> getPredicate(PrimarySecondaryConstraints<E> constraintsClass, Class<F> primaryClass) {
    if (!constraintsClass.getPrimaryClasses().contains(primaryClass))
      throw new IncompatiblePrimaryClass(primaryClass.toString(), constraintsClass.getSecondaryClass().toString());
    return globalConstraintsMap.containsKey(constraintsClass)
            ? globalConstraintsMap.get(constraintsClass).getPredicate(primaryClass)
            : p -> true;
  }

  public void clear() {
    globalConstraintsMap.keySet().forEach(this::clear);
  }

  @SuppressWarnings("unchecked")
  public <E extends Secondary> void clear(PrimarySecondaryConstraints<E> constraintsClass) {
    if (globalConstraintsMap.containsKey(constraintsClass)) {
      constraintsClass.getPrimaryClasses().forEach(primaryClass ->
              globalConstraintsMap.get(constraintsClass).clear(primaryClass)
      );
    }
  }

  @SuppressWarnings("unchecked")
  public <E extends Secondary, F extends Primary>
  void clear(PrimarySecondaryConstraints<E> constraintsClass, Class<F> primaryClass) {
    if (!constraintsClass.getPrimaryClasses().contains(primaryClass))
      throw new IncompatiblePrimaryClass(primaryClass.toString(), constraintsClass.getSecondaryClass().toString());
    if (globalConstraintsMap.containsKey(constraintsClass))
      globalConstraintsMap.get(constraintsClass).clear(primaryClass);
  }

  @SuppressWarnings("unchecked")
  <E extends Secondary, F extends Primary>
  boolean add(PrimarySecondaryConstraints<E> constraintsClass, Class<F> primaryClass, GenericPredicateConstraint<F> constraint) {
    if (!globalConstraintsMap.containsKey(constraintsClass))
      globalConstraintsMap.put(constraintsClass, new ConstraintMap());
    return globalConstraintsMap.get(constraintsClass).add(primaryClass, constraint);
  }

  @SuppressWarnings("unchecked")
  <E extends Secondary, F extends Primary>
  boolean remove(PrimarySecondaryConstraints<E> constraintsClass, Class<F> primaryClass, GenericPredicateConstraint<F> constraint) {
    return globalConstraintsMap.containsKey(constraintsClass) && globalConstraintsMap.get(constraintsClass).remove(primaryClass, constraint);
  }
}


class ConstraintMap {

  final Map<Class<? extends Primary>, ConstraintSet> constraintsMap = new HashMap<>();

  @SuppressWarnings("unchecked")
  <F extends Primary> Predicate<F> getPredicate(Class<F> primaryClass) {
    return constraintsMap.containsKey(primaryClass)
            ? (Predicate<F>) constraintsMap.get(primaryClass).getPredicate()
            : p -> true;
  }

  void clear(Class<? extends Primary> primaryClass) {
    constraintsMap.get(primaryClass).clear();
  }

  @SuppressWarnings("unchecked")
  <F extends Primary> boolean add(Class<F> primaryClass, GenericPredicateConstraint<F> constraint) {
    if (!constraintsMap.containsKey(primaryClass))
      constraintsMap.put(primaryClass, new ConstraintSet<>());
    return constraintsMap.get(primaryClass).add(constraint);
  }

  @SuppressWarnings("unchecked")
  <F extends Primary> boolean remove(Class<? extends F> primaryClass, GenericPredicateConstraint constraint) {
    return constraintsMap.get(primaryClass).remove(constraint);
  }
}


class ConstraintSet<F extends Primary> {

  final Set<GenericPredicateConstraint<F>> constraintSet = new HashSet<>();

  Predicate<F> getPredicate() {
    return constraintSet.stream()
        .map(GenericPredicateConstraint::getPredicate)
            .reduce(Predicate::or)
            .orElse(p -> true);
  }

  void clear() {
    constraintSet.clear();
  }

  boolean add(GenericPredicateConstraint<F> constraint) {
    return constraintSet.add(constraint);
  }

  boolean remove(GenericPredicateConstraint<F> constraint) {
    return constraintSet.remove(constraint);
  }
}