package commons.view.entity;

import commons.model.commons.Game;
import commons.model.commons.HasName;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Germain on 11/06/2016.
 */
public interface IAvailableEntityOptionRow<T extends Game> extends HasName<String> {

  EntityOptionRow<T> getEntityOptionRow();

  @NotNull
  static List<? extends IAvailableEntityOptionRow> getValues(Class<? extends IAvailableEntityOptionRow> clazz) {
    return Arrays.asList(clazz.getEnumConstants());
  }
}
