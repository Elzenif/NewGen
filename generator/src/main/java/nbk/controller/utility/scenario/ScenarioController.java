package nbk.controller.utility.scenario;

import commons.controller.utility.UtilityController;
import commons.view.utility.UtilityResultRow;
import nbk.controller.utility.DrawChangeListener;
import nbk.model.utility.scenario.constraints.EScenarioDraw;
import nbk.view.utility.scenario.ScenarioOptionRow;

import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 30/09/2016.
 */
public class ScenarioController extends UtilityController<EScenarioDraw> {

  private final EnumMap<EScenarioDraw, DrawChangeListener<EScenarioDraw>> drawChangeListenerMap
      = new EnumMap<>(EScenarioDraw.class);

  public ScenarioController(ScenarioOptionRow scenarioOptionRow, UtilityResultRow scenarioResultRow) {
    super(scenarioOptionRow);
    generateActionListener = new GenerateScenarioActionListener(scenarioOptionRow, scenarioResultRow, this);
    Arrays.stream(EScenarioDraw.values()).forEach(scenarioDraw -> {
      drawChangeListenerMap.put(scenarioDraw, new DrawChangeListener<>(this, scenarioDraw));
      generationConstraint.put(scenarioDraw, 1);
    });
  }

  public DrawChangeListener getDrawChangeListener(EScenarioDraw scenarioDraw) {
    return drawChangeListenerMap.get(scenarioDraw);
  }

  @Override
  public void updateDrawKeyValue(EScenarioDraw drawKey) {
    generationConstraint.put(drawKey, ((ScenarioOptionRow) utilityOptionRow).getDrawValue(drawKey));
  }
}
