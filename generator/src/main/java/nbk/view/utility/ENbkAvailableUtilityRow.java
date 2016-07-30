package nbk.view.utility;

import commons.model.utility.IAvailableUtility;
import commons.view.utility.IAvailableUtilityRow;
import commons.view.utility.UtilityOptionRow;
import commons.view.utility.UtilityResultRow;
import nbk.model.commons.NbkGame;
import nbk.model.utility.ENbkAvailableUtility;
import nbk.view.utility.love.LoveOptionRow;

/**
 * Created by Germain on 24/07/2016.
 */
public enum ENbkAvailableUtilityRow implements IAvailableUtilityRow<NbkGame> {

  LOVE_ROW(ENbkAvailableUtility.LOVE_ROLEPLAY) {
    UtilityOptionRow<NbkGame> utilityOptionRow = new LoveOptionRow();
    @Override
    public UtilityOptionRow<NbkGame> getOptionRow() {
      return utilityOptionRow;
    }
  }
  ;

  private final IAvailableUtility<NbkGame> utility;

  ENbkAvailableUtilityRow(IAvailableUtility<NbkGame> utility) {
    this.utility = utility;
  }


  @Override
  public UtilityResultRow getResultRow() {
    return new UtilityResultRow(utility.getName());
  }
}
