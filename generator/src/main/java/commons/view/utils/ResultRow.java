package commons.view.utils;

import commons.view.commons.Result;

/**
 * Created by Germain on 24/09/2016.
 */
public abstract class ResultRow<T extends Result<S>, S> extends PanelRow {

  protected ResultRow() {
    super(Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP);
  }

  public abstract void clearResults();
}
