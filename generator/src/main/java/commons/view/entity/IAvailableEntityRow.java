package commons.view.entity;

import commons.model.commons.Game;
import commons.view.utils.IAvailableRow;

/**
 * Created by Germain on 11/06/2016.
 */
public interface IAvailableEntityRow<T extends Game>
        extends IAvailableRow<EntityOptionRow<T>, EntityResultRow> {

}
