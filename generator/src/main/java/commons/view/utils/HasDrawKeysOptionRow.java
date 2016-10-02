package commons.view.utils;

import nbk.model.commons.IDrawKey;

/**
 * Created by Germain on 02/10/2016.
 */
public interface HasDrawKeysOptionRow<K extends IDrawKey> {

  int getDrawValue(K drawKey);

}
