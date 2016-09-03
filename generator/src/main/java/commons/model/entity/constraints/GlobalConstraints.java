package commons.model.entity.constraints;

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
public class GlobalConstraints {

  final Map<Constraints, ConstraintMap> globalConstraintsMap = new HashMap<>();

  public <E extends Secondary, F extends Primary>
  void update(Constraints<E> constraintsClass, Class<F> primaryClass, GenericConstraint<F> constraint) {
    if (!constraintsClass.getPrimaryClasses().contains(primaryClass))
      throw new IncompatiblePrimaryClass(primaryClass.toString(), constraintsClass.getSecondaryClass().toString());
    if (!add(constraintsClass, primaryClass, constraint))
      remove(constraintsClass, primaryClass, constraint);
  }

  public <E extends Secondary, F extends Primary>
  Predicate<F> getPredicate(Constraints<E> constraintsClass, Class<F> primaryClass) {
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
  public <E extends Secondary> void clear(Constraints<E> constraintsClass) {
    if (globalConstraintsMap.containsKey(constraintsClass)) {
      constraintsClass.getPrimaryClasses().forEach(primaryClass ->
              globalConstraintsMap.get(constraintsClass).clear(primaryClass)
      );
    }
  }

  @SuppressWarnings("unchecked")
  public <E extends Secondary, F extends Primary>
  void clear(Constraints<E> constraintsClass, Class<F> primaryClass) {
    if (!constraintsClass.getPrimaryClasses().contains(primaryClass))
      throw new IncompatiblePrimaryClass(primaryClass.toString(), constraintsClass.getSecondaryClass().toString());
    if (globalConstraintsMap.containsKey(constraintsClass))
      globalConstraintsMap.get(constraintsClass).clear(primaryClass);
  }

  @SuppressWarnings("unchecked")
  <E extends Secondary, F extends Primary>
  boolean add(Constraints<E> constraintsClass, Class<F> primaryClass, GenericConstraint<F> constraint) {
    if (!globalConstraintsMap.containsKey(constraintsClass))
      globalConstraintsMap.put(constraintsClass, new ConstraintMap());
    return globalConstraintsMap.get(constraintsClass).add(primaryClass, constraint);
  }

  @SuppressWarnings("unchecked")
  <E extends Secondary, F extends Primary>
  boolean remove(Constraints<E> constraintsClass, Class<F> primaryClass, GenericConstraint<F> constraint) {
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
  <F extends Primary> boolean add(Class<F> primaryClass, GenericConstraint<F> constraint) {
    if (!constraintsMap.containsKey(primaryClass))
      constraintsMap.put(primaryClass, new ConstraintSet<>());
    return constraintsMap.get(primaryClass).add(constraint);
  }

  @SuppressWarnings("unchecked")
  <F extends Primary> boolean remove(Class<? extends F> primaryClass, GenericConstraint constraint) {
    return constraintsMap.get(primaryClass).remove(constraint);
  }
}


class ConstraintSet<F extends Primary> {

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