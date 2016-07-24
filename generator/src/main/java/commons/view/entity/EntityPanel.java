package commons.view.entity;

import commons.model.commons.Game;
import commons.view.utils.DoublePanel;

/**
 * Created by Germain on 09/06/2016.
 */
public class EntityPanel<T extends Game, S extends IAvailableEntityRow<T>>
        extends DoublePanel<EntityOptionRow<T>, EntityResultRow> {

  public EntityPanel(S[] availableEntityOptionRows) {
    super(availableEntityOptionRows);
  }
}
