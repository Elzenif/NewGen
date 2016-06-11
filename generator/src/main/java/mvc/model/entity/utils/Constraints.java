package mvc.model.entity.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Germain on 11/06/2016.
 */
public class Constraints {

  // This is not pretty, but since it is not possible for a wildcard to extends multiple interfaces/classes...
  private final Map<Class<? extends ItemType>, GenericConstraint<? extends Enum<?>>> map;

  public Constraints() {
    map = new HashMap<>();
  }

  public <T extends Enum<T> & ItemType> void put(Class<T> clazz, GenericConstraint<T> constraint) {
    map.put(clazz, constraint);
  }

  @SuppressWarnings("unchecked")
  public <T extends Enum<T> & ItemType> GenericConstraint<T> get(Class<T> clazz) {
    if (map.containsKey(clazz))
      return (GenericConstraint<T>) map.get(clazz);
    else
      return new GenericConstraint<>();
  }
}
