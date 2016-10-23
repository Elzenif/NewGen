package commons.model.commons.constraints;

import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import commons.model.entity.characteristics.primary.Primary;
import commons.model.entity.characteristics.secondary.Secondary;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 05/07/1006.
 */
public class PredicateConstraintsTest {

  // Tests of ConstraintSet
  @Test
  public void testConstraintSetAdd() {
    ConstraintSet<Primary0> constraintSet = new ConstraintSet<>();
    assertThat(constraintSet.constraintSet.isEmpty()).isTrue();

    assertThat(constraintSet.add(Primary0.P0)).isTrue();
    assertThat(constraintSet.constraintSet).containsOnly(Primary0.P0);

    assertThat(constraintSet.add(Primary0.P0)).isFalse();
    assertThat(constraintSet.constraintSet).containsOnly(Primary0.P0);

    assertThat(constraintSet.add(Primary0.P1)).isTrue();
    assertThat(constraintSet.constraintSet).containsOnly(Primary0.P0, Primary0.P1);
  }

  @Test
  public void testConstraintSetRemove() {
    ConstraintSet<Primary0> constraintSet = new ConstraintSet<>();
    constraintSet.add(Primary0.P0);
    constraintSet.add(Primary0.P1);

    assertThat(constraintSet.remove(Primary0.P0)).isTrue();
    assertThat(constraintSet.constraintSet).hasSize(1);
    assertThat(constraintSet.constraintSet.contains(Primary0.P0)).isFalse();

    assertThat(constraintSet.remove(Primary0.P0)).isFalse();
    assertThat(constraintSet.constraintSet).hasSize(1);
    assertThat(constraintSet.constraintSet.contains(Primary0.P0)).isFalse();

    assertThat(constraintSet.remove(Primary0.P1)).isTrue();
    assertThat(constraintSet.constraintSet).isEmpty();
    assertThat(constraintSet.constraintSet.contains(Primary0.P1)).isFalse();
  }

  @Test
  public void testConstraintSetClear() {
    ConstraintSet<Primary0> constraintSet = new ConstraintSet<>();
    constraintSet.add(Primary0.P0);
    constraintSet.add(Primary0.P1);

    constraintSet.clear();
    assertThat(constraintSet.constraintSet.isEmpty()).isTrue();
  }

  @Test
  public void testConstraintSetGetPredicate() {
    ConstraintSet<Primary0> constraintSet = new ConstraintSet<>();
    Predicate<Primary0> predicate0;

    predicate0 = constraintSet.getPredicate();
    assertThat(predicate0.test(Secondary0.S00.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S01.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S10.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S11.getPrimary0())).isTrue();

    constraintSet.add(Primary0.P0);
    predicate0 = constraintSet.getPredicate();
    assertThat(predicate0.test(Secondary0.S00.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S01.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S10.getPrimary0())).isFalse();
    assertThat(predicate0.test(Secondary0.S11.getPrimary0())).isFalse();

    constraintSet.add(Primary0.P1);
    predicate0 = constraintSet.getPredicate();
    assertThat(predicate0.test(Secondary0.S00.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S01.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S10.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S11.getPrimary0())).isTrue();

    constraintSet.remove(Primary0.P0);
    predicate0 = constraintSet.getPredicate();
    assertThat(predicate0.test(Secondary0.S00.getPrimary0())).isFalse();
    assertThat(predicate0.test(Secondary0.S01.getPrimary0())).isFalse();
    assertThat(predicate0.test(Secondary0.S10.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S11.getPrimary0())).isTrue();
  }

  // Tests of ConstraintMap
  @SuppressWarnings("unchecked")
  @Test
  public void testConstraintMapAdd() {
    ConstraintMap constraintMap = new ConstraintMap();
    assertThat(constraintMap.constraintsMap.isEmpty()).isTrue();

    assertThat(constraintMap.add(Primary0.class, Primary0.P0)).isTrue();
    assertThat(constraintMap.constraintsMap.keySet()).containsOnly(Primary0.class);

    assertThat(constraintMap.add(Primary0.class, Primary0.P0)).isFalse();
    assertThat(constraintMap.constraintsMap.keySet()).containsOnly(Primary0.class);

    assertThat(constraintMap.add(Primary0.class, Primary0.P1)).isTrue();
    assertThat(constraintMap.constraintsMap.keySet()).containsOnly(Primary0.class);

    assertThat(constraintMap.add(Primary1.class, Primary1.Q0)).isTrue();
    assertThat(constraintMap.constraintsMap.keySet()).containsOnly(Primary0.class, Primary1.class);
  }

