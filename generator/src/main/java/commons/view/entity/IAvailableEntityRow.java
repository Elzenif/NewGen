package commons.view.entity;

import commons.model.commons.Game;
import commons.model.commons.GenerationConstraint;
import commons.view.commons.IAvailableRow;

/**
 * Created by Germain on 11/06/2016.
 */
public interface IAvailableEntityRow<G extends Game, GC extends GenerationConstraint>
    extends IAvailableRow<EntityOptionRow<G, GC>, EntityResultRow> {

}
