package commons.view.utils;

import commons.model.commons.HasName;

/**
 * Created by Germain on 24/07/2016.
 */
public interface IAvailableRow<OR extends OptionRow<RR>, RR extends ResultRow> extends HasName<String> {

  OR getOptionRow();

  RR getResultRow();
}
