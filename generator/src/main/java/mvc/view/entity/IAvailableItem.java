package mvc.view.entity;

import mvc.model.commons.HasName;
import mvc.model.entity.game.*;
import org.jetbrains.annotations.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Germain on 11/06/2016.
 */
public interface IAvailableItem<T extends Game> extends HasName {

  EntityOptionRow<T> getEntityOptionRow();

  @NotNull
  static List<? extends IAvailableItem> getValues(Class<? extends IAvailableItem> clazz) {
    return Arrays.asList(clazz.getEnumConstants());
  }
}
