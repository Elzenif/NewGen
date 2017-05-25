package gen3.view.stats;

import commons.view.commons.options.BorderLayoutOptionRow;

/**
 * Created by Germain on 06/04/2017.
 */
public class StatOptionRow extends BorderLayoutOptionRow<StatResultRow> {

  protected StatOptionRow(int labelSize, String name) {
    super(labelSize, name);
  }

  @Override
  public void setControllers(StatResultRow resultRow) {

  }
}
