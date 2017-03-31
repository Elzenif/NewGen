package commons.view.commons;

import commons.model.utils.HasName;
import commons.view.commons.options.OptionRow;
import commons.view.commons.results.ResultRow;

/**
 * Created by Germain on 24/07/2016.
 */
public interface IAvailableRow<OR extends OptionRow<RR>, RR extends ResultRow> extends HasName<String> {

  OR getOptionRow();

  RR getResultRow();
}
