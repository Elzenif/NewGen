package nbk.controller.utility.scenario;

import commons.model.dice.Dice;
import commons.model.dice.EDiceNumber;
import commons.view.utility.UtilityResultRow;
import nbk.model.utility.scenario.EScenarioBeginning;
import nbk.model.utility.scenario.EScenarioGuy;
import nbk.model.utility.scenario.EScenarioLocation;
import nbk.model.utility.scenario.EScenarioLoot;
import nbk.model.utility.scenario.EScenarioQuest;
import nbk.model.utility.scenario.ScenarioModel;
import nbk.view.utility.scenario.ScenarioOptionRow;
import nbk.view.utility.scenario.result.ScenarioResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static nbk.model.utility.scenario.EScenarioDraw.BEGINNING;
import static nbk.model.utility.scenario.EScenarioDraw.GUY;
import static nbk.model.utility.scenario.EScenarioDraw.LOCATION;
import static nbk.model.utility.scenario.EScenarioDraw.LOOT;
import static nbk.model.utility.scenario.EScenarioDraw.QUEST;
import static nbk.model.utility.scenario.EScenarioDraw.SCENARIO_DRAW_NAME;

/**
 * Created by Germain on 30/09/2016.
 */
public class GenerateScenarioActionListener implements ActionListener {

  private final ScenarioOptionRow scenarioOptionRow;
  private final UtilityResultRow scenarioResultRow;

  public GenerateScenarioActionListener(ScenarioOptionRow scenarioOptionRow, UtilityResultRow scenarioResultRow) {
    this.scenarioOptionRow = scenarioOptionRow;
    this.scenarioResultRow = scenarioResultRow;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    scenarioResultRow.clearResults();
    ScenarioModel scenarioModel = new ScenarioModel();
    int beginning, guy, quest, location, loot;
    if (scenarioOptionRow.isConstraintsCheckBoxSelected()) {
      beginning = scenarioOptionRow.getScenarioDrawDiceScore(BEGINNING);
      guy = scenarioOptionRow.getScenarioDrawDiceScore(GUY);
      quest = scenarioOptionRow.getScenarioDrawDiceScore(QUEST);
      location = scenarioOptionRow.getScenarioDrawDiceScore(LOCATION);
      loot = scenarioOptionRow.getScenarioDrawDiceScore(LOOT);
    } else {
      Dice dice = new Dice(EDiceNumber.D20, 0, null);
      dice.roll();
      beginning = dice.getFinalScore();
      dice.roll();
      guy = dice.getFinalScore();
      dice.roll();
      quest = dice.getFinalScore();
      dice.roll();
      location = dice.getFinalScore();
      dice.roll();
      loot = dice.getFinalScore();
    }
    scenarioModel.addSentence(BEGINNING, EScenarioBeginning.valueOf(SCENARIO_DRAW_NAME + beginning));
    scenarioModel.addSentence(GUY, EScenarioGuy.valueOf(SCENARIO_DRAW_NAME + guy));
    scenarioModel.addSentence(QUEST, EScenarioQuest.valueOf(SCENARIO_DRAW_NAME + quest));
    scenarioModel.addSentence(LOCATION, EScenarioLocation.valueOf(SCENARIO_DRAW_NAME + location));
    scenarioModel.addSentence(LOOT, EScenarioLoot.valueOf(SCENARIO_DRAW_NAME + loot));

    ScenarioResult scenarioResult = new ScenarioResult(scenarioModel);
    scenarioResultRow.setResultsToPrint(scenarioResult.getResults());
  }
}
