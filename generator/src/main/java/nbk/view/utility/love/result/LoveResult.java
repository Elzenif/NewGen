package nbk.view.utility.love.result;

import commons.view.utility.result.UtilityResult;
import nbk.model.utility.love.LoveModel;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 24/07/2016.
 */
public class LoveResult {

  private final List<UtilityResult> results;

  @SuppressWarnings("SpellCheckingInspection")
  public LoveResult(LoveModel loveModel) {
    results = new LinkedList<>();
    results.add(new LovePartResult("Le personnage "));
    results.add(new LovePartResult(loveModel.getActionSentence() + " "));
    results.add(new LovePartResult(loveModel.getTargetSentence()));
    results.add(new LovePartResult(" du partenaire avec "));
    results.add(new LovePartResult(loveModel.getToolSentence()));
    results.add(new LovePartResult(" dans la position "));
    results.add(new LovePartResult(loveModel.getPositionSentence()));
    results.add(new LovePartResult("(" + loveModel.getLoveScore() + ")"));
  }

  public Collection<UtilityResult> getResults() {
    return results;
  }
}