  @SuppressWarnings("SuspiciousMethodCalls")
  @Test
  public void testConstraintMapRemove() {
    ConstraintMap constraintMap = new ConstraintMap();
    constraintMap.add(Primary0.class, Primary0.P0);

    assertThat(constraintMap.remove(Primary0.class, Primary0.P0)).isTrue();
    assertThat(constraintMap.constraintsMap.get(Primary0.class).constraintSet.contains(Primary0.P0)).isFalse();
    assertThat(constraintMap.remove(Primary0.class, Primary0.P0)).isFalse();
  }

  @Test
  public void testConstraintMapClear() {
    ConstraintMap constraintMap = new ConstraintMap();
    constraintMap.add(Primary0.class, Primary0.P0);
    constraintMap.add(Primary0.class, Primary0.P1);

    constraintMap.clear(Primary0.class);
    assertThat(constraintMap.constraintsMap.get(Primary0.class).constraintSet.isEmpty()).isTrue();
  }

  @Test
  public void testConstraintMapGetPredicate() {
    ConstraintMap constraintMap = new ConstraintMap();
    Predicate<Primary0> predicate0;

    predicate0 = constraintMap.getPredicate(Primary0.class);
    assertThat(predicate0.test(Secondary0.S00.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S01.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S10.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S11.getPrimary0())).isTrue();

    constraintMap.add(Primary0.class, Primary0.P0);
    predicate0 = constraintMap.getPredicate(Primary0.class);
    assertThat(predicate0.test(Secondary0.S00.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S01.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S10.getPrimary0())).isFalse();
    assertThat(predicate0.test(Secondary0.S11.getPrimary0())).isFalse();

    constraintMap.add(Primary0.class, Primary0.P1);
    predicate0 = constraintMap.getPredicate(Primary0.class);
    assertThat(predicate0.test(Secondary0.S00.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S01.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S10.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S11.getPrimary0())).isTrue();

    constraintMap.remove(Primary0.class, Primary0.P0);
    predicate0 = constraintMap.getPredicate(Primary0.class);
    assertThat(predicate0.test(Secondary0.S00.getPrimary0())).isFalse();
    assertThat(predicate0.test(Secondary0.S01.getPrimary0())).isFalse();
    assertThat(predicate0.test(Secondary0.S10.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S11.getPrimary0())).isTrue();
  }

  // Tests of GlobalConstraint
  @Test
  public void testGlobalConstraintAdd() {
    PredicateConstraints predicateConstraints = new PredicateConstraints();
    assertThat(predicateConstraints.globalConstraintsMap).isEmpty();

    assertThat(predicateConstraints.add(Secondary0.getConstraints(), Primary0.class, Primary0.P0)).isTrue();
    assertThat(predicateConstraints.globalConstraintsMap.keySet()).containsOnly(Secondary0.getConstraints());

    assertThat(predicateConstraints.add(Secondary0.getConstraints(), Primary0.class, Primary0.P0)).isFalse();
    assertThat(predicateConstraints.globalConstraintsMap.keySet()).containsOnly(Secondary0.getConstraints());

    assertThat(predicateConstraints.add(Secondary0.getConstraints(), Primary0.class, Primary0.P1)).isTrue();
    assertThat(predicateConstraints.globalConstraintsMap.keySet()).containsOnly(Secondary0.getConstraints());

    assertThat(predicateConstraints.add(Secondary0.getConstraints(), Primary1.class, Primary1.Q0)).isTrue();
    assertThat(predicateConstraints.globalConstraintsMap.keySet()).containsOnly(Secondary0.getConstraints());

    assertThat(predicateConstraints.add(Secondary1.getConstraints(), Primary1.class, Primary1.Q1)).isTrue();
    assertThat(predicateConstraints.globalConstraintsMap.keySet())
            .containsOnly(Secondary0.getConstraints(), Secondary1.getConstraints());
  }

  @Test
  public void testGlobalConstraintRemove() {
    PredicateConstraints predicateConstraints = new PredicateConstraints();
    predicateConstraints.add(Secondary0.getConstraints(), Primary0.class, Primary0.P0);

    assertThat(predicateConstraints.remove(Secondary0.getConstraints(), Primary0.class, Primary0.P0)).isTrue();
    assertThat(predicateConstraints
            .globalConstraintsMap.get(Secondary0.getConstraints())
            .constraintsMap.get(Primary0.class)
            .constraintSet.contains(Primary0.P0)).isFalse();
    assertThat(predicateConstraints.remove(Secondary0.getConstraints(), Primary0.class, Primary0.P0)).isFalse();
  }

