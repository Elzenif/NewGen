package nbk.model.utility.love;

import commons.model.commons.constraints.DrawKeyConstraint;
import commons.model.commons.constraints.GenerationConstraints;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 01/10/2016.
 */
public class LoveTest {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  private DrawKeyConstraint drawKeyConstraint;
  private Love love;

  @Before
  public void setUp() throws Exception {
    drawKeyConstraint = new GenerationConstraints().getDrawKeyConstraint();
  }

  @Test
  public void sentencesShouldNotBeEmpty() {
    love = new Love(drawKeyConstraint);
    softly.assertThat(love.getActionSentence()).isNotEmpty();
    softly.assertThat(love.getTargetSentence()).isNotEmpty();
    softly.assertThat(love.getToolSentence()).isNotEmpty();
    softly.assertThat(love.getPositionSentence()).isNotEmpty();
  }

  @Test
  public void scoreShouldBeBetweenMinus8And8() {
    love = new Love(drawKeyConstraint);
    assertThat(love.getLoveScore()).isNotNull().isBetween(-8, 8);
  }
}
