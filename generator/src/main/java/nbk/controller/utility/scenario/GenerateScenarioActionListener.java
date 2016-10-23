package nbk.controller.utility.scenario;

import commons.controller.utility.UtilityController;
import commons.model.commons.constraints.GenerationConstraints;
import commons.view.utility.UtilityOptionRow;
import commons.view.utility.UtilityResultRow;
import commons.view.utility.result.UtilityResult;
import nbk.controller.utility.GenerateNbkUtilityActionListener;
import nbk.model.utility.scenario.Scenario;
import nbk.view.utility.scenario.results.ScenarioResult;

import java.util.Collection;

/**
 * Created by Germain on 30/09/2016.
 */
public class GenerateScenarioActionListener extends GenerateNbkUtilityActionListener {

  public GenerateScenarioActionListener(UtilityOptionRow utilityOptionRow,
                                        UtilityResultRow utilityResultRow,
                                        UtilityController utilityController) {
    super(utilityOptionRow, utilityResultRow, utilityController);
  }

  @Override
  protected Collection<UtilityResult> generateResult(GenerationConstraints generationConstraints) {
    Scenario scenario = new Scenario(generationConstraints.getDrawKeyConstraint());
    return new ScenarioResult(scenario).getResults();
  }
}