  @Test
  public void testGlobalConstraintClearAll() {
    PredicateConstraints predicateConstraints = new PredicateConstraints();
    predicateConstraints.add(Secondary0.getConstraints(), Primary0.class, Primary0.P0);
    predicateConstraints.add(Secondary0.getConstraints(), Primary1.class, Primary1.Q1);
    predicateConstraints.add(Secondary1.getConstraints(), Primary1.class, Primary1.Q0);

    predicateConstraints.clear();
    assertThat(predicateConstraints
            .globalConstraintsMap.get(Secondary0.getConstraints())
            .constraintsMap.get(Primary0.class)
            .constraintSet.isEmpty()).isTrue();
    assertThat(predicateConstraints
            .globalConstraintsMap.get(Secondary0.getConstraints())
            .constraintsMap.get(Primary1.class)
            .constraintSet.isEmpty()).isTrue();
    assertThat(predicateConstraints
            .globalConstraintsMap.get(Secondary1.getConstraints())
            .constraintsMap.get(Primary1.class)
            .constraintSet.isEmpty()).isTrue();

  }

  @Test
  public void testGlobalConstraintClearConstraintsClass() {
    PredicateConstraints predicateConstraints = new PredicateConstraints();
    predicateConstraints.add(Secondary0.getConstraints(), Primary0.class, Primary0.P0);
    predicateConstraints.add(Secondary0.getConstraints(), Primary1.class, Primary1.Q1);
    predicateConstraints.add(Secondary1.getConstraints(), Primary1.class, Primary1.Q0);

    predicateConstraints.clear(Secondary0.getConstraints());
    assertThat(predicateConstraints
            .globalConstraintsMap.get(Secondary0.getConstraints())
            .constraintsMap.get(Primary0.class)
            .constraintSet.isEmpty()).isTrue();
    assertThat(predicateConstraints
            .globalConstraintsMap.get(Secondary0.getConstraints())
            .constraintsMap.get(Primary1.class)
            .constraintSet.isEmpty()).isTrue();
    assertThat(predicateConstraints
            .globalConstraintsMap.get(Secondary1.getConstraints())
            .constraintsMap.get(Primary1.class)
            .constraintSet.isEmpty()).isFalse();
  }

  @Test
  public void testGlobalConstraintClearPrimaryClass() {
    PredicateConstraints predicateConstraints = new PredicateConstraints();
    predicateConstraints.add(Secondary0.getConstraints(), Primary0.class, Primary0.P0);
    predicateConstraints.add(Secondary0.getConstraints(), Primary1.class, Primary1.Q1);
    predicateConstraints.add(Secondary1.getConstraints(), Primary1.class, Primary1.Q0);

    predicateConstraints.clear(Secondary0.getConstraints(), Primary1.class);
    assertThat(predicateConstraints
            .globalConstraintsMap.get(Secondary0.getConstraints())
            .constraintsMap.get(Primary0.class)
            .constraintSet.isEmpty()).isFalse();
    assertThat(predicateConstraints
            .globalConstraintsMap.get(Secondary0.getConstraints())
            .constraintsMap.get(Primary1.class)
            .constraintSet.isEmpty()).isTrue();
    assertThat(predicateConstraints
            .globalConstraintsMap.get(Secondary1.getConstraints())
            .constraintsMap.get(Primary1.class)
            .constraintSet.isEmpty()).isFalse();

  }

  @Test
  public void testGlobalConstraintGetPredicatePrimaryClass() {
    PredicateConstraints predicateConstraints = new PredicateConstraints();
    Predicate<Primary0> predicate0;
    Predicate<Primary1> predicate1;

    predicate0 = predicateConstraints.getPredicate(Secondary0.getConstraints(), Primary0.class);
    assertThat(predicate0.test(Secondary0.S00.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S01.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S10.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S11.getPrimary0())).isTrue();

    predicateConstraints.add(Secondary0.getConstraints(), Primary0.class, Primary0.P0);
    predicate0 = predicateConstraints.getPredicate(Secondary0.getConstraints(), Primary0.class);
    assertThat(predicate0.test(Secondary0.S00.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S01.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S10.getPrimary0())).isFalse();
    assertThat(predicate0.test(Secondary0.S11.getPrimary0())).isFalse();

    predicateConstraints.add(Secondary0.getConstraints(), Primary0.class, Primary0.P1);
    predicate0 = predicateConstraints.getPredicate(Secondary0.getConstraints(), Primary0.class);
    assertThat(predicate0.test(Secondary0.S00.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S01.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S10.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S11.getPrimary0())).isTrue();

    predicateConstraints.remove(Secondary0.getConstraints(), Primary0.class, Primary0.P0);
    predicate0 = predicateConstraints.getPredicate(Secondary0.getConstraints(), Primary0.class);
    assertThat(predicate0.test(Secondary0.S00.getPrimary0())).isFalse();
    assertThat(predicate0.test(Secondary0.S01.getPrimary0())).isFalse();
    assertThat(predicate0.test(Secondary0.S10.getPrimary0())).isTrue();
    assertThat(predicate0.test(Secondary0.S11.getPrimary0())).isTrue();

    predicateConstraints.add(Secondary0.getConstraints(), Primary1.class, Primary1.Q0);
    predicate1 = predicateConstraints.getPredicate(Secondary0.getConstraints(), Primary1.class);
    assertThat(predicate1.test(Secondary0.S00.getPrimary1())).isTrue();
    assertThat(predicate1.test(Secondary0.S01.getPrimary1())).isFalse();
    assertThat(predicate1.test(Secondary0.S10.getPrimary1())).isTrue();
    assertThat(predicate1.test(Secondary0.S11.getPrimary1())).isFalse();
  }

