package nbk.view.utility.scenario.options;

import commons.utils.Pair;
import commons.view.utility.UtilityResultRow;
import nbk.controller.utility.scenario.ScenarioController;
import nbk.model.utility.ENbkAvailableUtility;
import nbk.model.utility.scenario.constraints.EScenarioDraw;
import nbk.view.utility.options.NbkUtilityOptionRow;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.util.LinkedHashMap;
import java.util.Map;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 30/09/2016.
 */
public class ScenarioOptionRow extends NbkUtilityOptionRow<EScenarioDraw> {

  private final Map<EScenarioDraw, Pair<JSpinner, SpinnerNumberModel>> scenarioDrawMap;

  public ScenarioOptionRow() {
    super(ENbkAvailableUtility.SCENARIO.getName());

    scenarioDrawMap = new LinkedHashMap<>(EScenarioDraw.values().length);
    for (EScenarioDraw scenarioDraw : EScenarioDraw.values()) {
      SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(1, 1, 20, 1);
      JSpinner jSpinner = new JSpinner(spinnerNumberModel);
      jSpinner.setAlignmentX(LEFT_ALIGNMENT);
      scenarioDrawMap.put(scenarioDraw, new Pair<>(jSpinner, spinnerNumberModel));
      constraintPanel.add(jSpinner);
    }

    finalizeRowConstruction(resourceBundle.getString("tooltip.scenario.generate"));
  }

  @Override
  public void setControllers(UtilityResultRow resultRow) {
    super.setControllers(new ScenarioController(this, resultRow));
    scenarioDrawMap.forEach((scenarioDraw, pair) ->
        pair.getLeft().addChangeListener(((ScenarioController) controller).getDrawChangeListener(scenarioDraw)));
  }

  @Override
  public Object getDrawValue(EScenarioDraw drawKey) {
    return scenarioDrawMap.get(drawKey).getRight().getNumber().intValue();
  }
}
