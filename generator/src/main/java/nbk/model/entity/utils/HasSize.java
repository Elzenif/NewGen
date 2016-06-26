package nbk.model.entity.utils;

import nbk.model.entity.enums.ESize;

/**
 * Created by Germain on 26/06/2016.
 */
@FunctionalInterface
public interface HasSize {

  ESize getSize();
}
