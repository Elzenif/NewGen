package commons.view.commons.results;

/**
 * Created by Germain on 05/06/2016.
 */
@FunctionalInterface
public interface Result<T> {

  T getRawResult();
}
