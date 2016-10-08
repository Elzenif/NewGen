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
public enum ENbkAvailableUtilityRow implements IAvailableUtilityRow {

  LOVE_ROW(ENbkAvailableUtility.LOVE_ROLEPLAY, new LoveOptionRow()),
  SCENARIO_ROW(ENbkAvailableUtility.SCENARIO, new ScenarioOptionRow());

  private final IAvailableUtility<NbkGame> utility;
  private final UtilityOptionRow utilityOptionRow;
  private final UtilityResultRow utilityResultRow;

  ENbkAvailableUtilityRow(IAvailableUtility<NbkGame> utility, UtilityOptionRow utilityOptionRow) {
    this.utility = utility;
    this.utilityOptionRow = utilityOptionRow;
    this.utilityResultRow = new UtilityResultRow(utility.getName());
  }

  @Override
  public UtilityOptionRow getOptionRow() {
    return utilityOptionRow;
  }

  @Override
  public UtilityResultRow getResultRow() {
    return utilityResultRow;
  }

  @Override
  public String getName() {
    return utility.getName();
  }
}
