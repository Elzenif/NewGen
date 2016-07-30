package commons.view.utility;

import commons.model.commons.Game;
import commons.view.utils.DoublePanel;

/**
 * Created by Germain on 24/07/2016.
 */
public class UtilityPanel<T extends Game, S extends IAvailableUtilityRow<T>>
        extends DoublePanel<UtilityOptionRow<T>, UtilityResultRow> {

  public UtilityPanel(S[] availableUtilityOptionRows) {
    super(availableUtilityOptionRows);
  }

}
