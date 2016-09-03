package nbk.model.entity.living.characteristics.primary;

import commons.utils.MathUtils;
import commons.utils.exception.StatNotInRangeException;

import java.util.EnumMap;

/**
 * Created by Germain on 29/08/2016.
 */
public class StatUtils {

  public static void setStat(EnumMap<EStat, Integer> statsMap, EStat stat, int value) throws StatNotInRangeException {
    if (value < 8 || value > 13)
      throw new StatNotInRangeException(value);
    statsMap.put(stat, value);
  }

  public static int randomStat() {
    return MathUtils.random(8, 13);
  }
}
