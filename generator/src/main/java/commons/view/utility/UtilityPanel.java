package commons.view.utility;

import commons.model.commons.Game;
import commons.view.utils.DoublePanel;

/**
 * Created by Germain on 24/07/2016.
 */
public class UtilityPanel<G extends Game, S extends IAvailableUtilityRow<G>>
    extends DoublePanel<UtilityOptionRow, UtilityResultRow> {

  public UtilityPanel(S[] availableUtilityOptionRows) {
    super(availableUtilityOptionRows);
  }

}
