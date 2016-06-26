package nbk.model.entity.utils;

/**
 * Created by Germain on 26/06/2016.
 *
 * Define if the builder weight is LIGHT or HEAVY. NORMAL is the default if no one is used
 */
public interface WeightBuilder extends HasWeight {

  WeightBuilder lightWeight();

  WeightBuilder heavyWeight();
}
