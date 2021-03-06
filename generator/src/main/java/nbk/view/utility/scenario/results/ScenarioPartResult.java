package nbk.view.utility.scenario.results;

import commons.utils.ColorUtils;
import commons.view.utility.result.UtilityResult;

import java.awt.Color;

/**
 * Created by Germain on 30/09/2016.
 */
public class ScenarioPartResult extends UtilityResult {

  private final String sentence;

  public ScenarioPartResult(String sentence) {
    this.sentence = sentence;
  }

  @Override
  public String getRawResult() {
    return sentence;
  }

  @Override
  public Color getColor() {
    return ColorUtils.BLACK;
  }
}
