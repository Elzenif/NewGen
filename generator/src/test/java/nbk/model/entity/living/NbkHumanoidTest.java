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

import static org.assertj.core.api.Assertions.assertThat;
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
    assertThat(humanoid).isNotNull();
  }

  @Test
  public void originShouldBeValid() throws NoAvailableEntityTypeException {
    humanoid = NbkHumanoid.create(globalConstraints);
    EnumSet<ENbkOrigin> origins = EnumSet.allOf(ENbkOrigin.class);
    assertThat(origins.contains(humanoid.getOrigin())).isTrue();
  }

  @Test
  public void nbkLivingShouldHave5BaseStats() throws NoAvailableEntityTypeException {
    humanoid = NbkHumanoid.create(globalConstraints);
    assertThat(humanoid.getStats()).hasSize(5);
  }

  @Test
  public void baseStatsShouldBeBetween8And13() throws NoAvailableEntityTypeException {
    humanoid = NbkHumanoid.create(globalConstraints);
    humanoid.getStats().values().forEach(
            value -> assertThat(value >= 8 && value <= 13).isTrue()
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

    assertThat(humanoid.getCourage()).isEqualTo(courage);
    assertThat(humanoid.getIntelligence()).isEqualTo(intelligence);
    assertThat(humanoid.getCharisma()).isEqualTo(charisma);
    assertThat(humanoid.getAgility()).isEqualTo(agility);
    assertThat(humanoid.getStrength()).isEqualTo(strength);
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
