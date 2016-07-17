package commons.model.entity.constraints;

import commons.model.entity.characteristics.primary.Primary;
import commons.model.entity.characteristics.secondary.Secondary;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Germain on 05/07/1006.
 */
public class GlobalConstraintsTest {

  private interface HasPrimary0 {
    Primary0 getPrimary0();
  }

  private interface HasPrimary1 {
    Primary1 getPrimary1();
  }

  private enum Primary0 implements Primary, HasPrimary0, GenericConstraint<Primary0> {
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

  private enum Primary1 implements Primary, HasPrimary1, GenericConstraint<Primary1> {
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
    S11(Primary0.P1, Primary1.Q1)
    ;

    private final Primary0 primary0;
    private final Primary1 primary1;

    Secondary0(Primary0 primary0, Primary1 primary1) {
      this.primary0 = primary0;
      this.primary1 = primary1;
    }

    @Override
    public Primary0 getPrimary0() {
      return primary0;
    }

    @Override
    public Primary1 getPrimary1() {
      return primary1;
    }

    public static Constraints<Secondary0> getConstraints() {
      return CONSTRAINTS;
    }

    private static Constraints<Secondary0> CONSTRAINTS = Constraints.ConstraintsBuilder
            .<Secondary0>start()
            .setSecondaryClass(Secondary0.class)
            .setPrimaryClasses(Primary0.class, Primary1.class)
            .build();
  }

  private enum Secondary1 implements Secondary, HasPrimary1 {
    T0(Primary1.Q0),
    T1(Primary1.Q1);

    private final Primary1 primary1;

    Secondary1(Primary1 primary1) {
      this.primary1 = primary1;
    }

    @Override
    public Primary1 getPrimary1() {
      return primary1;
    }

    public static Constraints<Secondary1> getConstraints() {
      return CONSTRAINTS;
    }

    private static Constraints<Secondary1> CONSTRAINTS = Constraints.ConstraintsBuilder
            .<Secondary1>start()
            .setSecondaryClass(Secondary1.class)
            .setPrimaryClasses(Primary1.class)
            .build();
  }

  @Test
  public void testConstraintSetAdd() {
    ConstraintSet<Primary0> constraintSet = new ConstraintSet<>();
    assertTrue(constraintSet.constraintSet.isEmpty());

    assertTrue(constraintSet.add(Primary0.P0));
    assertEquals(1, constraintSet.constraintSet.size());
    assertTrue(constraintSet.constraintSet.contains(Primary0.P0));

    assertFalse(constraintSet.add(Primary0.P0));
    assertEquals(1, constraintSet.constraintSet.size());
    assertTrue(constraintSet.constraintSet.contains(Primary0.P0));

    assertTrue(constraintSet.add(Primary0.P1));
    assertEquals(2, constraintSet.constraintSet.size());
    assertTrue(constraintSet.constraintSet.contains(Primary0.P0));
    assertTrue(constraintSet.constraintSet.contains(Primary0.P1));
  }

  @Test
  public void testConstraintSetRemove() {
    ConstraintSet<Primary0> constraintSet = new ConstraintSet<>();
    constraintSet.add(Primary0.P0);
    constraintSet.add(Primary0.P1);

    assertTrue(constraintSet.remove(Primary0.P0));
    assertEquals(1, constraintSet.constraintSet.size());
    assertFalse(constraintSet.constraintSet.contains(Primary0.P0));

    assertFalse(constraintSet.remove(Primary0.P0));
    assertEquals(1, constraintSet.constraintSet.size());
    assertFalse(constraintSet.constraintSet.contains(Primary0.P0));

    assertTrue(constraintSet.remove(Primary0.P1));
    assertEquals(0, constraintSet.constraintSet.size());
    assertFalse(constraintSet.constraintSet.contains(Primary0.P1));
  }

  @Test
  public void testConstraintSetClear() {
    ConstraintSet<Primary0> constraintSet = new ConstraintSet<>();
    constraintSet.add(Primary0.P0);
    constraintSet.add(Primary0.P1);

    constraintSet.clear();
    assertTrue(constraintSet.constraintSet.isEmpty());
  }

  @Test
  public void testConstraintSetGetPredicate() {
    ConstraintSet<Primary0> constraintSet = new ConstraintSet<>();
    Predicate<Primary0> predicate0;

    predicate0 = constraintSet.getPredicate();
    assertTrue(predicate0.test(Secondary0.S00.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S01.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S10.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S11.getPrimary0()));

    constraintSet.add(Primary0.P0);
    predicate0 = constraintSet.getPredicate();
    assertTrue(predicate0.test(Secondary0.S00.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S01.getPrimary0()));
    assertFalse(predicate0.test(Secondary0.S10.getPrimary0()));
    assertFalse(predicate0.test(Secondary0.S11.getPrimary0()));

    constraintSet.add(Primary0.P1);
    predicate0 = constraintSet.getPredicate();
    assertTrue(predicate0.test(Secondary0.S00.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S01.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S10.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S11.getPrimary0()));

    constraintSet.remove(Primary0.P0);
    predicate0 = constraintSet.getPredicate();
    assertFalse(predicate0.test(Secondary0.S00.getPrimary0()));
    assertFalse(predicate0.test(Secondary0.S01.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S10.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S11.getPrimary0()));
  }

