package nbk.controller.utility.love;

import commons.model.dice.Dice;
import commons.model.dice.EDiceNumber;
import commons.view.utility.UtilityResultRow;
import nbk.model.utility.love.ELoveAction;
import nbk.model.utility.love.ELovePosition;
import nbk.model.utility.love.ELoveTarget;
import nbk.model.utility.love.ELoveTool;
import nbk.model.utility.love.LoveModel;
import nbk.view.utility.love.LoveOptionRow;
import nbk.view.utility.love.result.LoveResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static nbk.model.utility.love.ELoveDraw.ACTION;
import static nbk.model.utility.love.ELoveDraw.LOVE_DRAW_NAME;
import static nbk.model.utility.love.ELoveDraw.POSITION;
import static nbk.model.utility.love.ELoveDraw.TARGET;
import static nbk.model.utility.love.ELoveDraw.TOOL;

/**
 * Created by Germain on 24/07/2016.
 */
public class MakeLoveActionListener implements ActionListener {

  private final LoveOptionRow loveOptionRow;
  private final UtilityResultRow loveResultRow;

  public MakeLoveActionListener(LoveOptionRow loveOptionRow, UtilityResultRow loveResultRow) {
    this.loveOptionRow = loveOptionRow;
    this.loveResultRow = loveResultRow;
  }

  @SuppressWarnings("SpellCheckingInspection")
  @Override
  public void actionPerformed(ActionEvent e) {
    loveResultRow.clearResults();
    LoveModel loveModel = new LoveModel();
    int action, target, tool, position;
    if (loveOptionRow.isConstraintsCheckBoxSelected()) {
      action = loveOptionRow.getLoveDrawDiceScore(ACTION);
      target = loveOptionRow.getLoveDrawDiceScore(TARGET);
      tool = loveOptionRow.getLoveDrawDiceScore(TOOL);
      position = loveOptionRow.getLoveDrawDiceScore(POSITION);
    } else {
      Dice dice = new Dice(EDiceNumber.D20, 0, null);
      dice.roll();
      action = dice.getFinalScore();
      dice.roll();
      target = dice.getFinalScore();
      dice.roll();
      tool = dice.getFinalScore();
      dice.roll();
      position = dice.getFinalScore();
    }
    loveModel.addSentence(ACTION, ELoveAction.valueOf(LOVE_DRAW_NAME + action));
    loveModel.addSentence(TARGET, ELoveTarget.valueOf(LOVE_DRAW_NAME + target));
    loveModel.addSentence(TOOL, ELoveTool.valueOf(LOVE_DRAW_NAME + tool));
    loveModel.addSentence(POSITION, ELovePosition.valueOf(LOVE_DRAW_NAME + position));
    LoveResult loveResult = new LoveResult(loveModel);
    loveResultRow.setResultsToPrint(loveResult.getResults());

  }


}
