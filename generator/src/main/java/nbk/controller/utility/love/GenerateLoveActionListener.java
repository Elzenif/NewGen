package nbk.controller.utility.love;

import commons.controller.utility.UtilityController;
import commons.model.utility.constraints.DrawKeyConstraint;
import commons.view.utility.UtilityResultRow;
import commons.view.utility.result.UtilityResult;
import nbk.controller.utility.GenerateNbkUtilityActionListener;
import nbk.model.utility.love.Love;
import nbk.model.utility.love.constraints.ELoveDraw;
import nbk.view.utility.love.options.LoveOptionRow;
import nbk.view.utility.love.results.LoveResult;

import java.util.Collection;

/**
 * Created by Germain on 01/10/2016.
 */
public class GenerateLoveActionListener extends GenerateNbkUtilityActionListener<ELoveDraw> {

  public GenerateLoveActionListener(LoveOptionRow loveOptionRow, UtilityResultRow loveResultRow,
                                    UtilityController<ELoveDraw> loveController) {
    super(loveOptionRow, loveResultRow, loveController);
  }

  @Override
  protected Collection<UtilityResult> generateResult(DrawKeyConstraint constraint) {
    Love love = new Love(constraint);
    return new LoveResult(love).getResults();
  }
}
