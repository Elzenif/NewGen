package commons.view.utility;

import commons.view.commons.DoublePanel;

/**
 * Created by Germain on 24/07/2016.
 */
public class UtilityPanel<T extends IAvailableUtilityRow>
    extends DoublePanel<UtilityOptionRow, UtilityResultRow> {

  public UtilityPanel(T[] availableUtilityOptionRows) {
    super(availableUtilityOptionRows);
  }

}
