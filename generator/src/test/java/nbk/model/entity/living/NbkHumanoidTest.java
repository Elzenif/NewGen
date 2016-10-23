package nbk.model.entity.living;

import commons.model.commons.constraints.GenerationConstraints;
import commons.utils.exception.StatNotInRangeException;
import nbk.model.entity.living.characteristics.primary.StatUtils;
import nbk.model.entity.living.characteristics.primary.Stats;
import nbk.model.entity.living.characteristics.secondary.enums.ENbkOrigin;
import nbk.model.entity.living.characteristics.secondary.enums.ENbkProfession;
import nbk.model.entity.living.constraints.EHumanoidDraw;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.EnumSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by Germain on 28/08/2016.
 */
public class NbkHumanoidTest {

  @Rule
  public JUnitSoftAssertions softly = new JUnitSoftAssertions();

  private NbkHumanoid humanoid;
  private GenerationConstraints generationConstraints;

  @Before
  public void setUp() throws Exception {
    generationConstraints = new GenerationConstraints();
  }

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

    generationConstraints.getDrawKeyConstraint().putAll(stats);
    humanoid = NbkHumanoid.create(generationConstraints);

    softly.assertThat(humanoid.getCourage()).isEqualTo(courage);
    softly.assertThat(humanoid.getIntelligence()).isEqualTo(intelligence);
    softly.assertThat(humanoid.getCharisma()).isEqualTo(charisma);
    softly.assertThat(humanoid.getAgility()).isEqualTo(agility);
    softly.assertThat(humanoid.getStrength()).isEqualTo(strength);
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
      generationConstraints.getDrawKeyConstraint().putAll(stats);
      humanoid = NbkHumanoid.create(generationConstraints);
      fail();
    } catch (StatNotInRangeException e) {
    }
    try {
      Stats stats = new Stats();
      stats.setIntelligence(StatUtils.randomStat() + offset);
      generationConstraints.getDrawKeyConstraint().putAll(stats);
      humanoid = NbkHumanoid.create(generationConstraints);
      fail();
    } catch (StatNotInRangeException e) {
    }
    try {
      Stats stats = new Stats();
      stats.setCharisma(StatUtils.randomStat() + offset);
      generationConstraints.getDrawKeyConstraint().putAll(stats);
      humanoid = NbkHumanoid.create(generationConstraints);
      fail();
    } catch (StatNotInRangeException e) {
    }
    try {
      Stats stats = new Stats();
      stats.setAgility(StatUtils.randomStat() + offset);
      generationConstraints.getDrawKeyConstraint().putAll(stats);
      humanoid = NbkHumanoid.create(generationConstraints);
      fail();
    } catch (StatNotInRangeException e) {
    }
    try {
      Stats stats = new Stats();
      stats.setStrength(StatUtils.randomStat() + offset);
      generationConstraints.getDrawKeyConstraint().putAll(stats);
      humanoid = NbkHumanoid.create(generationConstraints);
      fail();
    } catch (StatNotInRangeException e) {
    }
  }

  @Test
  public void humanoidShouldHaveEV() {
    humanoid = NbkHumanoid.create();

    softly.assertThat(humanoid.getEV()).isNotNull().isNotEqualTo(0);

    humanoid = NbkHumanoid.create(generationConstraints);

    softly.assertThat(humanoid.getEV()).isNotNull().isNotEqualTo(0);
  }

  @Test
  public void humanoidCanBeCreatedWithAGivenOrigin() {
    generationConstraints.getMapConstraint().put(EHumanoidDraw.ORIGIN, ENbkOrigin.MURLOC);

    humanoid = NbkHumanoid.create(generationConstraints);

    assertThat(humanoid.getOrigin()).isEqualTo(ENbkOrigin.MURLOC);
  }

  @Test
  public void humanoidCanBeCreatedWithAGivenProfession() {
    generationConstraints.getMapConstraint().put(EHumanoidDraw.PROFESSION, ENbkProfession.SELLER);

    humanoid = NbkHumanoid.create(generationConstraints);

    assertThat(humanoid.getProfession()).isEqualTo(ENbkProfession.SELLER);
  }

  @Test
  public void humanoidCannotBeCreatedWithIncompatiblesOriginAndProfession() {
    generationConstraints.getMapConstraint().put(EHumanoidDraw.ORIGIN, ENbkOrigin.GOBLIN);
    generationConstraints.getMapConstraint().put(EHumanoidDraw.PROFESSION, ENbkProfession.WARRIOR);

    humanoid = NbkHumanoid.create(generationConstraints);

    softly.assertThat(humanoid.getOrigin()).isEqualTo(ENbkOrigin.GOBLIN);
    softly.assertThat(humanoid.getProfession()).isNotEqualTo(ENbkProfession.WARRIOR);
  }

  @Test
  public void humanoidCannotBeCreatedWithIncompatiblesStatsAndOrigin() throws StatNotInRangeException {
    Stats stats = new Stats();
    stats.setStrength(12);
    generationConstraints.getDrawKeyConstraint().putAll(stats);
    generationConstraints.getMapConstraint().put(EHumanoidDraw.ORIGIN, ENbkOrigin.GOBLIN);

    humanoid = NbkHumanoid.create(generationConstraints);

    softly.assertThat(humanoid.getStrength()).isEqualTo(12);
    softly.assertThat(humanoid.getOrigin()).isNotEqualTo(ENbkOrigin.GOBLIN);
  }

  @Test
  public void humanoidCannotBeCreatedWithIncompatiblesStatsAndProfession() throws StatNotInRangeException {
    Stats stats = new Stats();
    stats.setIntelligence(9);
    generationConstraints.getDrawKeyConstraint().putAll(stats);
    generationConstraints.getMapConstraint().put(EHumanoidDraw.PROFESSION, ENbkProfession.MAGE);

    humanoid = NbkHumanoid.create(generationConstraints);

    softly.assertThat(humanoid.getIntelligence()).isEqualTo(9);
    softly.assertThat(humanoid.getProfession()).isNotEqualTo(ENbkProfession.MAGE);
  }
}
