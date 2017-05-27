package generator.utils;

import commons.utils.MathUtils;
import commons.utils.exception.NoAvailableEntityTypeException;
import generator.model.entity.DDRandomEntity;

import java.util.List;

/**
 * Created by Germain on 27/05/2017.
 */
public class GeneratorUtils {

  public static <T extends DDRandomEntity> T findOne(List<T> randomEntities) throws NoAvailableEntityTypeException {
    int random = MathUtils.random(1, 100);
    return MathUtils.findFirstElementAcceptingThePredicate(randomEntities,
        e -> e.getPrcMin() <= random && e.getPrcMax() >= random);
  }

}
