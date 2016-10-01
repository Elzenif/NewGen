package nbk.model.utility.love;

import commons.model.utility.UtilityConstraint;

import java.util.LinkedHashMap;
import java.util.Map;

import static nbk.model.utility.love.ELoveDraw.ACTION;
import static nbk.model.utility.love.ELoveDraw.LOVE_DRAW_NAME;
import static nbk.model.utility.love.ELoveDraw.POSITION;
import static nbk.model.utility.love.ELoveDraw.TARGET;
import static nbk.model.utility.love.ELoveDraw.TOOL;

/**
 * Created by Germain on 24/07/2016.
 */
public class Love {

  private final Map<ELoveDraw, ILoveDrawResult> loveDrawStringMap;

  public Love(UtilityConstraint constraint) {
    loveDrawStringMap = new LinkedHashMap<>();

    int action = constraint.get(ACTION);
    addSentence(ACTION, ELoveAction.valueOf(LOVE_DRAW_NAME + action));

    int target = constraint.get(TARGET);
    addSentence(TARGET, ELoveTarget.valueOf(LOVE_DRAW_NAME + target));

    int tool = constraint.get(TOOL);
    addSentence(TOOL, ELoveTool.valueOf(LOVE_DRAW_NAME + tool));

    int position = constraint.get(POSITION);
    addSentence(POSITION, ELovePosition.valueOf(LOVE_DRAW_NAME + position));
  }

  private void addSentence(ELoveDraw eLoveDraw, ILoveDrawResult iLoveDraw) {
    loveDrawStringMap.put(eLoveDraw, iLoveDraw);
  }

  public int getLoveScore() {
    return loveDrawStringMap.values().stream()
        .map(ILoveDrawResult::getLoveScore)
        .map(ELoveScore::getScore)
        .reduce(0, Integer::sum);
  }

  public String getPositionSentence() {
    return loveDrawStringMap.get(ELoveDraw.POSITION).getSentence();
  }

  public String getToolSentence() {
    return loveDrawStringMap.get(ELoveDraw.TOOL).getSentence();
  }

  public String getTargetSentence() {
    return loveDrawStringMap.get(ELoveDraw.TARGET).getSentence();
  }

  public String getActionSentence() {
    return loveDrawStringMap.get(ELoveDraw.ACTION).getSentence();
  }
}
