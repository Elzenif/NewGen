package commons.model.dungeon.constraints;

import com.google.common.collect.ForwardingMap;
import commons.model.commons.GenerationConstraint;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Germain on 02/10/2016.
 */
public class DungeonConstraint<K extends IDungeonDrawKey> extends ForwardingMap<K, Integer> implements GenerationConstraint {

  private final Map<K, Integer> map = new HashMap<>();

  @Override
  protected Map<K, Integer> delegate() {
    return map;
  }
}
