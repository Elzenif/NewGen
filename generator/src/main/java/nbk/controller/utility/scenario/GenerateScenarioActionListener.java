package nbk.controller.utility.scenario;

import commons.controller.utility.UtilityController;
import commons.model.utility.constraints.UtilityConstraint;
import commons.view.utility.UtilityOptionRow;
import commons.view.utility.UtilityResultRow;
import commons.view.utility.result.UtilityResult;
import nbk.controller.utility.GenerateNbkUtilityActionListener;
import nbk.model.utility.scenario.Scenario;
import nbk.model.utility.scenario.constraints.EScenarioDraw;
import nbk.view.utility.scenario.results.ScenarioResult;

import java.util.Collection;

/**
 * Created by Germain on 30/09/2016.
 */
public class GenerateScenarioActionListener extends GenerateNbkUtilityActionListener<EScenarioDraw> {

  public GenerateScenarioActionListener(UtilityOptionRow<EScenarioDraw> utilityOptionRow,
                                        UtilityResultRow utilityResultRow,
                                        UtilityController<EScenarioDraw> utilityController) {
    super(utilityOptionRow, utilityResultRow, utilityController);
  }

  @Override
  protected Collection<UtilityResult> generateResult(UtilityConstraint utilityConstraint) {
    Scenario scenario = new Scenario(utilityConstraint);
    return new ScenarioResult(scenario).getResults();
  }
}
