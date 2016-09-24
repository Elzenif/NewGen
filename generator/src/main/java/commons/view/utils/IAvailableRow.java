package commons.view.utils;

import commons.model.commons.HasName;

/**
 * Created by Germain on 24/07/2016.
 */
public interface IAvailableRow<O extends OptionRow<R>, R extends ResultRow> extends HasName<String> {

  O getOptionRow();
  R getResultRow();
}
