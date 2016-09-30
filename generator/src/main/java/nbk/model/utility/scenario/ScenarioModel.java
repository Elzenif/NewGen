package nbk.model.utility.scenario;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Germain on 30/09/2016.
 */
public class ScenarioModel {

  private final Map<EScenarioDraw, IScenarioDraw> scenarioDrawMap;

  public ScenarioModel() {
    scenarioDrawMap = new LinkedHashMap<>();
  }

  public void addSentence(EScenarioDraw eScenarioDraw, IScenarioDraw iScenarioDraw) {
    scenarioDrawMap.put(eScenarioDraw, iScenarioDraw);
  }

  public String getBeginningSentence() {
    return scenarioDrawMap.get(EScenarioDraw.BEGINNING).getSentence();
  }

  public String getGuySentence() {
    return scenarioDrawMap.get(EScenarioDraw.GUY).getSentence();
  }

  public String getQuestSentence() {
    return scenarioDrawMap.get(EScenarioDraw.QUEST).getSentence();
  }

  public String getLocationSentence() {
    return scenarioDrawMap.get(EScenarioDraw.LOCATION).getSentence();
  }

  public String getLootSentence() {
    return scenarioDrawMap.get(EScenarioDraw.LOOT).getSentence();
  }
}
