package nbk.controller.utility.scenario;

import commons.controller.entity.items.ConstraintsItemListener;
import commons.controller.intf.ConstraintOptionRowController;
import commons.view.utility.UtilityResultRow;
import nbk.view.utility.scenario.ScenarioOptionRow;

/**
 * Created by Germain on 30/09/2016.
 */
public class ScenarioController implements ConstraintOptionRowController {

  private final ConstraintsItemListener constraintsItemListener;
  private final GenerateScenarioActionListener generateScenarioActionListener;

  public ScenarioController(ScenarioOptionRow scenarioOptionRow, UtilityResultRow scenarioResultRow) {
    constraintsItemListener = new ConstraintsItemListener(scenarioOptionRow);
    generateScenarioActionListener = new GenerateScenarioActionListener(scenarioOptionRow, scenarioResultRow);
  }

  @Override
  public ConstraintsItemListener getConstraintsItemListener() {
    return constraintsItemListener;
  }

  public GenerateScenarioActionListener getGenerateScenarioActionListener() {
    return generateScenarioActionListener;
  }
}
