package pk.view.model;

/**
 * Created by Germain on 12/07/2017.
 */
@FunctionalInterface
public interface GetAllFunction {

  Object[] apply(Integer generationMin, Integer generationMax);
}
