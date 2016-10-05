package commons.view.entity;

import commons.model.commons.Game;
import commons.view.utils.DoublePanel;

/**
 * Created by Germain on 09/06/2016.
 */
public class EntityPanel<G extends Game, S extends IAvailableEntityRow<G>>
    extends DoublePanel<EntityOptionRow<G>, EntityResultRow> {

  public EntityPanel(S[] availableEntityOptionRows) {
    super(availableEntityOptionRows);
  }
}
