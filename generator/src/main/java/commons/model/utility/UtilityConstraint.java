package commons.model.utility;

import com.google.common.collect.ForwardingMap;
import commons.model.commons.GenerationConstraint;
import commons.utils.MathUtils;
import commons.utils.exception.ForbiddenValueException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Germain on 01/10/2016.
 */
public class UtilityConstraint extends ForwardingMap<IUtilityDrawKey, Integer> implements GenerationConstraint {

  private final Map<IUtilityDrawKey, Integer> map = new HashMap<>();

  @Override
  protected Map<IUtilityDrawKey, Integer> delegate() {
    return map;
  }

  @Override
  public Integer put(IUtilityDrawKey key, Integer value) {
    checkRange(value);
    return delegate().put(key, value);
  }

  @Override
  public Integer get(Object key) {
    Integer result = delegate().get(key);
    return (result != null) ? result : MathUtils.random(1, 20);
  }

  private void checkRange(Integer value) {
    if (value < 1) {
      throw new ForbiddenValueException("Value should be greater than 1");
    }
    if (value > 20) {
      throw new ForbiddenValueException("Value should be less than 20");
    }
  }
}
