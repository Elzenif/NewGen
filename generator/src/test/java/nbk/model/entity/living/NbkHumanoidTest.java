package nbk.model.entity.living;

import commons.utils.exception.StatNotInRangeException;
import nbk.model.entity.living.characteristics.primary.StatUtils;
import nbk.model.entity.living.characteristics.primary.Stats;
import nbk.model.entity.living.characteristics.secondary.enums.ENbkOrigin;
import nbk.model.entity.living.characteristics.secondary.enums.ENbkProfession;
import org.junit.Test;

import java.util.EnumSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by Germain on 28/08/2016.
 */
public class NbkHumanoidTest {

  private NbkHumanoid humanoid;

  @Test
  public void newHumanoidShouldNotBeNull() {
    humanoid = NbkHumanoid.create();
    assertThat(humanoid).isNotNull();
  }

  @Test
  public void originShouldBeValid() {
    humanoid = NbkHumanoid.create();
    EnumSet<ENbkOrigin> origins = EnumSet.allOf(ENbkOrigin.class);
    assertThat(origins).contains(humanoid.getOrigin());
  }

  @Test
  public void professionShouldBeValidOrNull() {
    humanoid = NbkHumanoid.create();
    EnumSet<ENbkProfession> professions = EnumSet.allOf(ENbkProfession.class);
    ENbkProfession profession = humanoid.getProfession();
    if (profession != null) {
      assertThat(professions).contains(profession);
    }
  }

  @Test
  public void nbkLivingShouldHave7BaseStats() {
    humanoid = NbkHumanoid.create();
    assertThat(humanoid.getStats()).hasSize(7);
  }

  @Test
  public void baseStatsShouldBeBetween8And13() {
    humanoid = NbkHumanoid.create();
    humanoid.getStats().values().forEach(
        value -> assertThat(value >= 8 && value <= 13).isTrue()
    );
  }

  @Test
  public void humanoidCanBeCreatedWithStats() throws StatNotInRangeException {
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

    humanoid = NbkHumanoid.create(stats);

    assertThat(humanoid.getCourage()).isEqualTo(courage);
    assertThat(humanoid.getIntelligence()).isEqualTo(intelligence);
    assertThat(humanoid.getCharisma()).isEqualTo(charisma);
    assertThat(humanoid.getAgility()).isEqualTo(agility);
    assertThat(humanoid.getStrength()).isEqualTo(strength);
  }

  @Test
  public void humanoidCannotBeCreatedWithStatsUnder8() {
    humanoidCannotBeCreatedWithStatsOutOfRange(-7);
  }

  @Test
  public void humanoidCannotBeCreatedWithStatsOver13() {
    humanoidCannotBeCreatedWithStatsOutOfRange(6);
  }

  private void humanoidCannotBeCreatedWithStatsOutOfRange(int offset) {
    try {
      Stats stats = new Stats();
      stats.setCourage(StatUtils.randomStat() + offset);
      humanoid = NbkHumanoid.create(stats);
      fail();
    } catch (StatNotInRangeException e) {
    }
    try {
      Stats stats = new Stats();
      stats.setIntelligence(StatUtils.randomStat() + offset);
      humanoid = NbkHumanoid.create(stats);
      fail();
    } catch (StatNotInRangeException e) {
    }
    try {
      Stats stats = new Stats();
      stats.setCharisma(StatUtils.randomStat() + offset);
      humanoid = NbkHumanoid.create(stats);
      fail();
    } catch (StatNotInRangeException e) {
    }
    try {
      Stats stats = new Stats();
      stats.setAgility(StatUtils.randomStat() + offset);
      humanoid = NbkHumanoid.create(stats);
      fail();
    } catch (StatNotInRangeException e) {
    }
    try {
      Stats stats = new Stats();
      stats.setStrength(StatUtils.randomStat() + offset);
      humanoid = NbkHumanoid.create(stats);
      fail();
    } catch (StatNotInRangeException e) {
    }
  }
}
