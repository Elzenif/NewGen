package nbk.controller.utility.love;

import commons.controller.utility.UtilityController;
import commons.model.utility.UtilityConstraint;
import commons.view.utility.UtilityResultRow;
import commons.view.utility.result.UtilityResult;
import nbk.controller.utility.GenerateNbkUtilityActionListener;
import nbk.model.utility.love.ELoveDraw;
import nbk.model.utility.love.Love;
import nbk.view.utility.love.LoveOptionRow;
import nbk.view.utility.love.result.LoveResult;

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
  protected Collection<UtilityResult> generateResult(UtilityConstraint constraint) {
    Love love = new Love(constraint);
    return new LoveResult(love).getResults();
  }
}
