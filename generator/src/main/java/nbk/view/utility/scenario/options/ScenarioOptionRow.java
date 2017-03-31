package nbk.view.utility.scenario.options;

import commons.model.commons.IDrawKeyIntegerValue;
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

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 30/09/2016.
 */
public class ScenarioOptionRow extends NbkUtilityOptionRow {

  private final Map<IDrawKeyIntegerValue, Pair<JSpinner, SpinnerNumberModel>> scenarioDrawMap
      = new LinkedHashMap<>(EScenarioDraw.values().length);
  private final int defaultValue = 10;

  public ScenarioOptionRow() {
    super(ENbkAvailableUtility.SCENARIO.getName());

    initDrawKeyConstraintPanel(scenarioDrawMap, EScenarioDraw.values(), defaultValue, 1, 20);

    finalizeRowConstruction(resourceBundle.getString("tooltip.scenario.generate"));
  }

  @Override
  public void setControllers(UtilityResultRow resultRow) {
    super.setControllers(new ScenarioController(this, resultRow, defaultValue));
    scenarioDrawMap.forEach((scenarioDraw, pair) ->
        pair.getLeft().addChangeListener(((ScenarioController) controller).getDrawChangeListener(scenarioDraw)));
  }

  @Override
  public Integer getDrawValue(IDrawKeyIntegerValue drawKey) {
    return scenarioDrawMap.get(drawKey).getRight().getNumber().intValue();
  }
}
