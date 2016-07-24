package commons.view.entity;

import commons.model.commons.Game;
import commons.model.commons.HasName;
import commons.view.utils.IAvailableRow;

/**
 * Created by Germain on 11/06/2016.
 */
public interface IAvailableEntityRow<T extends Game>
        extends HasName<String>, IAvailableRow<EntityOptionRow<T>, EntityResultRow> {

}
