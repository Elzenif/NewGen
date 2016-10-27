package commons.model.commons.constraints;

import com.google.common.collect.ForwardingMap;
import commons.model.commons.IDrawKeyIntegerValue;
import commons.utils.MathUtils;
import commons.utils.exception.ForbiddenValueException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Germain on 01/10/2016.
 */
public class DrawKeyConstraint extends ForwardingMap<IDrawKeyIntegerValue, Integer> {

  protected final Map<IDrawKeyIntegerValue, Integer> map = new HashMap<>();

  protected DrawKeyConstraint() {
  }

  @Override
  protected Map<IDrawKeyIntegerValue, Integer> delegate() {
    return map;
  }

  /**
   * @param key   the key (must implement IUtilityDrawKey)
   * @param value the value to store in the map. Must be between 1 and 20
   * @return the previous value for given key, null if there was not any
   */
  @Override
  public Integer put(IDrawKeyIntegerValue key, Integer value) {
    checkRange(key.getMaxValue(), value);
    return delegate().put(key, value);
  }

  /**
   * @param key the key (must implement IUtilityDrawKey)
   * @return the value stored in the map for the given key. If the key is not present, return a D20 roll
   */
  @Override
  public Integer get(Object key) {
    Integer result = delegate().get(key);
    return (result != null) ? result : MathUtils.random(1, 20);
  }

  private void checkRange(int maxValue, int value) {
    if (value < 1) {
      throw new ForbiddenValueException("Value should be greater than 1");
    }
    if (value > maxValue) {
      throw new ForbiddenValueException("Value should be less than 20");
    }
  }
}