  @Test
  public void testConstraintMapAdd() {
    ConstraintMap constraintMap = new ConstraintMap();
    assertTrue(constraintMap.constraintsMap.isEmpty());

    assertTrue(constraintMap.add(Primary0.class, Primary0.P0));
    assertEquals(1, constraintMap.constraintsMap.size());
    assertTrue(constraintMap.constraintsMap.containsKey(Primary0.class));

    assertFalse(constraintMap.add(Primary0.class, Primary0.P0));
    assertEquals(1, constraintMap.constraintsMap.size());
    assertTrue(constraintMap.constraintsMap.containsKey(Primary0.class));

    assertTrue(constraintMap.add(Primary0.class, Primary0.P1));
    assertEquals(1, constraintMap.constraintsMap.size());
    assertTrue(constraintMap.constraintsMap.containsKey(Primary0.class));

    assertTrue(constraintMap.add(Primary1.class, Primary1.Q0));
    assertEquals(2, constraintMap.constraintsMap.size());
    assertTrue(constraintMap.constraintsMap.containsKey(Primary1.class));
  }

  @SuppressWarnings("SuspiciousMethodCalls")
  @Test
  public void testConstraintMapRemove() {
    ConstraintMap constraintMap = new ConstraintMap();
    constraintMap.add(Primary0.class, Primary0.P0);

    assertTrue(constraintMap.remove(Primary0.class, Primary0.P0));
    assertFalse(constraintMap.constraintsMap.get(Primary0.class).constraintSet.contains(Primary0.P0));
    assertFalse(constraintMap.remove(Primary0.class, Primary0.P0));
  }

  @Test
  public void testConstraintMapClear() {
    ConstraintMap constraintMap = new ConstraintMap();
    constraintMap.add(Primary0.class, Primary0.P0);
    constraintMap.add(Primary0.class, Primary0.P1);

    constraintMap.clear(Primary0.class);
    assertTrue(constraintMap.constraintsMap.get(Primary0.class).constraintSet.isEmpty());
  }

  @Test
  public void testConstraintMapGetPredicate() {
    ConstraintMap constraintMap = new ConstraintMap();
    Predicate<Primary0> predicate0;

    predicate0 = constraintMap.getPredicate(Primary0.class);
    assertTrue(predicate0.test(Secondary0.S00.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S01.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S10.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S11.getPrimary0()));

    constraintMap.add(Primary0.class, Primary0.P0);
    predicate0 = constraintMap.getPredicate(Primary0.class);
    assertTrue(predicate0.test(Secondary0.S00.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S01.getPrimary0()));
    assertFalse(predicate0.test(Secondary0.S10.getPrimary0()));
    assertFalse(predicate0.test(Secondary0.S11.getPrimary0()));

    constraintMap.add(Primary0.class, Primary0.P1);
    predicate0 = constraintMap.getPredicate(Primary0.class);
    assertTrue(predicate0.test(Secondary0.S00.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S01.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S10.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S11.getPrimary0()));

    constraintMap.remove(Primary0.class, Primary0.P0);
    predicate0 = constraintMap.getPredicate(Primary0.class);
    assertFalse(predicate0.test(Secondary0.S00.getPrimary0()));
    assertFalse(predicate0.test(Secondary0.S01.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S10.getPrimary0()));
    assertTrue(predicate0.test(Secondary0.S11.getPrimary0()));
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testConstraintMapGetPredicates() {
    ConstraintMap constraintMap = new ConstraintMap();
    constraintMap.add(Primary0.class, Primary0.P0);
    constraintMap.add(Primary0.class, Primary0.P1);
    constraintMap.add(Primary1.class, Primary1.Q1);

    List<Predicate> predicates = constraintMap.getPredicates(Secondary0.getConstraints().getPrimaryClasses());
    assertEquals(2, predicates.size());

    try {
      Predicate predicate0 = predicates.get(0);
      assertTrue(predicate0.test(Secondary0.S00.getPrimary0()));
      assertTrue(predicate0.test(Secondary0.S01.getPrimary0()));
      assertTrue(predicate0.test(Secondary0.S10.getPrimary0()));
      assertTrue(predicate0.test(Secondary0.S11.getPrimary0()));

      Predicate predicate1 = predicates.get(1);
      assertFalse(predicate1.test(Secondary0.S00.getPrimary1()));
      assertTrue(predicate1.test(Secondary0.S01.getPrimary1()));
      assertFalse(predicate1.test(Secondary0.S10.getPrimary1()));
      assertTrue(predicate1.test(Secondary0.S11.getPrimary1()));
    } catch (ClassCastException e) {
      Predicate predicate0 = predicates.get(1);
      assertTrue(predicate0.test(Secondary0.S00.getPrimary0()));
      assertTrue(predicate0.test(Secondary0.S01.getPrimary0()));
      assertTrue(predicate0.test(Secondary0.S10.getPrimary0()));
      assertTrue(predicate0.test(Secondary0.S11.getPrimary0()));

      Predicate predicate1 = predicates.get(0);
      assertFalse(predicate1.test(Secondary0.S00.getPrimary1()));
      assertTrue(predicate1.test(Secondary0.S01.getPrimary1()));
      assertFalse(predicate1.test(Secondary0.S10.getPrimary1()));
      assertTrue(predicate1.test(Secondary0.S11.getPrimary1()));
    }
  }
}
