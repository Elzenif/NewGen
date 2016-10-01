package nbk.view.utility;

import commons.model.utility.IAvailableUtility;
import commons.view.utility.IAvailableUtilityRow;
import commons.view.utility.UtilityOptionRow;
import commons.view.utility.UtilityResultRow;
import nbk.model.commons.NbkGame;
import nbk.model.utility.ENbkAvailableUtility;
import nbk.view.utility.love.LoveOptionRow;
import nbk.view.utility.scenario.ScenarioOptionRow;

/**
 * Created by Germain on 24/07/2016.
 */
public enum ENbkAvailableUtilityRow implements IAvailableUtilityRow<NbkGame> {

  LOVE_ROW(ENbkAvailableUtility.LOVE_ROLEPLAY) {
    final UtilityOptionRow utilityOptionRow = new LoveOptionRow();

    @Override
    public UtilityOptionRow getOptionRow() {
      return utilityOptionRow;
    }
  },
  SCENARIO_ROW(ENbkAvailableUtility.SCENARIO) {
    final UtilityOptionRow utilityOptionRow = new ScenarioOptionRow();

    @Override
    public UtilityOptionRow getOptionRow() {
      return utilityOptionRow;
    }
  };

  private final IAvailableUtility<NbkGame> utility;

  ENbkAvailableUtilityRow(IAvailableUtility<NbkGame> utility) {
    this.utility = utility;
  }

  @Override
  public UtilityResultRow getResultRow() {
    return new UtilityResultRow(utility.getName());
  }

  @Override
  public String getName() {
    return utility.getName();
  }
}
