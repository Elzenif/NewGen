package commons.view.utility;

import commons.model.utility.constraints.IUtilityDrawKey;
import commons.view.utils.DoublePanel;

/**
 * Created by Germain on 24/07/2016.
 */
public class UtilityPanel<T extends IAvailableUtilityRow>
    extends DoublePanel<UtilityOptionRow<IUtilityDrawKey>, UtilityResultRow> {

  public UtilityPanel(T[] availableUtilityOptionRows) {
    super(availableUtilityOptionRows);
  }

}
