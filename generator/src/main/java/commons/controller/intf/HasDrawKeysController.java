package commons.controller.intf;

import commons.model.commons.IDrawKey;

/**
 * Created by Germain on 02/10/2016.
 */
public interface HasDrawKeysController<K extends IDrawKey> {

  void updateDrawKeyValue(K drawKey);

}