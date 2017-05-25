package commons.view.commons.results;

import java.util.Collection;

/**
 * Created by Germain on 09/10/2016.
 */
public interface ResultRow<T extends Result<S>, S> {

  void clearResults();

  /**
   * Display results content in the row
   *
   * @param results the results to display
   */
  void setResultsToPrint(Collection<T> results);
}
