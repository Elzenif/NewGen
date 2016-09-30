package nbk.view.utility.scenario.result;

import commons.view.utility.result.UtilityResult;
import nbk.model.utility.scenario.ScenarioModel;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 30/09/2016.
 */
public class ScenarioResult {

  private final List<UtilityResult> results;

  @SuppressWarnings("SpellCheckingInspection")
  public ScenarioResult(ScenarioModel scenarioModel) {
    results = new LinkedList<>();
    results.add(new ScenarioPartResult(scenarioModel.getBeginningSentence()));
    results.add(new ScenarioPartResult(scenarioModel.getGuySentence()));
    results.add(new ScenarioPartResult("vous demande de"));
    results.add(new ScenarioPartResult(scenarioModel.getQuestSentence()));
    results.add(new ScenarioPartResult("dans"));
    results.add(new ScenarioPartResult(scenarioModel.getLocationSentence()));
    results.add(new ScenarioPartResult("pour"));
    results.add(new ScenarioPartResult(scenarioModel.getLootSentence()));
  }

  public Collection<UtilityResult> getResults() {
    return results;
  }
}
