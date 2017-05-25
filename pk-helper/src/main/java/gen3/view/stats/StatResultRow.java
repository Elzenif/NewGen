package gen3.view.stats;

import commons.view.commons.results.StringResult;
import commons.view.commons.results.StringResultRow;

/**
 * Created by Germain on 06/04/2017.
 */
public class StatResultRow extends StringResultRow<StringResult> {

  protected StatResultRow(String labelText, boolean separateResultsWithComa, int hGap, int vGap) {
    super(labelText, separateResultsWithComa, hGap, vGap);
  }
}
