package commons.view.entity;

import commons.model.commons.Game;
import commons.model.commons.HasName;

/**
 * Created by Germain on 11/06/2016.
 */
public interface IAvailableEntityOptionRow<T extends Game> extends HasName<String> {

  EntityOptionRow<T> getEntityOptionRow();
}
