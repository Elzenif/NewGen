package nbk.view.utility.scenario.result;

import commons.view.utility.result.UtilityResult;
import nbk.model.utility.scenario.Scenario;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 30/09/2016.
 */
public class ScenarioResult {

  private final List<UtilityResult> results;

  @SuppressWarnings({"SpellCheckingInspection", "HardCodedStringLiteral"})
  public ScenarioResult(Scenario scenario) {
    results = new LinkedList<>();
    results.add(new ScenarioPartResult(scenario.getBeginningSentence()));
    results.add(new ScenarioPartResult(scenario.getGuySentence()));
    results.add(new ScenarioPartResult("vous demande de"));
    results.add(new ScenarioPartResult(scenario.getQuestSentence()));
    results.add(new ScenarioPartResult("dans"));
    results.add(new ScenarioPartResult(scenario.getLocationSentence()));
    results.add(new ScenarioPartResult("pour"));
    results.add(new ScenarioPartResult(scenario.getLootSentence()));
  }

  public Collection<UtilityResult> getResults() {
    return results;
  }
}
