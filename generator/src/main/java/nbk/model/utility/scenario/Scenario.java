package nbk.model.utility.scenario;

import commons.model.utility.UtilityConstraint;
import commons.utils.MathUtils;

import java.util.LinkedHashMap;
import java.util.Map;

import static nbk.model.utility.scenario.EScenarioDraw.BEGINNING;
import static nbk.model.utility.scenario.EScenarioDraw.GUY;
import static nbk.model.utility.scenario.EScenarioDraw.LOCATION;
import static nbk.model.utility.scenario.EScenarioDraw.LOOT;
import static nbk.model.utility.scenario.EScenarioDraw.QUEST;
import static nbk.model.utility.scenario.EScenarioDraw.SCENARIO_DRAW_NAME;

/**
 * Created by Germain on 30/09/2016.
 */
public class Scenario {

  private final Map<EScenarioDraw, IScenarioDrawResult> scenarioDrawMap;

  public Scenario(UtilityConstraint utilityConstraint) {
    scenarioDrawMap = new LinkedHashMap<>();

    int beginning = utilityConstraint.get(BEGINNING);
    if (beginning <= 10) beginning = 1;
    addSentence(BEGINNING, EScenarioBeginning.valueOf(SCENARIO_DRAW_NAME + beginning));

    int guy = utilityConstraint.get(GUY);
    addSentence(GUY, EScenarioGuy.valueOf(SCENARIO_DRAW_NAME + guy));

    int quest = utilityConstraint.get(QUEST);
    quest = MathUtils.floor((quest + 1) / 2);
    addSentence(QUEST, EScenarioQuest.valueOf(SCENARIO_DRAW_NAME + quest));

    int location = utilityConstraint.get(LOCATION);
    addSentence(LOCATION, EScenarioLocation.valueOf(SCENARIO_DRAW_NAME + location));

    int loot = utilityConstraint.get(LOOT);
    loot = MathUtils.floor((loot + 1) / 2);
    addSentence(LOOT, EScenarioLoot.valueOf(SCENARIO_DRAW_NAME + loot));
  }

  private void addSentence(EScenarioDraw eScenarioDraw, IScenarioDrawResult iScenarioDraw) {
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
