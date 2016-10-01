package nbk.controller.utility.scenario;

import commons.controller.utility.UtilityController;
import commons.model.utility.UtilityConstraint;
import commons.view.utility.UtilityOptionRow;
import commons.view.utility.UtilityResultRow;
import commons.view.utility.result.UtilityResult;
import nbk.controller.utility.GenerateNbkUtilityActionListener;
import nbk.model.commons.NbkGame;
import nbk.model.utility.scenario.EScenarioDraw;
import nbk.model.utility.scenario.Scenario;
import nbk.view.utility.scenario.result.ScenarioResult;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Created by Germain on 30/09/2016.
 */
public class GenerateScenarioActionListener extends GenerateNbkUtilityActionListener<EScenarioDraw> {

  protected GenerateScenarioActionListener(UtilityOptionRow utilityOptionRow,
                                           UtilityResultRow utilityResultRow,
                                           UtilityController<NbkGame, EScenarioDraw> utilityController) {
    super(utilityOptionRow, utilityResultRow, utilityController);
  }

  @NotNull
  protected Collection<UtilityResult> generateResult(UtilityConstraint utilityConstraint) {
    Scenario scenario = new Scenario(utilityConstraint);
    return new ScenarioResult(scenario).getResults();
  }
}
