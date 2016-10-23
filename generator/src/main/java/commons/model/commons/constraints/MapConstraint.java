package commons.model.commons.constraints;

import com.google.common.collect.ForwardingMap;
import commons.model.commons.IDrawKey;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Germain on 02/10/2016.
 */
public class MapConstraint extends ForwardingMap<IDrawKey, Object> {

  private final Map<IDrawKey, Object> map = new HashMap<>();

  MapConstraint() {
  }

  @Override
  protected Map<IDrawKey, Object> delegate() {
    return map;
  }
}
