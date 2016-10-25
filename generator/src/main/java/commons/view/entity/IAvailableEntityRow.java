package commons.view.entity;

import commons.model.commons.Game;
import commons.view.commons.IAvailableRow;

/**
 * Created by Germain on 11/06/2016.
 */
public interface IAvailableEntityRow<G extends Game>
    extends IAvailableRow<EntityOptionRow<G>, EntityResultRow> {

}
