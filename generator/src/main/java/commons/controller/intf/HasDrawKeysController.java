package commons.controller.intf;

import commons.model.commons.IDrawKey;
import nbk.controller.utility.DrawChangeListener;

/**
 * Created by Germain on 02/10/2016.
 */
public interface HasDrawKeysController<K extends IDrawKey> {

  DrawChangeListener<K> getDrawChangeListener(K drawKey);

  void updateDrawKeyValue(K drawKey);

}
