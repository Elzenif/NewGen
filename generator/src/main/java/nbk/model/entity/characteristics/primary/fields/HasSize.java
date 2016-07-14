package nbk.model.entity.characteristics.primary.fields;

import nbk.model.entity.characteristics.primary.enums.ESize;

/**
 * Created by Germain on 26/06/2016.
 */
@FunctionalInterface
public interface HasSize {

  ESize getSize();
}
