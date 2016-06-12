package mvc.model.entity.utils;

import mvc.model.commons.HasName;
import mvc.model.entity.items.Item;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Germain on 11/06/2016.
 */
public interface IAvailableItem extends HasName {

  Class<? extends Item> getItemClass();

  static List<? extends IAvailableItem> getValues(Class<? extends IAvailableItem> clazz) {
    return Arrays.asList(clazz.getEnumConstants());
  }
}
