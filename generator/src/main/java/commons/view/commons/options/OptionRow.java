package commons.view.commons.options;

import commons.view.commons.results.ResultRow;

/**
 * Created by Germain on 09/10/2016.
 */
public interface OptionRow<T extends ResultRow> {

  void setControllers(T resultRow);
}
