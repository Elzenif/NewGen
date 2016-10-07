package commons.view.utils;

import commons.view.commons.Result;

import java.util.Collection;

/**
 * Created by Germain on 24/09/2016.
 */
public abstract class ResultRow<T extends Result<S>, S> extends PanelRow {

  protected ResultRow(int hGap, int vGap) {
    super(hGap, vGap);
  }

  public abstract void clearResults();

  /**
   * Display results content in the row
   *
   * @param results the results to display
   */
  public abstract void setResultsToPrint(Collection<T> results);
}
