package nbk.model.utility.scenario;

import commons.model.utility.UtilityConstraint;
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
  private UtilityConstraint utilityConstraint;
  private Scenario scenario;

  @Before
  public void setUp() throws Exception {
    utilityConstraint = new UtilityConstraint();
  }

  @Test
  public void sentencesShouldNotBeEmpty() {
    scenario = new Scenario(utilityConstraint);
    softly.assertThat(scenario.getBeginningSentence()).isNotEmpty();
    softly.assertThat(scenario.getGuySentence()).isNotEmpty();
    softly.assertThat(scenario.getQuestSentence()).isNotEmpty();
    softly.assertThat(scenario.getLocationSentence()).isNotEmpty();
    softly.assertThat(scenario.getLootSentence()).isNotEmpty();
  }
}
