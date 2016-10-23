package nbk.controller.utility.love;

import commons.controller.utility.UtilityController;
import commons.model.commons.constraints.GenerationConstraints;
import commons.view.utility.UtilityResultRow;
import commons.view.utility.result.UtilityResult;
import nbk.controller.utility.GenerateNbkUtilityActionListener;
import nbk.model.utility.love.Love;
import nbk.view.utility.love.options.LoveOptionRow;
import nbk.view.utility.love.results.LoveResult;

import java.util.Collection;

/**
 * Created by Germain on 01/10/2016.
 */
public class GenerateLoveActionListener extends GenerateNbkUtilityActionListener {

  public GenerateLoveActionListener(LoveOptionRow loveOptionRow, UtilityResultRow loveResultRow,
                                    UtilityController loveController) {
    super(loveOptionRow, loveResultRow, loveController);
  }

  @Override
  protected Collection<UtilityResult> generateResult(GenerationConstraints generationConstraints) {
    Love love = new Love(generationConstraints.getDrawKeyConstraint());
    return new LoveResult(love).getResults();
  }
}
