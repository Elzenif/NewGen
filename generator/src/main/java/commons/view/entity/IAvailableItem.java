package commons.view.entity;

import commons.model.commons.HasName;
import commons.model.entity.game.Game;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Germain on 11/06/2016.
 */
public interface IAvailableItem<T extends Game> extends HasName<String> {

  EntityOptionRow<T> getEntityOptionRow();

  @NotNull
  static List<? extends IAvailableItem> getValues(Class<? extends IAvailableItem> clazz) {
    return Arrays.asList(clazz.getEnumConstants());
  }
}
