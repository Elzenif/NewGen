package nbk.controller.utility.love;

import commons.controller.utility.UtilityController;
import commons.view.utility.UtilityResultRow;
import nbk.model.commons.NbkGame;
import nbk.model.utility.love.ELoveDraw;
import nbk.view.utility.love.LoveOptionRow;

/**
 * Created by Germain on 24/07/2016.
 */
public class LoveController extends UtilityController<NbkGame, ELoveDraw> {


  public LoveController(LoveOptionRow loveOptionRow, UtilityResultRow loveResultRow) {
    super(loveOptionRow);
    generateUtilityActionListener = new GenerateLoveActionListener(loveOptionRow, loveResultRow, this);
  }

  @Override
  public void updateDrawKeyValue(ELoveDraw drawKey) {
    utilityConstraint.put(drawKey, ((LoveOptionRow) utilityOptionRow).getDrawValue(drawKey));
  }
}