  @Test
  public void testGlobalConstraintUpdate() {
    PredicateConstraints predicateConstraints = new PredicateConstraints();
    predicateConstraints.update(Secondary0.getConstraints(), Primary0.class, Primary0.P0);
    assertThat(predicateConstraints
            .globalConstraintsMap.get(Secondary0.getConstraints())
            .constraintsMap.get(Primary0.class)
            .constraintSet.contains(Primary0.P0)).isTrue();

    predicateConstraints.update(Secondary0.getConstraints(), Primary0.class, Primary0.P0);
    assertThat(predicateConstraints
            .globalConstraintsMap.get(Secondary0.getConstraints())
            .constraintsMap.get(Primary0.class)
            .constraintSet.contains(Primary0.P0)).isFalse();

    predicateConstraints.update(Secondary0.getConstraints(), Primary0.class, Primary0.P0);
    assertThat(predicateConstraints
            .globalConstraintsMap.get(Secondary0.getConstraints())
            .constraintsMap.get(Primary0.class)
            .constraintSet.contains(Primary0.P0)).isTrue();

  }

  private enum Primary0 implements Primary, HasPrimary0, GenericPredicateConstraint<Primary0> {
    P0, P1;

    @Contract(pure = true)
    @Override
    public Primary0 getPrimary0() {
      return this;
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public Predicate<Primary0> getPredicate() {
      return e -> e.getPrimary0() == this;
    }
  }

  private enum Primary1 implements Primary, HasPrimary1, GenericPredicateConstraint<Primary1> {
    Q0, Q1;

    @Contract(pure = true)
    @Override
    public Primary1 getPrimary1() {
      return this;
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public Predicate<Primary1> getPredicate() {
      return e -> e.getPrimary1() == this;
    }
  }

  private enum Secondary0 implements Secondary, HasPrimary0, HasPrimary1 {
    S00(Primary0.P0, Primary1.Q0),
    S01(Primary0.P0, Primary1.Q1),
    S10(Primary0.P1, Primary1.Q0),
    S11(Primary0.P1, Primary1.Q1);

    private static final PrimarySecondaryConstraints<Secondary0> CONSTRAINTS = PrimarySecondaryConstraints.ConstraintsBuilder
        .<Secondary0>start()
        .setSecondaryClass(Secondary0.class)
        .setPrimaryClasses(Primary0.class, Primary1.class)
        .build();
    private final Primary0 primary0;
    private final Primary1 primary1;

    Secondary0(Primary0 primary0, Primary1 primary1) {
      this.primary0 = primary0;
      this.primary1 = primary1;
    }

    public static PrimarySecondaryConstraints<Secondary0> getConstraints() {
      return CONSTRAINTS;
    }

    @Override
    public Primary0 getPrimary0() {
      return primary0;
    }

    @Override
    public Primary1 getPrimary1() {
      return primary1;
    }
  }

  private enum Secondary1 implements Secondary, HasPrimary1 {
    T0(Primary1.Q0),
    T1(Primary1.Q1);

    private static final PrimarySecondaryConstraints<Secondary1> CONSTRAINTS = PrimarySecondaryConstraints.ConstraintsBuilder
        .<Secondary1>start()
        .setSecondaryClass(Secondary1.class)
        .setPrimaryClasses(Primary1.class)
        .build();
    private final Primary1 primary1;

    Secondary1(Primary1 primary1) {
      this.primary1 = primary1;
    }

    public static PrimarySecondaryConstraints<Secondary1> getConstraints() {
      return CONSTRAINTS;
    }

    @Override
    public Primary1 getPrimary1() {
      return primary1;
    }
  }

  @SuppressWarnings("unused")
  private interface HasPrimary0 {

    Primary0 getPrimary0();
  }

  @SuppressWarnings("unused")
  private interface HasPrimary1 {

    Primary1 getPrimary1();
  }
}
