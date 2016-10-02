package commons.view.utils;

import commons.model.commons.IDrawKey;

/**
 * Created by Germain on 02/10/2016.
 */
public interface HasDrawKeysOptionRow<K extends IDrawKey> {

  Object getDrawValue(K drawKey);

}
