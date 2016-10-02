package commons.model.map.constraints;

import com.google.common.collect.ForwardingMap;
import commons.model.commons.GenerationConstraint;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Germain on 02/10/2016.
 */
public class MapConstraint<K extends IMapDrawKey> extends ForwardingMap<K, Object> implements GenerationConstraint {

  private final Map<K, Object> map = new HashMap<>();

  @Override
  protected Map<K, Object> delegate() {
    return map;
  }
}
