package nbk.model.utility.scenario;

import commons.model.utility.constraints.DrawKeyConstraint;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Germain on 01/10/2016.
 */
public class ScenarioTest {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  private DrawKeyConstraint drawKeyConstraint;
  private Scenario scenario;

  @Before
  public void setUp() throws Exception {
    drawKeyConstraint = new DrawKeyConstraint();
  }

  @Test
  public void sentencesShouldNotBeEmpty() {
    scenario = new Scenario(drawKeyConstraint);
    softly.assertThat(scenario.getBeginningSentence()).isNotEmpty();
    softly.assertThat(scenario.getGuySentence()).isNotEmpty();
    softly.assertThat(scenario.getQuestSentence()).isNotEmpty();
    softly.assertThat(scenario.getLocationSentence()).isNotEmpty();
    softly.assertThat(scenario.getLootSentence()).isNotEmpty();
  }
}
