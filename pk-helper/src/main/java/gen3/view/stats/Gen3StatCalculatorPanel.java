package gen3.view.stats;

import commons.controller.intf.Controller;
import commons.view.PkMainFrame;
import commons.view.commons.DoublePanel;
import commons.view.commons.IAvailableRow;

/**
 * Created by Germain on 06/04/2017.
 */
public class Gen3StatCalculatorPanel extends DoublePanel<StatOptionRow, StatResultRow, PkMainFrame>
    implements Controller<PkMainFrame> {

  protected Gen3StatCalculatorPanel(IAvailableRow<StatOptionRow, StatResultRow>[] availableRows) {
    super(availableRows);
  }
}
