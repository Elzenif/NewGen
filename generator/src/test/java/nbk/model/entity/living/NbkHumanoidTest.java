package nbk.model.entity.living;

import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.exception.NoAvailableEntityTypeException;
import commons.utils.exception.StatNotInRangeException;
import nbk.model.entity.living.characteristics.primary.StatUtils;
import nbk.model.entity.living.characteristics.primary.Stats;
import nbk.model.entity.living.characteristics.secondary.enums.ENbkOrigin;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Germain on 28/08/2016.
 */
public class NbkHumanoidTest {

  private GlobalConstraints globalConstraints;
  private NbkHumanoid humanoid;

  @Before
  public void init() {
    globalConstraints = new GlobalConstraints();
  }

  @Test
  public void newHumanoidShouldNotBeNull() throws NoAvailableEntityTypeException {
    humanoid = NbkHumanoid.create(globalConstraints);
    assertNotNull(humanoid);
  }

  @Test
  public void originShouldBeValid() throws NoAvailableEntityTypeException {
    humanoid = NbkHumanoid.create(globalConstraints);
    EnumSet<ENbkOrigin> origins = EnumSet.allOf(ENbkOrigin.class);
    assertTrue(origins.contains(humanoid.getOrigin()));
  }

  @Test
  public void nbkLivingShouldHave5BaseStats() throws NoAvailableEntityTypeException {
    humanoid = NbkHumanoid.create(globalConstraints);
    assertEquals(5, humanoid.getStats().size());
  }

  @Test
  public void baseStatsShouldBeBetween8And13() throws NoAvailableEntityTypeException {
    humanoid = NbkHumanoid.create(globalConstraints);
    humanoid.getStats().values().forEach(
            value -> assertTrue(value >= 8 && value <= 13)
    );
  }

  @Test
  public void humanoidCanBeCreatedWithStats() throws NoAvailableEntityTypeException, StatNotInRangeException {
    Stats stats = new Stats();
    int courage = StatUtils.randomStat();
    int intelligence = StatUtils.randomStat();
    int charisma = StatUtils.randomStat();
    int agility = StatUtils.randomStat();
    int strength = StatUtils.randomStat();
    stats.setCourage(courage);
    stats.setIntelligence(intelligence);
    stats.setCharisma(charisma);
    stats.setAgility(agility);
    stats.setStrength(strength);

    humanoid = NbkHumanoid.create(globalConstraints, stats);

    assertEquals(courage, humanoid.getCourage());
    assertEquals(intelligence, humanoid.getIntelligence());
    assertEquals(charisma, humanoid.getCharisma());
    assertEquals(agility, humanoid.getAgility());
    assertEquals(strength, humanoid.getStrength());
  }

  @Test
  public void humanoidCannotBeCreatedWithStatsUnder8() throws NoAvailableEntityTypeException {
    humanoidCannotBeCreatedWithStatsOutOfRange(-7);
  }

  @Test
  public void humanoidCannotBeCreatedWithStatsOver13() throws NoAvailableEntityTypeException {
    humanoidCannotBeCreatedWithStatsOutOfRange(6);
  }

  private void humanoidCannotBeCreatedWithStatsOutOfRange(int offset) throws NoAvailableEntityTypeException {
    try {
      Stats stats = new Stats();
      stats.setCourage(StatUtils.randomStat() + offset);
      humanoid = NbkHumanoid.create(globalConstraints, stats);
      fail();
    } catch (StatNotInRangeException e) {}
    try {
      Stats stats = new Stats();
      stats.setIntelligence(StatUtils.randomStat() + offset);
      humanoid = NbkHumanoid.create(globalConstraints, stats);
      fail();
    } catch (StatNotInRangeException e) {}
    try {
      Stats stats = new Stats();
      stats.setCharisma(StatUtils.randomStat() + offset);
      humanoid = NbkHumanoid.create(globalConstraints, stats);
      fail();
    } catch (StatNotInRangeException e) {}
    try {
      Stats stats = new Stats();
      stats.setAgility(StatUtils.randomStat() + offset);
      humanoid = NbkHumanoid.create(globalConstraints, stats);
      fail();
    } catch (StatNotInRangeException e) {}
    try {
      Stats stats = new Stats();
      stats.setStrength(StatUtils.randomStat() + offset);
      humanoid = NbkHumanoid.create(globalConstraints, stats);
      fail();
    } catch (StatNotInRangeException e) {}
  }
}
