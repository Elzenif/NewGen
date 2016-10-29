package nbk.controller.utility.scenario;

import commons.controller.utility.UtilityController;
import commons.model.commons.IDrawKeyIntegerValue;
import commons.view.utility.UtilityResultRow;
import nbk.controller.utility.DrawChangeListener;
import nbk.model.utility.scenario.constraints.EScenarioDraw;
import nbk.view.utility.scenario.options.ScenarioOptionRow;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Germain on 30/09/2016.
 */
public class ScenarioController extends UtilityController {

  private final Map<IDrawKeyIntegerValue, DrawChangeListener<IDrawKeyIntegerValue>> drawChangeListenerMap
      = new LinkedHashMap<>(EScenarioDraw.values().length);

  public ScenarioController(ScenarioOptionRow scenarioOptionRow, UtilityResultRow scenarioResultRow, int defaultValue) {
    super(scenarioOptionRow);
    generateActionListener = new GenerateScenarioActionListener(scenarioOptionRow, scenarioResultRow, this);
    Arrays.stream(EScenarioDraw.values()).forEach(scenarioDraw -> {
      drawChangeListenerMap.put(scenarioDraw, new DrawChangeListener<>(this, scenarioDraw));
      generationConstraints.getDrawKeyConstraint().put(scenarioDraw, defaultValue);
    });
  }

  public DrawChangeListener getDrawChangeListener(IDrawKeyIntegerValue scenarioDraw) {
    return drawChangeListenerMap.get(scenarioDraw);
  }

  @Override
  public void updateDrawKeyValue(IDrawKeyIntegerValue drawKey) {
    generationConstraints.getDrawKeyConstraint().put(drawKey, (Integer) utilityOptionRow.getDrawValue(drawKey));
  }
}
