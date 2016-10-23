package commons.view.entity;

import commons.model.commons.Game;
import commons.model.commons.GenerationConstraint;
import commons.view.commons.DoublePanel;

/**
 * Created by Germain on 09/06/2016.
 */
public class EntityPanel<G extends Game, S extends IAvailableEntityRow<G, GC>, GC extends GenerationConstraint>
    extends DoublePanel<EntityOptionRow<G, GC>, EntityResultRow> {

  public EntityPanel(S[] availableEntityOptionRows) {
    super(availableEntityOptionRows);
  }
}
