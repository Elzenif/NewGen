package nbk.model.entity.items.characteristics.primary.fields;

import nbk.model.entity.items.characteristics.primary.enums.ESize;

/**
 * Created by Germain on 26/06/2016.
 */
@FunctionalInterface
public interface HasSize {

  ESize getSize();
}
